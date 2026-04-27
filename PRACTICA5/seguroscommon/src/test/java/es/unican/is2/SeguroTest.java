package es.unican.is2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class SeguroTest {
    
    private Seguro seguro;

    @BeforeEach
    public void setUp() {
        seguro = new Seguro();
    }

    @Test
    public void testGettersYSetters() {
        seguro.setId(1L);
        seguro.setMatricula("1234ABC");
        seguro.setPotencia(100);
        seguro.setCobertura(Cobertura.TODO_RIESGO); 
        seguro.setConductorAdicional("Pepe");
        
        LocalDate fecha = LocalDate.now();
        seguro.setFechaInicio(fecha);

        assertEquals(1L, seguro.getId());
        assertEquals("1234ABC", seguro.getMatricula());
        assertEquals(100, seguro.getPotencia());
        assertEquals(Cobertura.TODO_RIESGO, seguro.getCobertura());
        assertEquals("Pepe", seguro.getConductorAdicional());
        assertEquals(fecha, seguro.getFechaInicio());
    }

    @Test
    public void testPrecioSeguroFuturo() {
        seguro.setFechaInicio(LocalDate.now().plusDays(5));
        assertEquals(0.0, seguro.precio(), 0.01);
    }

    @Test
    public void testPrecioTodoRiesgoPotenciaBajaMasDeUnAno() {
        seguro.setCobertura(Cobertura.TODO_RIESGO);
        seguro.setPotencia(80); 
        seguro.setFechaInicio(LocalDate.now().minusYears(2)); 
        
        assertEquals(1000.0, seguro.precio(), 0.01);
    }

    @Test
    public void testPrecioTercerosLunasPotenciaMediaMenosDeUnAno() {
        seguro.setCobertura(Cobertura.TERCEROS_LUNAS);
        seguro.setPotencia(100); 
        seguro.setFechaInicio(LocalDate.now().minusMonths(6)); 
        
        assertEquals(504.0, seguro.precio(), 0.01);
    }

    @Test
    public void testPrecioTercerosPotenciaAltaMasDeUnAno() {
        seguro.setCobertura(Cobertura.TERCEROS);
        seguro.setPotencia(120); 
        seguro.setFechaInicio(LocalDate.now().minusYears(1).minusDays(1)); 
        
        assertEquals(480.0, seguro.precio(), 0.01);
    }
}