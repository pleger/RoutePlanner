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
            double presupuesto = bit.obtenerPresupuesto(i);
            double satisfaccion = bit.obtenerSatisfaccion(i);
            Provincia provincia = bit.obtenerProvidencia(i);
            boolean[] atractivos = bit.obtenerAtractivos(i);

            agregar(touristaID, dia, presupuesto, satisfaccion, atractivos, provincia);
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

    public int obtenerDia(int i) {
        return (Integer) (records.get(i).get(1));
    }

    public int obtenerTourista(int i) {
       return (Integer) (records.get(i).get(0));
    }

    public boolean[] obtenerAtractivos(int i) {return (boolean[]) (records.get(i).get(5)); }

    public int size() {
        return records.size();
    }

    public void agregar(int touristaID, int dia, double presupuesto, double satisfaccion, boolean[] atractivos, Provincia provincia) {
        List<Object> record = new ArrayList<Object>();
        record.add(touristaID);
        record.add(dia);
        record.add(presupuesto);
        record.add(provincia);
        record.add(satisfaccion);
        record.add(atractivos);
        
        records.add(record);
    }
}
