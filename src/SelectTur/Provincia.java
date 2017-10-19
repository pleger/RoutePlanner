package SelectTur;

public class Provincia {

    private double aglomeración;
    private int codigo;
    private int maxEstadia;
    private double costoEstadia;
    private String nombre;
    private int comunidad;
    private boolean[] atractivos = new boolean[ProvinciaFactory.NUMERO_PREFERENCIAS];

    public Provincia(int codProvincia, int comunidad, int estadia, boolean[] atractivos, double costoEstadia){
        this.codigo = codProvincia;
        this.comunidad = comunidad;
        this.maxEstadia = estadia;
        this.atractivos = atractivos;
        this.costoEstadia = costoEstadia;
        this.nombre = ProvinciaFactory.getNombre(codProvincia);
    }

    public double getCostoEstadia() {
        return costoEstadia;
    }

    public int getCodigo() {
        return codigo;
    }
    public double getAglomeracion() { return this.aglomeración; }
    public int getEstadia() { return this.maxEstadia; }
    public String getNombre() { return this.nombre; }
    public int getComunidad() { return this.comunidad; }
    public boolean[] getAtractivos() { return this.atractivos; }


    @Override
    public String toString() {
        return getNombre();
    }

}
