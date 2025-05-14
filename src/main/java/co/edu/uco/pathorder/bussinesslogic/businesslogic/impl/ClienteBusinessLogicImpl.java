package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.ClienteBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.ClienteEntity;

import java.util.List;
import java.util.UUID;

public class ClienteBusinessLogicImpl implements ClienteBusinessLogic {

    private final DAOFactory factory;

    public ClienteBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoCliente(ClienteDomain cliente) {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().create(clienteEntity);
    }

    @Override
    public void modificarClienteExistente(UUID id, ClienteDomain cliente) {
        ClienteEntity clienteEntity = null;
        factory.getClienteDAO().update(id, clienteEntity);
    }

    @Override
    public void darbajaDefinitivamenteClienteExistente(UUID id) {
        factory.getClienteDAO().delete(id);
    }

    @Override
    public ClienteDomain consultarClientePorId(UUID id) {
        return null;
    }

    @Override
    public List<ClienteDomain> consultarClientes(ClienteDomain filtro) {
        ClienteEntity clienteFilter = null;
        List<ClienteEntity> clienteEntities = factory.getClienteDAO().listByFilter(clienteFilter);
        List<ClienteDomain> datosARetornar = null;

        return datosARetornar;
    }
}
