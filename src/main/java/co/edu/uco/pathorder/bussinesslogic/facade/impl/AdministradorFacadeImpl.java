package co.edu.uco.pathorder.bussinesslogic.facade.impl;


import co.edu.uco.pathorder.bussinesslogic.assembler.AdministradorAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.AdminisntradorBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.AdministradorFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.AdministradorDTO;

import java.util.List;
import java.util.UUID;

public class AdministradorFacadeImpl implements AdministradorFacade {

    private final DAOFactory daoFactory;
    private final AdministradorBusinessLogic administradorBusinessLogic;

    public AdministradorFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        administradorBusinessLogic = new AdminisntradorBusinessLogicImpl(daoFactory) ;
    }

    @Override
    public void registrarAdministrador(AdministradorDTO administrador) throws PathOrderException {
        daoFactory.abrirConexion();
        try {
            daoFactory.iniciartransaccion();

            AdministradorDomain domain = AdministradorAssembler.toDomain(administrador);
            administradorBusinessLogic.registrarAdministrador(domain);

            daoFactory.confirmartransaccion();

        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de REGISTRAR un nuevo administrador.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de registrar un administrador.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void actualizarInformacionAdministrador(UUID id, AdministradorDTO administrador) throws PathOrderException {
        daoFactory.abrirConexion();
        try {
            daoFactory.iniciartransaccion();

            AdministradorDomain domain = AdministradorAssembler.toDomain(administrador);
            administradorBusinessLogic.actualizarInformacionAdministrador(id, domain);

            daoFactory.confirmartransaccion();

        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de MODIFICAR un administrador existente.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de modificar un administrador.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void eliminarCuentaAdministrador(UUID id) throws PathOrderException {
        daoFactory.abrirConexion();
        try {
            daoFactory.iniciartransaccion();

            administradorBusinessLogic.eliminarCuentaAdministrador(id);

            daoFactory.confirmartransaccion();

        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de DAR DE BAJA definitivo a un administrador.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de dar de baja un administrador.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public AdministradorDTO consultarAdministradorPorId(UUID id) throws PathOrderException {
        daoFactory.abrirConexion();
        try {
            var AdministradorDomainResultado  = administradorBusinessLogic.consultarAdministradorPorId(id);
            return AdministradorAssembler.toDTO(AdministradorDomainResultado);
        } catch (PathOrderException e) {
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR un administrador por id.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar un administrador.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro) throws PathOrderException {
        daoFactory.abrirConexion();
        try {
            AdministradorDomain domainFilter = AdministradorAssembler.toDomain(filtro);
            var AdministradordomainResultado = administradorBusinessLogic.consultarAdministradores(domainFilter);
            return AdministradorAssembler.toDTOList(AdministradordomainResultado);
        } catch (PathOrderException e) {
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR administradores con filtro.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar administradores.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
