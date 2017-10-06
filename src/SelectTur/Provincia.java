package SelectTur;

public class Provincia {

    private double aglomeración;
    private int codigo;
    private int maxEstadia;
    private double costoEstadia;
    private int habitantes;
    private int km2;
    private String nombre;
    private int comunidad;
    private boolean[] atractivos = new boolean[4];

    public Provincia(int codProvincia, int comunidad, int estadia, boolean[] atractivos, double costoEstadia, int habitantes, int km2){
        this.codigo = codProvincia;
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.maxEstadia = estadia;
        this.atractivos = atractivos;
        this.costoEstadia = costoEstadia;
        this.nombre = ProvinciaFactory.getName(codProvincia);
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
        //return super.toString();
    }








}