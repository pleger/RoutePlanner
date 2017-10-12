package SelectTur;

import java.util.Vector;

public class Simulacion {

    private Vector<Turista> turistas;
    private int periodos;
    private MapaEspana espana;

    public Simulacion(int numeroAgentes, int periodos) {
        this.periodos = periodos;
        this.espana = new MapaEspana();
        this.turistas = TuristaFactory.crearTuristas(numeroAgentes);

        asignarComunidadTuristas();
        ejecutar();
    }

    public void ejecutar() {
        registrarRuta(0);  //todo: al inicio se registra la posicion inicial de todos los agentes

        for (int dia = 0; dia < periodos; ++dia) {
            proximoPaso();
            registrarRuta(dia); //todo: se registra cada ruta
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

    public void proximoPaso() {
        //todo: implementar cada paso
    }

}
