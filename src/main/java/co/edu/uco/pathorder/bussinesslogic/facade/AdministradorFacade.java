package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.AdministradorDTO;

import java.util.List;
import java.util.UUID;

public interface AdministradorFacade {

    void registrarAdministrador(AdministradorDTO administrador) throws PathOrderException;

    void actualizarInformacionAdministrador(UUID id, AdministradorDTO administrador) throws PathOrderException;

    void eliminarCuentaAdministrador(UUID id) throws PathOrderException;

    AdministradorDTO consultarAdministradorPorId(UUID id) throws PathOrderException;

    List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro) throws PathOrderException;
}