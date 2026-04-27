package es.unican.is2;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.ClientesDAO;
import es.unican.is2.SegurosDAO;
import es.unican.is2.GestionSeguros;

public class VistaAgenteIT {

    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        IClientesDAO daoClientes = new ClientesDAO();
        ISegurosDAO daoSeguros = new SegurosDAO();
        GestionSeguros negocio = new GestionSeguros(daoSeguros, daoClientes);

        VistaAgente frame = GuiActionRunner.execute(() -> 
            new VistaAgente(negocio, negocio, negocio)
        );
        
        window = new FrameFixture(frame);
        window.show(); 
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testConsultaClienteExiste() {
        window.textBox("txtDNICliente").enterText("12345678A");
        
        window.button("btnBuscar").click();
        
        window.textBox("txtNombreCliente").requireText("Juan");
    }
    
    @Test
    public void testConsultaClienteNoExiste() {
        window.textBox("txtDNICliente").enterText("00000000X");
        
        window.button("btnBuscar").click();
        
        window.textBox("txtNombreCliente").requireText("Error en BBDD");
        window.textBox("txtTotalCliente").requireText("");
    }
}