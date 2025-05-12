package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.UsuarioDomain;

import java.util.List;
import java.util.UUID;

public interface UsuarioBusinessLogic {

    void registrarNuevoUsuario(UsuarioDomain usuario);

    void modificarUsuarioExistente(UUID id, UsuarioDomain usuario);

    void darbajaDefinitivamenteUsuarioExistente(UUID id);

    UsuarioDomain consultarUsuarioPorId(UUID id);

    List<UsuarioDomain> consultarUsuarios(UsuarioDomain filtro);
}
