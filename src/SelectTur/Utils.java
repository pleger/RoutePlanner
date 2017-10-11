package SelectTur;

import java.util.Random;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;


public class Utils {

    public static BinomialDistribution bda = new BinomialDistribution(5, 0.5);
    public static NormalDistribution ndp = new NormalDistribution(100.87,67.16);
    public static Random random = new Random();

    public static double getTolerancia() {
        return 0.2 + random.nextDouble() * (0.28 - 0.2); //u = 0.25
    }

    public static double getPresupuesto() {
        return ndp.sample();
    }

    public static boolean[] getAtractivos() {
        int[] arrInteger = bda.sample(5);
        boolean[] arrBoolean = new boolean[arrInteger.length];

        for (int i = 0; i < arrInteger.length; ++i) {
            arrBoolean[i] = arrInteger[i] == 1;
        }

        return arrBoolean;
    }




}
