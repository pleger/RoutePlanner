package SelectTur;

public class Turista {

    public final static int QUEDARSE = 0;
    public final static int MOVERSE = 1;
    public final static int SALIR = 2;

    private int estado;
    private double presupuesto;
    private int numper;
    private double tolerancia;
    private boolean [] atractivos;
    private double [] satisfaccion;

    public Provincia provincia;
    private MapaEspana espana;

    public Turista(int numper, double presupuesto, double tolerancia, boolean[] atractivos){
        this.estado = QUEDARSE;
        this.presupuesto = presupuesto;
        this.numper = numper;
        this.tolerancia = tolerancia;
        this.satisfaccion = satisfaccion; //todo calcular satisfaccion
        this.atractivos = atractivos;
        this.espana = espana;

    }

    public void mover(Provincia provincia) {
        this.provincia = provincia;
    }



    public boolean[] filtroPresupuesto(){
        boolean[] posibilidades = new boolean[MapaEspana.NUMPROVINCIAS];
        for (int i = 0; i < MapaEspana.NUMPROVINCIAS; ++i) {
            posibilidades[i] = presupuesto > (espana.getCostoTransporte(this.provincia.getCodigo(), i) + provincia.getCostoEstadia());
        }
        return posibilidades;
    }

    public boolean debeSalir() {
        boolean[] posibilidades = filtroPresupuesto();
        for (int i = 0; i < MapaEspana.NUMPROVINCIAS; ++i) {
            if (posibilidades[i]) {
                return false;
            }
        }

        this.estado = SALIR;
        return true;
    }

    private double compararAtractivos(int codigoProvincia){
        boolean[] posibilidades = filtroPresupuesto();
        double provAtractivos = 0;

        int contar = 0;
        for (boolean atractivo : atractivos) {
            contar += atractivo ? 1 : 0;
        }

        if (posibilidades[codigoProvincia]) {
            boolean[] pAtractivos = espana.getProvincia(codigoProvincia).getAtractivos();
            double s = 0;
            for (int g = 0; g < 5; ++g) {
                if (atractivos[g] == pAtractivos[g]) {
                    provAtractivos += 1.0 / contar;
                }
            }
        }
        return provAtractivos;
    }


    public int calcularSatisfaccion(){

        double k = 0;
        int provinciaMax = 0;
        double sMax = 0;

        for (int i = 0; i < MapaEspana.NUMPROVINCIAS; ++i) {
            double s = k * compararAtractivos(i); //todo: implementar formula de satisfaction

            if (s > sMax) {
                sMax = s;
                provinciaMax = i;
            }
        }
        System.out.print(provinciaMax);

        return provinciaMax;
    }

    public void accion(){

    }

    public int getEstado() {
        return estado;
    }
    public Provincia getProvincia() { return this.provincia; }
}
