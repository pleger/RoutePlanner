package SelectTur;

import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static SelectTur.Main.*;

class TuristaFactory {

    private static final double PROMEDIO_PRESUPUESTO = 173.9222;
    private static final double DESVIACION_PRESUPUESTO = 90.75885;

    private static NormalDistribution ndp = new NormalDistribution(PROMEDIO_PRESUPUESTO, DESVIACION_PRESUPUESTO);


    static ArrayList<Turista> crearTuristas() {
        ArrayList<Turista> turistas = new ArrayList<Turista>();

   //     int[] ubicaciones = new int[NUMERO_AGENTES];
        boolean[][] preferencias = new boolean[NUMERO_AGENTES][NUMERO_PREFERENCIAS];

        int contadorUbicacion = 0;
        int contadorPreferencias = 0;
/*
        for (int i = 0; i < NUMERO_AGENTES; ++i) {

            double avanceAgentes = 1.0 * i / NUMERO_AGENTES;

            if (avanceAgentes >= UBICACIONES_INICIALES[1][contadorUbicacion]) {
                ++contadorUbicacion;
            }

            if (avanceAgentes >= PROBABILIDADES_PREFERENCIAS[3][contadorPreferencias]) {
                ++contadorPreferencias;
            }

            ubicaciones[i] = (int) UBICACIONES_INICIALES[0][contadorUbicacion];

            preferencias[i][0] = PROBABILIDADES_PREFERENCIAS[0][contadorPreferencias] == 1;
            preferencias[i][1] = PROBABILIDADES_PREFERENCIAS[1][contadorPreferencias] == 1;
            preferencias[i][2] = PROBABILIDADES_PREFERENCIAS[2][contadorPreferencias] == 1;
        }

        //ArrayList<Integer> ubicacionesList = new ArrayList<Integer>(Arrays.asList(ubicaciones));
/*
        /*
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, Arrays.stream(ints).boxed().toArray(Integer[]::new));
        */
/*
        List<Integer> ubicacionesList =  Arrays.stream(ubicaciones).boxed().collect(Collectors.toList());
        Collections.shuffle(ubicacionesList);

        for (int i = 0; i < NUMERO_AGENTES; ++i) {
            int ub = ubicacionesList.get(i);
            turistas.add(new Turista(getPresupuesto(), preferencias[i], ub));
        }


  */    int ubicacion = 0;

        for (int i = 0; i < NUMERO_AGENTES; ++i) {

            //double avanceAgentes = 1.0 * i / NUMERO_AGENTES;

            //if (avanceAgentes >= 0.5) {
            //    ubicacion = 9;
            //}



            if (contadorPreferencias > 7) {
                contadorPreferencias = 0;
                contadorUbicacion = 0;
            }

            ubicacion = UBICACIONES_INICIALES[contadorUbicacion];

            preferencias[i][0] = PROBABILIDADES_PREFERENCIAS[0][contadorPreferencias] == 1;
            preferencias[i][1] = PROBABILIDADES_PREFERENCIAS[1][contadorPreferencias] == 1;
            preferencias[i][2] = PROBABILIDADES_PREFERENCIAS[2][contadorPreferencias] == 1;

            turistas.add(new Turista(getPresupuesto(), preferencias[i], ubicacion));
            ++contadorPreferencias;
            ++contadorUbicacion;
        }

        return turistas;
    }

    private static double getPresupuesto() {

        double presupuesto = PROMEDIO_PRESUPUESTO;
        /*double presupuesto = ndp.sample();
        double maximo = PROMEDIO_PRESUPUESTO + DESVIACION_PRESUPUESTO;
        double minimo = PROMEDIO_PRESUPUESTO - DESVIACION_PRESUPUESTO;


        presupuesto = presupuesto > maximo ? maximo :
                presupuesto < minimo ? minimo :
                        presupuesto;*/


        return presupuesto * PERIODOS;
    }

}
