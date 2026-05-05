import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.unican.is2.adt.IConjuntoOrdenado;

public class ConjuntoOrdenadoTest {

    private ConjuntoOrdenado<Integer> sut; // System Under Test

    @BeforeEach
    public void setUp() {
        // Inicializamos el conjunto antes de cada test
        sut = new ConjuntoOrdenado<Integer>();
    }

    @Test
    public void testAdd() {
        // CP1 Insertar en conjunto vacío
        assertTrue(sut.add(5));
        assertEquals(1, sut.size());

        sut.clear();
        sut.add(3);
        sut.add(5);
        sut.add(7);

        // CP2 Insertar menor
        assertTrue(sut.add(1));
        assertEquals(1, sut.get(0));

        // CP3 Insertar mayor
        assertTrue(sut.add(9));
        assertEquals(9, sut.get(sut.size() - 1));

        // CP4 Insertar intermedio
        assertTrue(sut.add(4));
        assertEquals(4, sut.get(2)); // Quedaría: {1, 3, 4, 5, 7, 9}

        // CP5 Insertar duplicado
        assertFalse(sut.add(5));

        // CP6 Insertar nulo
        assertThrows(NullPointerException.class, () -> sut.add(null));
    }

    @Test
    public void testGetAndRemove() {
        sut.add(10);
        sut.add(20);
        sut.add(30);

        // CP_Intermedio Elemento central
        assertEquals(20, sut.get(1));

        // CP7 Límite 0
        assertEquals(10, sut.get(0));

        // CP8 Límite N-1
        assertEquals(30, sut.get(2));

        // CP9 Límite -1
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(-1));

        // CP10 Límite N
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(3));

        // Comprobamos la eliminación
        assertEquals(20, sut.remove(1)); // Elimina el medio
        assertEquals(2, sut.size());
        assertEquals(10, sut.remove(0)); // Elimina el primero
    }

    @Test
    public void testSizeAndClear() {
        // CP11 Conjunto vacío
        assertEquals(0, sut.size());

        // CP12 Poblado
        sut.add(1);
        sut.add(2);
        sut.add(3);
        assertEquals(3, sut.size());

        // CP13 Clear en conjunto poblado
        sut.clear();
        assertEquals(0, sut.size());

        // CP14 Clear en conjunto vacío
        sut.clear(); // No debe fallar
        assertEquals(0, sut.size());
    }
}