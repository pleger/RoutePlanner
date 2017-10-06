package SelectTur;

import java.util.Random;

public class Utils {

    public static Random random = new Random();

    public static double getTolerancia() {
        return 0.2 + random.nextDouble() * (0.28 - 0.2); //u = 0.25
    }


}
