package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ClienteDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface ClienteBusinessLogic {

    void registrarNuevoCliente(ClienteDomain cliente) throws PathOrderException;

    void modificarClienteExistente(UUID id, ClienteDomain cliente) throws PathOrderException;

    void darbajaDefinitivamenteClienteExistente(UUID id) throws PathOrderException;

    ClienteDomain consultarClientePorId(UUID id) throws PathOrderException;

    List<ClienteDomain> consultarClientes(ClienteDomain filtro) throws PathOrderException;

    }
