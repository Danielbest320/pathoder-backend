package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteFacade {

    void registrarNuevoCliente(ClienteDTO cliente) throws PathOrderException;

    void modificarClienteExistente(UUID id, ClienteDTO cliente) throws PathOrderException;

    void darbajaDefinitivamenteClienteExistente(UUID id) throws PathOrderException;

    ClienteDTO consultarClientePorId(UUID id) throws PathOrderException;

    List<ClienteDTO> consultarClientes(ClienteDTO filtro) throws PathOrderException;

}
