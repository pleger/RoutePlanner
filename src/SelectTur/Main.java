package SelectTur;

public class Main {

    public static final String DESCRIPCION = "SIMULACION";
    public static final int NUMERO_AGENTES = 300; //todo: numero de agentes
    public static final int PERIODOS = 30; //todo: cambiar a lo necesario
    public static final double[][] UBICACION = new double[][]{{20,9,16,0,8,15},{0.44,54.4,59.23,83.53,91.83,1}};
    public static final double[][] PROBABILIDADES_PREFERENCIAS = new double[][]{
            {1,1,1,1,0,0,0,0},
            {0,1,1,0,1,1,0,0},
            {0,0,1,1,0,1,1,0},
            {0.133,0.1738,0.3654,0.9128,0.9131,0.9168,0.9835,1}};

    public static void main(String[] args) {

        Simulacion s = new Simulacion(NUMERO_AGENTES, PERIODOS, UBICACION, DESCRIPCION);
        s.ejecutar();
        s.generarExcel();

    }
}
