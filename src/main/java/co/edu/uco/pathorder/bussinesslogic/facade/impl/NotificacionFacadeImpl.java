package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.notificacion.dto.NotificacionDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.NotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.NotificacionBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.NotificacionFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.NotificacionDTO;

import java.util.List;

public class NotificacionFacadeImpl implements NotificacionFacade {

    private final DAOFactory daoFactory;
    private final NotificacionBusinessLogic notificacionBusinessLogic;

    public NotificacionFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        notificacionBusinessLogic = new NotificacionBusinessLogicImpl(daoFactory);
    }

    @Override
    public void enviarNotificacionConfirmacionReserva(NotificacionDTO notificacionDTO) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            NotificacionDomain domain = NotificacionDTOAssembler.getInstance().toDomain(notificacionDTO);
            notificacionBusinessLogic.enviarNotificacionConfirmacionReserva(domain);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ENVIAR una notificación de confirmación de reserva.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de enviar una notificación.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void enviarNotificacionCancelacionReserva(NotificacionDTO notificacionDTO) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            NotificacionDomain domain = NotificacionDTOAssembler.getInstance().toDomain(notificacionDTO);
            notificacionBusinessLogic.enviarNotificacionCancelacionReserva(domain);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ENVIAR una notificación de cancelación de reserva.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de enviar una notificación.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void enviarNotificacionReserva(NotificacionDTO notificacionDTO) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            NotificacionDomain domain = NotificacionDTOAssembler.getInstance().toDomain(notificacionDTO);
            notificacionBusinessLogic.enviarNotificacionReserva(domain);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ENVIAR una notificación de reserva.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de enviar una notificación.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<NotificacionDTO> consultarNotificaciones(NotificacionDTO filtro) throws PathOrderException {
        try {
            NotificacionDomain domainFilter = NotificacionDTOAssembler.getInstance().toDomain(filtro);
            var resultado = notificacionBusinessLogic.consultarNotificaciones(domainFilter);
            return NotificacionDTOAssembler.getInstance().toDTOs(resultado);
        } catch (PathOrderException e) {
            throw e;
        } catch (Exception e) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR notificaciones.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar notificaciones.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}