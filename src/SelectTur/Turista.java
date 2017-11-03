package SelectTur;

import java.util.ArrayList;
import java.util.Random;

import static SelectTur.Main.NUMERO_PREFERENCIAS;
import static SelectTur.ProvinciaFactory.NUMERO_PROVINCIAS;
import static SelectTur.ProvinciaFactory.getNombre;

public class Turista {
    private static int userID = 0;

    private int id;
    private boolean activo;
    private double presupuesto;
    private boolean[] preferencias;
    private int ubicacion;
    private double satisfaccion; 
    private Bitacora bitacora;
    private boolean[] provFactibles;
    private int[] estadias;

    Turista(double presupuesto, boolean[] preferencias, int ubicacion) {
        this.activo = true;
        this.presupuesto = presupuesto;
        this.preferencias = preferencias;
        this.ubicacion = ubicacion;
        this.id = ++userID;
        this.bitacora = new Bitacora();

        provFactibles = new boolean[NUMERO_PROVINCIAS];
        estadias = new int[NUMERO_PROVINCIAS];

        for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
            provFactibles[i] = true;
            estadias[i] = 0;
        }

        this.satisfaccion = calcularPreferencias(ubicacion);
    }

    @Override
    public int hashCode() {
        return id;
    }

    private void filtroProvPorPresupuesto() {
        for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
            if (presupuesto < (ProvinciaFactory.getCostoTransporte(this.ubicacion, i) + ProvinciaFactory.getCostoEstadia(i))) {
                provFactibles[i] = false;
            }
        }
    }

    private void filtroProvPorEstadia() {
        for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
            if (estadias[i] == ProvinciaFactory.getMaxEstadia(i)) {
                provFactibles[i] = false;
            }
        }
    }

    private void filtrar() {
        filtroProvPorPresupuesto();
        filtroProvPorEstadia();
    }

    private void debeSalir() {
        for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
            if (provFactibles[i]) {
                this.activo = true;
                return;
            }
        }

        this.activo = false;
    }

    private double calcularPreferencias(int codigoProvincia) {
        double sumaPreferencias = 0.0;

        boolean[] provPreferencia = ProvinciaFactory.getPreferencias(codigoProvincia);

        for (int i = 0; i < NUMERO_PREFERENCIAS; ++i) {
            if (preferencias[i] == provPreferencia[i]) {
                sumaPreferencias += 1.0 / NUMERO_PREFERENCIAS;
            }
        }

        return sumaPreferencias; //min [0, 1]
    }

    private double[] calcularSatisfacciones() {
        double[] satisfacciones = new double[NUMERO_PROVINCIAS];

        for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
            if (provFactibles[i]) {
                satisfacciones[i] = calcularPreferencias(i);
            }
            else {
                satisfacciones[i] = -1.0;
            }

        }
        return satisfacciones;
    }


    private void registrarEstadia() {
       presupuesto -= ProvinciaFactory.getCostoEstadia(ubicacion);
       ++estadias[ubicacion];
    }

    private void pagarCostoTransporte(int origen, int destino) {
        presupuesto -= ProvinciaFactory.getCostoTransporte(origen, destino);

    }

    private int obtenerProximaProvincia() {

        double[] satisfacciones = calcularSatisfacciones();
        double sMax = satisfaccion;
        ArrayList<Integer> provinciasMax = new ArrayList<Integer>();

        for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
            sMax = satisfaccion < satisfacciones[i]? satisfacciones[i] : sMax;
        }

        for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
            if (sMax == satisfacciones[i])  {
                provinciasMax.add(i);
            }
        }

        int numprov = provinciasMax.size();

        if (numprov>1) {
            double[] costos = new double [numprov];
            int min = provinciasMax.get(0);
            for (int i = 0; i < numprov; ++i) {
                costos [i] = ProvinciaFactory.getCostoTransporte(ubicacion, i) + ProvinciaFactory.getCostoEstadia(i);
                if (i > 0 && costos [i] < costos [i-1]) {
                    min = provinciasMax.get(i);
                }
            }
        }

        else {
            sMax = provinciasMax.get(0);
        }

       // Random random = new Random();
       // return  sMax == satisfaccion && provFactibles[ubicacion]?  //todo: parche!!!
       //         ubicacion :
       //         provinciasMax.size() > 0 ? provinciasMax.get(random.nextInt(provinciasMax.size())) : ubicacion;
    }

    void proximoPaso() {
        registrarEstadia();

        filtrar();
        debeSalir();

        int futuraUbicacion = obtenerProximaProvincia();
        pagarCostoTransporte(ubicacion, futuraUbicacion);

        ubicacion = futuraUbicacion;
        satisfaccion = calcularPreferencias(ubicacion);

        System.out.println(toString());

    }


    private int obtenerEstadia(int codigo) {
        return estadias[codigo];
    }

    private boolean obtenerprovFactibles(int i) {
        return provFactibles[i];
    }
    private double obtenerSatisfacciones (int i) {
        double [] satisfacciones = calcularSatisfacciones();
        return satisfacciones[i];
    }

    void registrarBitacora(int dia) {
        bitacora.agregar(hashCode(), dia, presupuesto, satisfaccion, preferencias, ubicacion, activo);
    }

    Bitacora obtenerBitacora() {
        return bitacora;
    }

    boolean estaActivo() {
        return activo;
    }

    public String toString() {
       String text = "";
       text += id + " ";
       
       text += getNombre(ubicacion) + " ";
       text += obtenerEstadia(ubicacion)+ " ";
       text += ProvinciaFactory.getMaxEstadia(ubicacion)+ " ";
       text += estaActivo()+ " ";
       for (int i = 0; i < NUMERO_PROVINCIAS; ++i) {
           text += getNombre(i) + " ";
           text += obtenerprovFactibles(i)+ " ";
           text += obtenerSatisfacciones(i)+ " ";
       }
       return text;
    }
}
