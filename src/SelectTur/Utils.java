package SelectTur;

import java.util.Random;
import org.apache.commons.math3.distribution.NormalDistribution;


public class Utils {

    public static NormalDistribution ndp = new NormalDistribution(100.87,67.16);
    public static Random random = new Random();

    public static double getTolerancia() {
        return 0.2 + random.nextDouble() * (0.28 - 0.2); //u = 0.25
    }

    public static double getPresupuesto() {
        return ndp.sample();

    }


}
