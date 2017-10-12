package SelectTur;

public class Main {

    private static final int NUMERO_AGENTES = 300; //todo: numero de agentes
    private static final int PERIODOS = 30; //todo: cambiar a lo necesario


    public static void main(String[] args) {

        Simulacion s = new Simulacion(NUMERO_AGENTES, PERIODOS);
        s.ejecutar();



    }
}
