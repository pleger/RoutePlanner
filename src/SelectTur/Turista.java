package SelectTur;

import java.util.Arrays;

import static SelectTur.MapaEspana.NUMPROVINCIAS;

public class Turista {

    public final static int QUEDARSE = 0;
    public final static int MOVERSE = 1;
    public final static int SALIR = 2;
    private static int userID = 0;

    private int id;
    private int estado;
    private double presupuesto;
    private boolean[] atractivos;
    private int ubicacion;
    private double satisfaccion; //todo: ???
    private Bitacora bitacora;

    private Provincia provincia;
    private MapaEspana espana; //todo: eliminar? donde es usado?

    public Turista(double presupuesto, boolean[] atractivos, int ubicacion) {
        this.estado = QUEDARSE;
        this.presupuesto = presupuesto;
        this.satisfaccion = 0; //todo calcular satisfaccion
        this.atractivos = atractivos;
        this.ubicacion = ubicacion;
        this.id = ++userID;
        this.bitacora = new Bitacora();
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void mover(Provincia provincia) {
        this.provincia = provincia;
    }


    public boolean[] filtroPresupuesto() {
        boolean[] posibilidades = new boolean[NUMPROVINCIAS];
        for (int i = 0; i < NUMPROVINCIAS; ++i) {
            posibilidades[i] = presupuesto > (espana.getCostoTransporte(this.provincia.getCodigo(), i) + provincia.getCostoEstadia());
        }
        return posibilidades;
    }

    public boolean debeSalir() {
        boolean[] posibilidades = filtroPresupuesto();
        for (int i = 0; i < NUMPROVINCIAS; ++i) {
            if (posibilidades[i]) {
                return false;
            }
        }

            //todo: sacar agente
        this.estado = SALIR;
        return true;
    }

    private double compararPreferencias(int codigoProvincia) {
        boolean[] posibilidades = filtroPresupuesto();
        double sumaPreferencias = 0;

        if (posibilidades[codigoProvincia]) {
            boolean[] pAtractivos = espana.getProvincia(codigoProvincia).getAtractivos();
            for (int g = 0; g < Main.PROBABILIDADES_PREFERENCIAS.length - 1; ++g) {
                if (atractivos[g] == pAtractivos[g]) {
                    sumaPreferencias += 1.0/3.0;
                }
            }
        }
        return sumaPreferencias;
    }

    public double calcularSatisfaccion(int codigo) {
        double k = 0;

        int codigoP = provincia.getCodigo();
        double satisfaccion = k * compararPreferencias(codigoP); //todo:falta lo demas;

        return satisfaccion;
    }

    public double[] calcularSatisfacciones() {
        double[] satisfacciones = new double[NUMPROVINCIAS];

        for (int i = 0; i < NUMPROVINCIAS; ++i) {
             satisfacciones[i] = calcularSatisfaccion(i);
         }
         return satisfacciones;
    }



    public int obtenerProximaProvincia() {
        int nprov = 0;
        int random = 0;
        int provinciaMax = ubicacion;

        double [][] sMax = new double[NUMPROVINCIAS][2];
        double[] satisfacciones = calcularSatisfacciones();

        for (int i = 0; i < NUMPROVINCIAS; ++i) {
            if (satisfaccion < satisfacciones[i]) {
                sMax [nprov][0] = i;
                sMax [nprov][1] = satisfacciones[i];
                nprov++;
            }
        }
        if (nprov == 1) {
            provinciaMax = (int) sMax[0][0];
        }
        else if (nprov > 1) {
            random = (int) (Math.random() * nprov);
            provinciaMax = (int) sMax[random][0];
        }
        return provinciaMax;
    }


    public void proximoPaso() {
        int codigoP = obtenerProximaProvincia();
        this.ubicacion = codigoP;
        //todo: mucho que hacer

    }

    public void registrarBitacora(int dia) {
        bitacora.agregar(hashCode(), dia, presupuesto, satisfaccion, atractivos, provincia);
    }

    public Bitacora obtenerBitacora() {
        return bitacora;
    }

    public int getEstado() {
        return estado;
    }

    public Provincia getProvincia() {
        return this.provincia;
    }
}
