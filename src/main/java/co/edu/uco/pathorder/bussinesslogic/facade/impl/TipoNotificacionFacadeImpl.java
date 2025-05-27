package co.edu.uco.pathorder.bussinesslogic.facade.impl;

//import co.edu.uco.pathorder.bussinesslogic.assembler.tiponotificacion.dto.TipoNotificacionDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.TipoNotificacionBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.TipoNotificacionFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.TipoNotificacionDTO;

import java.util.List;

public class TipoNotificacionFacadeImpl implements TipoNotificacionFacade {

    private final DAOFactory daoFactory;
    private final TipoNotificacionBusinessLogic tipoNotificacionBusinessLogic;

    public TipoNotificacionFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        tipoNotificacionBusinessLogic = new TipoNotificacionBusinessLogicImpl(daoFactory);
    }

    @Override
    public void crearTiposNotificacion(TipoNotificacionDTO tipoNotificacionDTO) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            TipoNotificacionDomain domain = null;
            tipoNotificacionBusinessLogic.crearTiposNotificacion(domain);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CREAR un tipo de notificación.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de crear un tipo de notificación.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<TipoNotificacionDTO> consultarTiposNotificacion(TipoNotificacionDTO filtro) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            TipoNotificacionDomain domainFilter = null;
            var resultado = tipoNotificacionBusinessLogic.consultarTiposNotificacion(domainFilter);

            daoFactory.confirmartransaccion();
            return null;
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR tipos de notificación.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar tipos de notificación.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}