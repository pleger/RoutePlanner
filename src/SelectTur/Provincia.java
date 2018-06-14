package SelectTur;

public class Provincia {

    private int codigo;
    private int maxEstadia;
    private double costoEstadia;
    private String nombre;
    private int comunidad;
    private double[] preferencias = new double[Main.PROBABILIDADES_PREFERENCIAS.length];

    Provincia(int codProvincia, int comunidad, int estadia, double[] preferencias, double costoEstadia){
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
    double[] getPreferencias() { return this.preferencias; }

    @Override
    public String toString() {
        return getNombre();
    }

}
