package SelectTur;

import java.util.Vector;

public class TuristaFactory {


    public static Vector<Turista> crearTuristas(int numeroAgentes, double[][] ubicacionInicial) {
        Vector<Turista> turistas = new Vector<Turista>();

        int t = 0;
        int codigoInicial = (int) ubicacionInicial[t][0];

        for (int i = 1; i <= numeroAgentes; ++i) {
                 double k = 1.0*i/numeroAgentes;

                 if ( k >= ubicacionInicial[t][1]) {
                     t++;
                     codigoInicial = (int) ubicacionInicial[t][0];
                 }

                turistas.add(new Turista(Utils.getPresupuesto(), Utils.getAtractivos(), codigoInicial));
        }
        return turistas;
    }

}





