package es.unican.is2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClienteTest {
    
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        
        cliente.setNombre("Juan");
        cliente.setDni("12345678A");
        cliente.setMinusvalia(true);
    }
    
    @Test
    public void testTotalSegurosSinSeguros() {
        assertEquals(0.0, cliente.totalSeguros(), 0.01);
    }
}