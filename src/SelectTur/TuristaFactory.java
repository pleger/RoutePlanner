package SelectTur;

public class TuristaFactory {




    public void asignarAtractivos(){
        this.atractivos = Utils.randomatract();
    }

    public void asignarTolerancia() {
        this.tolerancia = Utils.randomt();
    }

    public void asignarnumper() {
        this.numper = Utils.grupo();
    }

    public void asignarpresupuesto() {
        this.presupuesto = Utils.randomp();
    }
}
