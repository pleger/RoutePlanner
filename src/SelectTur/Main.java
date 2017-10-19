package SelectTur;

public class Main {

    public static final String DESCRIPCION = "SIMULACION";
    public static final int NUMERO_AGENTES = 300; //todo: numero de agentes
    public static final int PERIODOS = 30; //todo: cambiar a lo necesario
    public static final double[][] UBICACION = new double[][]{{20,9,16,0,8,15},{0.44,54.4,59.23,83.53,91.83,1}};
    public static final double[] PROBABILIDADES_PREFERENCE = new double[] {0.24, 0.8, 0.91};

    public static void main(String[] args) {

        Simulacion s = new Simulacion(NUMERO_AGENTES, PERIODOS, UBICACION, DESCRIPCION);
        s.ejecutar();
        s.generarExcel();

    }
}
