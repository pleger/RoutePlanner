package SelectTur;

import java.util.ArrayList;
import java.util.List;

class Bitacora {

    private List<List> records;
    

    Bitacora(){
        records = new ArrayList<List>();
    }

    void agregar(Bitacora bit) {
        for (int i = 0; i < bit.size(); ++i) {
            int touristaID = bit.obtenerTourista(i);
            int dia = bit.obtenerDia(i);
            double presupuesto = bit.obtenerPresupuesto(i);
            double satisfaccion = bit.obtenerSatisfaccion(i);
            int provincia = bit.obtenerProvincia(i);
            boolean[] atractivos = bit.obtenerAtractivos(i);
            boolean activo = bit.obtenerActivo(i);

            agregar(touristaID, dia, presupuesto, satisfaccion, atractivos, provincia, activo);
        }
    }


    int obtenerTourista(int i) {
        return (Integer) (records.get(i).get(0));
    }

    int obtenerDia(int i) {
        return (Integer) (records.get(i).get(1));
    }

    double obtenerPresupuesto(int i) {
        return (Double) (records.get(i).get(2));
    }
    int obtenerProvincia(int i) {
        return (Integer) (records.get(i).get(3));
    }

    double obtenerSatisfaccion(int i) {
        return (Double) (records.get(i).get(4));
    }

    boolean[] obtenerAtractivos(int i) {return (boolean[]) (records.get(i).get(5)); }

    boolean obtenerActivo(int i) { return (Boolean) (records.get(i).get(6)); }

    int size() {
        return records.size();
    }

    void agregar(int touristaID, int dia, double presupuesto, double satisfaccion, boolean[] preferencias, int provincia, boolean activo) {
        List<Object> record = new ArrayList<Object>();

        record.add(touristaID);
        record.add(dia);
        record.add(presupuesto);
        record.add(provincia);
        record.add(satisfaccion);
        record.add(preferencias);
        record.add(activo);
        
        records.add(record);
    }
}
