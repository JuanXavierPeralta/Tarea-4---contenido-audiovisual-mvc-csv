package controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.ContenidoAudiovisual;
import modelo.Pelicula;

public class ContenidoControladorTest {

    @Test
    public void agregarContenido_debeGuardarContenidoEnLaLista() {
        ContenidoControlador controlador = new ContenidoControlador();
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");

        controlador.agregarContenido(pelicula);

        assertTrue(controlador.hayContenidos());
        assertEquals(1, controlador.obtenerContenidos().size());
        assertEquals("Avatar", controlador.obtenerContenidos().get(0).getTitulo());
    }

    @Test
    public void cargarContenidos_debeReemplazarListaActual() {
        ContenidoControlador controlador = new ContenidoControlador();

        ArrayList<ContenidoAudiovisual> nuevosContenidos = new ArrayList<>();
        nuevosContenidos.add(new Pelicula("Superman", 123, "Accion", "DC Studios"));

        controlador.cargarContenidos(nuevosContenidos);

        assertEquals(1, controlador.obtenerContenidos().size());
        assertEquals("Superman", controlador.obtenerContenidos().get(0).getTitulo());
    }
}