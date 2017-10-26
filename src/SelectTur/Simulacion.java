package SelectTur;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulacion {

    private ArrayList<Turista> turistas;
    private int periodos;
    private HashMap<String, String> configuracion;
    private Bitacora bitacoraTotal;
    private String descripcion;

    Simulacion(int numeroAgentes, int periodos, String descripcion) {
        this.bitacoraTotal = new Bitacora();
        this.periodos = periodos;
        this.turistas = TuristaFactory.crearTuristas();

        this.configuracion = new HashMap<String, String>();
        this.descripcion = descripcion;

        configuracion.put("Periodos", "" + periodos);
        configuracion.put("NumeroAgentes", "" + numeroAgentes);
        configuracion.put("Descripcion", descripcion);
    }

    void ejecutar() {
        registrarRuta(0);

        for (int dia = 1; dia <= periodos; ++dia) {
            proximoPaso();
            registrarRuta(dia);
        }
        generarBitocoraTotal();
    }

    void generarExcel() {
        GeneradorDato.writeXLS(bitacoraTotal, configuracion, descripcion);
    }

    private void generarBitocoraTotal() {
        for (Turista turista : turistas) {
            bitacoraTotal.agregar(turista.obtenerBitacora());
        }
    }

    private void registrarRuta(int dia) {
        for (Turista tourista : turistas) {
            tourista.registrarBitacora(dia);
        }
    }

    private void proximoPaso() {
        for (Turista turista : turistas) {
            if (turista.estaActivo()) {
                turista.proximoPaso();
            }
        }
    }
}
