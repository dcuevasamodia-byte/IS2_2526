package es.unican.is2;

import java.util.List;

import es.unican.is2.Cliente;
import es.unican.is2.DataAccessException;
import es.unican.is2.IClientesDAO;
import es.unican.is2.IGestionClientes;
import es.unican.is2.IGestionSeguros;
import es.unican.is2.IInfoSeguros;
import es.unican.is2.ISegurosDAO;
import es.unican.is2.OperacionNoValida;
import es.unican.is2.Seguro;

public class GestionSeguros implements IGestionSeguros, IGestionClientes, IInfoSeguros {

    private ISegurosDAO segurosDAO;
    private IClientesDAO clientesDAO;

    public GestionSeguros(ISegurosDAO segurosDAO, IClientesDAO clientesDAO) {
        this.segurosDAO = segurosDAO;
        this.clientesDAO = clientesDAO;
    }

    @Override
    public Seguro nuevoSeguro(Seguro s, String dni) {
        return null;
    }

    @Override
    public Seguro bajaSeguro(String id, String dni) {
        return null;
    }

    @Override
    public Seguro anhadeConductorAdicional(String id, String dni) {
        return null;
    }

    @Override
    public Cliente nuevoCliente(Cliente c) throws DataAccessException {
        return null;
    }

    @Override
    public Cliente bajaCliente(String dni) throws OperacionNoValida, DataAccessException {
        return null;
    }

    @Override
    public Cliente cliente(String dni) throws DataAccessException {
        return null;
    }

    @Override
    public Seguro seguro(String matricula) throws DataAccessException {
        return null;
    }
}