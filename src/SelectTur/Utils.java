package SelectTur;

import java.util.Random;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;


public class Utils {

    private static double[] atractivos = new double[]{}; //todo: dar valores

    public static NormalDistribution ndp = new NormalDistribution(173.9222,90.75885);
    public static Random random = new Random();

    public static double getPresupuesto() {
        return ndp.sample()*Main.PERIODOS;
    }

    public static boolean[] getAtractivos() {
        boolean[] atractivos = new boolean [Main.PROBABILIDADES_PREFERENCE.length];

        for (int i = 0; i < 3; ++i) {
            atractivos[i] = random.nextDouble() <= Main.PROBABILIDADES_PREFERENCE[i];
        }

        return atractivos;
    }




}
