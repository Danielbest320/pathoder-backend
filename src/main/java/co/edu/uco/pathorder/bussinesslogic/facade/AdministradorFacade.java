package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.AdministradorDTO;

import java.util.List;
import java.util.UUID;

public interface AdministradorFacade {

    void registrarNuevoAdministrador(AdministradorDTO administrador);

    void modificarAdministradorExistente(UUID id, AdministradorDTO administrador);

    void darbajaDefinitivamenteAdministradorExistente(UUID id);

    AdministradorDTO consultarAdministradorPorId(UUID id);

    List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro);
}