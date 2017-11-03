package SelectTur;

import static SelectTur.Main.DESCRIPCION;
import static SelectTur.Main.NUMERO_AGENTES;
import static SelectTur.Main.PERIODOS;

public class MainExperiment {

    private static final int NUMERO_SIMULACIONES = 10;

    public static void main(String[] args) {
        ProvinciaFactory.inicializar();

        Simulacion s = new Simulacion();

        for (int i = 0; i < NUMERO_SIMULACIONES; ++i) {
            s.reinit(NUMERO_AGENTES, PERIODOS, DESCRIPCION);
            s.ejecutar();
        }
        s.generarExcel();
    }

}
