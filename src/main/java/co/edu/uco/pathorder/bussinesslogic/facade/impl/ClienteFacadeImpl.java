package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.ClienteBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.ClienteFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public class ClienteFacadeImpl implements ClienteFacade {

    private DAOFactory daoFactory;
    private ClienteBusinessLogic clienteBusinessLogic;

    public ClienteFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        clienteBusinessLogic = new ClienteBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoCliente(ClienteDTO cliente) throws PathOrderException {

    }

    @Override
    public void modificarClienteExistente(UUID id, ClienteDTO cliente) throws PathOrderException {

    }

    @Override
    public void darbajaDefinitivamenteClienteExistente(UUID id) throws PathOrderException {

    }

    @Override
    public ClienteDTO consultarClientePorId(UUID id) throws PathOrderException {

        return null;
    }

    @Override
    public List<ClienteDTO> consultarClientes(ClienteDTO filtro) throws PathOrderException {

        return null;
    }
}
