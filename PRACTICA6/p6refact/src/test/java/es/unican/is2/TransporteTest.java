import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TransporteTest {

    @Test
    public void testConstructor() {

        // Casos validos
        Transporte sut = new Transporte(1, CategoriaTransporte.Mercancias, 1);
        // Refactor: Actualizadas las llamadas a los nuevos getters
        assertEquals(1, sut.getHoras());
        assertEquals(CategoriaTransporte.Mercancias, sut.getCategoria());
        assertEquals(1, sut.getTon());
        assertEquals(0, sut.getPersonas());
        
        sut = new Transporte(10, CategoriaTransporte.MercanciasPeligrosas, 1000);
        assertEquals(10, sut.getHoras());
        assertEquals(CategoriaTransporte.MercanciasPeligrosas, sut.getCategoria());
        assertEquals(1000, sut.getTon());
        assertEquals(0, sut.getPersonas());

        sut = new Transporte(10, CategoriaTransporte.Personas, 10);
        assertEquals(10, sut.getHoras());
        assertEquals(CategoriaTransporte.Personas, sut.getCategoria());
        assertEquals(10, sut.getPersonas());
        assertEquals(0, sut.getTon());

        // Casos no validos
        assertThrows(IllegalArgumentException.class, () -> new Transporte(0, CategoriaTransporte.Mercancias, 1));
        assertThrows(IllegalArgumentException.class, () -> new Transporte(10, CategoriaTransporte.Mercancias, 0));
        assertThrows(IllegalArgumentException.class, () -> new Transporte(10, null, 10));
    }
}