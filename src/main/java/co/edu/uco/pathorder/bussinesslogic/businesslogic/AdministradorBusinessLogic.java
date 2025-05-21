package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface AdministradorBusinessLogic {

    void registrarNuevoAdministrador(AdministradorDomain administrador) throws PathOrderException;

    void modificarAdministradorExistente(UUID id, AdministradorDomain administrador) throws PathOrderException;

    void darbajaDefinitivamenteAdministradorExistente(UUID id) throws PathOrderException;

    AdministradorDomain consultarAdministradorPorId(UUID id) throws PathOrderException;

    List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro) throws PathOrderException;

}
