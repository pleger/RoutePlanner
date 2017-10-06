package SelectTur;

public class Main_Mapa {
    public static final int NETWORK_SIZE = 300000;
    private static final int SEED_SIZE =  100; //(int) (NETWORK_SIZE*.001);
    private static final int SEED_TYPE = 3; /* average:1, expert:2, hub:3 */
    private static final int PERIODS = 30;

    public static void main(String[] args) {
        for (int type = 1; type <= SEED_TYPE; ++type) {
            Network network = new Network(NETWORK_SIZE, SEED_SIZE, PERIODS, type);
            network.generateDataByPeriod();
            System.out.println(network);
            network.run();
            Chart.show(network);
        }
        // write your code here
    }
}

