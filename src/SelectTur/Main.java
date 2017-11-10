package SelectTur;

public class Main {

    static final String DESCRIPCION = "SIMULACION";
    static final int NUMERO_AGENTES = 16;  //18000
    static final int PERIODOS = 22;

    static final double[][] UBICACIONES_INICIALES = new double[][]{
            {ProvinciaFactory.ALAVA, ProvinciaFactory.BARCELONA, ProvinciaFactory.ACORUNA,
                    ProvinciaFactory.MADRID, ProvinciaFactory.SEVILLA, ProvinciaFactory.VALENCIA},
            {0.0044, 0.544, 0.5923,
                    0.8353, 0.9183, 1}};

    static final double[][] PROBABILIDADES_PREFERENCIAS = new double[][]{
            {1, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 0},
            {0, 0, 1, 1, 0, 1, 1, 0},
            {0.133, 0.1738, 0.3654, 0.9128, 0.9131, 0.9168, 0.9835, 1}};

    static final int NUMERO_PREFERENCIAS = PROBABILIDADES_PREFERENCIAS.length - 1;

    public static void main(String[] args) {
        ProvinciaFactory.inicializar();

        Simulacion s = new Simulacion(NUMERO_AGENTES, PERIODOS, DESCRIPCION);
        s.ejecutar();
        s.generarExcel();
    }
}
