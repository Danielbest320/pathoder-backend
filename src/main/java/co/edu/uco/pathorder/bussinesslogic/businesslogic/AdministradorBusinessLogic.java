package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;

import java.util.List;
import java.util.UUID;

public interface AdministradorBusinessLogic {

    void registrarNuevoAdministrador(AdministradorDomain administrador);

    void modificarAdministradorExistente(UUID id, AdministradorDomain administrador);

    void darbajaDefinitivamenteAdministradorExistente(UUID id);

    AdministradorDomain consultarAdministradorPorId(UUID id);

    List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro);

}
