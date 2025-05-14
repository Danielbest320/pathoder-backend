package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteFacade {

    void registrarNuevoCliente(ClienteDTO cliente);

    void modificarClienteExistente(UUID id, ClienteDTO cliente);

    void darbajaDefinitivamenteClienteExistente(UUID id);

    ClienteDTO consultarClientePorId(UUID id);

    List<ClienteDTO> consultarClientes(ClienteDTO filtro);

}
