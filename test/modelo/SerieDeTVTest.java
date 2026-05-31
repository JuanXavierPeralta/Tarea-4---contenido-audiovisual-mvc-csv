package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SerieDeTVTest {

    @Test
    public void agregarTemporada_debeAgregarTemporadaALaSerie() {
        SerieDeTV serie = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);

        serie.agregarTemporada(1, 10, "17 de abril de 2011");

        assertEquals(1, serie.getListaTemporadas().size());
        assertEquals(1, serie.getListaTemporadas().get(0).getNumero());
        assertEquals(10, serie.getListaTemporadas().get(0).getNumeroEpisodios());
    }
}