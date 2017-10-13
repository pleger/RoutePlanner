package SelectTur;

import java.util.HashMap;
import java.util.Vector;

public class Simulacion {

    private Vector<Turista> turistas;
    private int periodos;
    private MapaEspana espana;
    private HashMap<String,String> configuracion;
    private Bitacora bitacoraTotal;
    private String descripcion;

    public Simulacion(int numeroAgentes, int periodos, String descripcion) {
        this.bitacoraTotal = new Bitacora();
        this.periodos = periodos;
        this.espana = new MapaEspana();
        this.turistas = TuristaFactory.crearTuristas(numeroAgentes);
        this.configuracion = new HashMap<String, String>();
        this.descripcion = descripcion;

        configuracion.put("Periodos", "" + periodos);
        configuracion.put("NumeroAgentes", "" + numeroAgentes);

        asignarComunidadTuristas();

    }

    public void ejecutar() {
        registrarRuta(0);  //todo: al inicio se registra la posicion inicial de todos los agentes

        for (int dia = 0; dia < periodos; ++dia) {
            proximoPaso();
            registrarRuta(dia); //todo: se registra cada ruta
        }

        generarBitocoraTotal();
    }

    public void generarExcel() {
        GeneradorDato.writeXLS(bitacoraTotal,configuracion, descripcion);
    }

    private void generarBitocoraTotal() {
        for (Turista turista : turistas) {
            bitacoraTotal.agregar(turista.obtenerBitacora());
        }
    }

    private void registrarRuta(int dia) {
        for (Turista tourista:turistas) {
            tourista.registrarBitacora(dia);
        }
    }

    private void asignarComunidadTuristas() {
        //todo: se debe asignar las comunidades iniciales a los turistas
    }

    public void proximoPaso() {      //todo:modificar
        for (Turista turista: turistas) {
            turista.proximoPaso();
        }
    }

    public HashMap<String, String> getConfiguracion() {
        return configuracion;
    }
}
