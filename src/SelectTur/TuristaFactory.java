package SelectTur;

import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static SelectTur.Main.*;

class TuristaFactory {

    private static final double mean = 173.9222;
    private static final double sd = 90.75885;

    private static NormalDistribution ndp = new NormalDistribution(mean, sd);


    static ArrayList<Turista> crearTuristas() {
        ArrayList<Turista> turistas = new ArrayList<Turista>();

        int[] ubicaciones = new int[NUMERO_AGENTES];
        boolean[][] preferencias = new boolean[NUMERO_AGENTES][NUMERO_PREFERENCIAS];

        int contadorUbicacion = 0;
        int contadorPreferencias = 0;

        for (int i = 0; i < NUMERO_AGENTES; ++i) {

            double avanceAgentes = 1.0 * i / NUMERO_AGENTES;

            if (avanceAgentes >= UBICACIONES_INICIALES[contadorUbicacion][1]) {
                ++contadorUbicacion;
            }

            if (avanceAgentes >= PROBABILIDADES_PREFERENCIAS[3][contadorPreferencias]) {
                ++contadorPreferencias;
            }

            ubicaciones[i] = (int) UBICACIONES_INICIALES[contadorUbicacion][0];

            preferencias[i][0] = PROBABILIDADES_PREFERENCIAS[0][contadorPreferencias] == 1;
            preferencias[i][1] = PROBABILIDADES_PREFERENCIAS[1][contadorPreferencias] == 1;
            preferencias[i][2] = PROBABILIDADES_PREFERENCIAS[2][contadorPreferencias] == 1;
        }

        Collections.shuffle(Arrays.asList(ubicaciones));

        for (int i = 0; i < NUMERO_AGENTES; ++i) {
            turistas.add(new Turista(getPresupuesto(), preferencias[i], ubicaciones[i]));
        }

        return turistas;
    }

    private static double getPresupuesto() {

        double presupuesto = ndp.sample() * PERIODOS;

        if (presupuesto > (mean + sd) * PERIODOS) {presupuesto = (mean + sd) * PERIODOS;}

        else if (presupuesto < (mean - sd) * PERIODOS) {presupuesto = (mean - sd) * PERIODOS;}

        return presupuesto;
    }

}
