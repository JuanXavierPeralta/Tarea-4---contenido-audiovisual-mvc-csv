package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PeliculaTest {

    @Test
    public void agregarActor_debeAgregarActorALaPelicula() {
        Pelicula pelicula = new Pelicula("Spiderman", 123, "Accion", "Marvel");
        Actor actor = new Actor("Tom Holland", 32, "Peter Parker");

        pelicula.agregarActor(actor);

        assertEquals(1, pelicula.getActores().size());
        assertEquals("Tom Holland", pelicula.getActores().get(0).getNombre());
        assertEquals("Peter Parker", pelicula.getActores().get(0).getPersonaje());
    }
}