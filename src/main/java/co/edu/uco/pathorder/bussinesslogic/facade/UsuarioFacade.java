package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.UsuarioDTO;

import java.util.List;
import java.util.UUID;

public interface UsuarioFacade {

    void registrarNuevoUsuario(UsuarioDTO usuario);

    void modificarUsuarioExistente(UUID id, UsuarioDTO usuario);

    void darbajaDefinitivamenteUsuarioExistente(UUID id);

    UsuarioDTO consultarUsuarioPorId(UUID id);

    List<UsuarioDTO> consultarUsuarios(UsuarioDTO filtro);
}
