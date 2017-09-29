package SelectTur;

public class Turista {

    public final static int QUEDARSE = 0;
    public final static int MOVERSE = 1;
    public final static int SALIR = 2;

    private int estado;
    private int ID;
    private double presupuesto;
    private int numper;
    private double tolerancia;
    private int [] atractivos;
    private double [] satisfaccion;
    private boolean [] posibilidades;
    private int ubicacion;

    public Turista(double presupuesto, int numper, double tolerancia, int [] atractivos, Mapa espana){
        this.estado = QUEDARSE;
        this.presupuesto = presupuesto;
        this.numper = numper;
        this.tolerancia = tolerancia;
        this.satisfaccion=satisfaccion; //todo calcular satisfaccion
        this.ubicacion = Mapa.MADRID;
        this.posibilidades = new boolean[Mapa.NUMPROVINCIAS];
        this.atractivos = new int [5];
    }

    public void filtro(){
        for (int i = 0; i < Mapa.NUMPROVINCIAS; ++i) {
            if (presupuesto < ((espana.getCostoTransporte(this.ubicacion, i) + espana.getCostoAlojamiento(this.ubicacion)))) {// todo: costo aloj i?
                posibilidades[i] = false; //todo: true or false
            }
        }
    }

    public boolean debeSalir() { //todo: re-implementar
        for (int i = 0; i < Mapa.NUMPROVINCIAS; ++i) {
            if (posibilidades[i]) {
                return false;
            }
        }
        this.estado = SALIR;
        return true;
    }

    public void compararAtractivos(){
        int [] cAtractivos = new int [Mapa.NUMPROVINCIAS];
        for (int i = 0; i <= 22; ++i) {
            if (posibilidades[i] == 0) {
                for (int g = 0; g <= getdatractivos[0].lenght; ++g) {
                    if (atractivos [g] == (espana.getdatractivos [i][g])) {
                          cAtractivos [i]=+(1/atractivos.length);
                    }
                }
            }
        }
    }


    public void calcularsatisfaccion(){
        double s = compararAtractivos(); //todo: implementar formula de satisfaction
    }


    public void accion(){

    }

    public int getEstado() {
        return estado;
    }
}
