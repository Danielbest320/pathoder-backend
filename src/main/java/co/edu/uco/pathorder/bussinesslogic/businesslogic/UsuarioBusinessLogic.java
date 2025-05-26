package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface UsuarioBusinessLogic {

    void registrarNuevoUsuario(UsuarioDomain usuario) throws PathOrderException;

    void modificarUsuarioExistente(UUID id, UsuarioDomain usuario) throws PathOrderException;

    void darbajaDefinitivamenteUsuarioExistente(UUID id) throws PathOrderException;

    UsuarioDomain consultarUsuarioPorId(UUID id);

    List<UsuarioDomain> consultarUsuarios(UsuarioDomain filtro) throws PathOrderException;
}
