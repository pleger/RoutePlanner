package SelectTur;

import java.util.ArrayList;
import java.util.List;

public class Bitacora {

    private List<List> records;
    

    public Bitacora(){
        records = new ArrayList<List>();
    }

    public void agregar(Bitacora bit) {
        for (int i = 0; i < bit.size(); ++i) {
            int touristaID = bit.obtenerTourista(i);
            int dia = bit.obtenerDia(i);
            int numper = bit.obtenerNumeroTourista(i);
            double presupuesto = bit.obtenerPresupuesto(i);
            double satisfaccion = bit.obtenerSatisfaccion(i);
            Provincia provincia = bit.obtenerProvidencia(i);

            agregar(touristaID,numper, dia, presupuesto,satisfaccion,provincia);
        }
    }

    public Provincia obtenerProvidencia(int i) {
        return (Provincia) (records.get(i).get(5));
    }

    public double obtenerSatisfaccion(int i) {
        return (Double) (records.get(i).get(4));
    }

    public double obtenerPresupuesto(int i) {
        return (Double) (records.get(i).get(3));
    }

    public int obtenerNumeroTourista(int i) {
        return (Integer) (records.get(i).get(2));
    }

    public int obtenerDia(int i) {
        return (Integer) (records.get(i).get(1));
    }

    public int obtenerTourista(int i) {
       return (Integer) (records.get(i).get(0));
    }

    public int size() {
        return records.size();
    }

    public void agregar(int touristaID, int dia, int numper, double presupuesto, double satisfaccion, Provincia provincia) {
        List<Object> record = new ArrayList<Object>();
        record.add(touristaID);
        record.add(dia);
        record.add(numper);
        record.add(presupuesto);
        record.add(provincia);
        record.add(satisfaccion);
        
        records.add(record);
    }
}
