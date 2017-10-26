package SelectTur;

public class Provincia {

    private int codigo;
    private int maxEstadia;
    private double costoEstadia;
    private String nombre;
    private int comunidad;
    private boolean[] preferencias = new boolean[Main.PROBABILIDADES_PREFERENCIAS.length];

    Provincia(int codProvincia, int comunidad, int estadia, boolean[] preferencias, double costoEstadia){
        this.codigo = codProvincia;
        this.comunidad = comunidad;
        this.maxEstadia = estadia;
        this.preferencias = preferencias;
        this.costoEstadia = costoEstadia;
        this.nombre = ProvinciaFactory.getNombre(codProvincia);
    }

    double getCostoEstadia() {
        return costoEstadia;
    }

    public int getCodigo() {
        return codigo;
    }
    int getEstadia() { return this.maxEstadia; }
    private String getNombre() { return this.nombre; }
    public int getComunidad() { return this.comunidad; }
    boolean[] getPreferencias() { return this.preferencias; }

    @Override
    public String toString() {
        return getNombre();
    }

}
