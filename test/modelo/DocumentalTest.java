package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DocumentalTest {

    @Test
    public void agregarInvestigador_debeAgregarInvestigadorAlDocumental() {
        Documental documental = new Documental("Cosmos", 45, "Science", "Astronomy");
        Investigador investigador = new Investigador(
                "Neil deGrasse Tyson",
                "Astrofisica",
                "Hayden Planetarium"
        );

        documental.agregarInvestigador(investigador);

        assertEquals(1, documental.getInvestigadores().size());
        assertEquals("Neil deGrasse Tyson", documental.getInvestigadores().get(0).getNombre());
        assertEquals("Astrofisica", documental.getInvestigadores().get(0).getArea());
    }
}