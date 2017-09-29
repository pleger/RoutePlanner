import java.util.*;

package SelectTur;

public class Mapa {
    public static final int NUMPROVINCIAS = 23; //todo: hola
    public static final int MADRID = 0;

    private Vector<Destino> destinos;

    Mapa() {
        destinos = new Vector<Destino>();

        destinos.add(new Destino(MADRID,1,3,2));
        destinos.add(new Destino(MADRID,1,3,2));
        destinos.add(new Destino(MADRID,1,3,2));
    }

    public int[][] getDestinos() {
        int[][] atractivosdestinos = new int[NUMPROVINCIAS][5];
        for (int i = 0; i < NUMPROVINCIAS; ++i) {
            atractivosdestinos[i] = provincias[i].getAtractivos();
        }
        return atractivosdestinos;
    }




}
