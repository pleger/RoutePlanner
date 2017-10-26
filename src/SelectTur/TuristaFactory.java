package SelectTur;

import java.util.Vector;
import static SelectTur.Main.UBICACION;
import static SelectTur.Main.NUMERO_AGENTES;
import static SelectTur.Main.PROBABILIDADES_PREFERENCIAS;

public class TuristaFactory {



    public static Vector<Turista> crearTuristas() {
        Vector<Turista> turistas = new Vector<Turista>();
        boolean[] atractivos = new boolean [PROBABILIDADES_PREFERENCIAS.length];

        int t = 0;
        int a = 0;
        int codigoInicial = (int) UBICACION[t][0];
        atractivos[0] = PROBABILIDADES_PREFERENCIAS[0][a] == 1;
        atractivos[1] = PROBABILIDADES_PREFERENCIAS[1][a] == 1;
        atractivos[2] = PROBABILIDADES_PREFERENCIAS[2][a] == 1;

        for (int i = 1; i <= NUMERO_AGENTES; ++i) {
                 double k = 1.0*i/ NUMERO_AGENTES;

                 if ( k >= UBICACION[t][1]) {
                     t++;
                     codigoInicial = (int) UBICACION[t][0];
                 }

                 if ( k >= PROBABILIDADES_PREFERENCIAS[3][a]) {
                     a++;
                     atractivos[0] = PROBABILIDADES_PREFERENCIAS[0][a] == 1;
                     atractivos[1] = PROBABILIDADES_PREFERENCIAS[1][a] == 1;
                     atractivos[2] = PROBABILIDADES_PREFERENCIAS[2][a] == 1;
                 }

                 turistas.add(new Turista(Utils.getPresupuesto(), atractivos, codigoInicial));
        }
        return turistas;
    }
}
