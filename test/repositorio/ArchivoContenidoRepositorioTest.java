package repositorio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.ContenidoAudiovisual;

public class ArchivoContenidoRepositorioTest {

    @Test
    public void cargar_debeLeerContenidosDesdeCsv() {
        ContenidoRepositorio repositorio = new ArchivoContenidoRepositorio();

        ArrayList<ContenidoAudiovisual> contenidos = repositorio.cargar();

        assertNotNull(contenidos);
        assertFalse(contenidos.isEmpty());
    }
}