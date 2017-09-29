package SelectTur;

public class Destino {

    private double aglomeración;
    private int estadia;
    private int habitantes;
    private int nombre;
    private int comunidad;
    private boolean[] atractivos = new boolean[4];

    public Destino(int nombre, int comunidad, int estadia, boolean[] atractivos){
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.estadia = estadia;
        this.atractivos = atractivos;

    }

    @Override
    public String toString() {
        return DestinoFactory.getName(nombre);
        //return super.toString();
    }
}
}