package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ClienteDomain;

import java.util.List;
import java.util.UUID;

public interface ClienteBusinessLogic {

    void registrarNuevoCliente(ClienteDomain cliente);

    void modificarClienteExistente(UUID id, ClienteDomain cliente);

    void darbajaDefinitivamenteClienteExistente(UUID id);

    ClienteDomain consultarClientePorId(UUID id);

    List<ClienteDomain> consultarClientes(ClienteDomain filtro);

    }
