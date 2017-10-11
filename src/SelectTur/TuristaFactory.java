package SelectTur;

import java.util.Vector;

public class TuristaFactory {

    private static final double[] tiposDeTuristas = new double[]{48.77, 43.14, 3.49, 3.17, 1.43};


    public static Vector<Turista> crearTuristas(int tamano) {
        Vector<Turista> turistas = new Vector<Turista>();

        for (int i = 0; i < tiposDeTuristas.length; ++i) {
            for (int j = 0; j < tiposDeTuristas[i] * tamano; ++j) {
                turistas.add(crearTurista(i));
            }
        }
        return turistas;
    }


    public static Turista crearTurista(int numeroPersonas) {
        return new Turista(numeroPersonas, Utils.getPresupuesto(), Utils.getTolerancia(), Utils.getAtractivos());
    }
}
