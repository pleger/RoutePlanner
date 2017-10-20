package SelectTur;

import java.util.Random;
import org.apache.commons.math3.distribution.NormalDistribution;

import static SelectTur.Main.PERIODOS;



public class Utils {

    private static double[] atractivos = new double[]{}; //todo: dar valores

    public static NormalDistribution ndp = new NormalDistribution(173.9222,90.75885);
    public static Random random = new Random();

    public static double getPresupuesto() {
        return ndp.sample()* PERIODOS;
    }






}
