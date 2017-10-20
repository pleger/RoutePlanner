package SelectTur;

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
        boolean[] posibilidades = new boolean[MapaEspana.NUMPROVINCIAS];
        for (int i = 0; i < MapaEspana.NUMPROVINCIAS; ++i) {
            posibilidades[i] = presupuesto > (espana.getCostoTransporte(this.provincia.getCodigo(), i) + provincia.getCostoEstadia());
        }
        return posibilidades;
    }

    public boolean debeSalir() {
        boolean[] posibilidades = filtroPresupuesto();
        for (int i = 0; i < MapaEspana.NUMPROVINCIAS; ++i) {
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

        int contar = 0;
        for (boolean atractivo : atractivos) {
            contar += atractivo ? 1 : 0;
        }

        if (posibilidades[codigoProvincia]) {
            boolean[] pAtractivos = espana.getProvincia(codigoProvincia).getAtractivos();
            for (int g = 0; g < Main.PROBABILIDADES_PREFERENCIAS.length; ++g) {
                if (atractivos[g] == pAtractivos[g]) {
                    sumaPreferencias += 1.0 / contar;
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
        double[] satisfacciones = new double[MapaEspana.NUMPROVINCIAS];

        for (int i = 0; i < MapaEspana.NUMPROVINCIAS; ++i) {
             satisfacciones[i] = calcularSatisfaccion(i);
         }
         return satisfacciones;
    }



    public int obtenerProximaProvincia() {
        double k = 0;
        int provinciaMax = 0;
        double sMax = 0;

        double[] satisfacciones = calcularSatisfacciones();

        for (int i = 0; i < MapaEspana.NUMPROVINCIAS; ++i) {
            if (sMax < satisfacciones[i]) {
                sMax = satisfacciones[i];
                provinciaMax = i;
            }
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
