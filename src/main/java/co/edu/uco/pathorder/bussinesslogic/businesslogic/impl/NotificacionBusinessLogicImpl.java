package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.notificacion.entity.NotificacionEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.NotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.NotificacionEntity;

import java.util.List;
import java.util.UUID;

public class NotificacionBusinessLogicImpl implements NotificacionBusinessLogic {

    private final DAOFactory factory;

    public NotificacionBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void enviarNotificacionConfirmacionReserva(NotificacionDomain notificacion) throws PathOrderException {
        validarIntegridadInformacionNotificacion(notificacion);
        var id = generarIdNotificacion();
        notificacion.setId(id);

        NotificacionEntity notificacionEntity = NotificacionEntityAssembler.getInstance().toEntity(notificacion);
        factory.getNotificacionDAO().create(notificacionEntity);
    }

    @Override
    public void enviarNotificacionCancelacionReserva(NotificacionDomain notificacion) throws PathOrderException {
        validarIntegridadInformacionNotificacion(notificacion);
        var id = generarIdNotificacion();
        notificacion.setId(id);

        NotificacionEntity notificacionEntity = NotificacionEntityAssembler.getInstance().toEntity(notificacion);
        factory.getNotificacionDAO().create(notificacionEntity);
    }

    @Override
    public void enviarNotificacionReserva(NotificacionDomain notificacion) throws PathOrderException {
        validarIntegridadInformacionNotificacion(notificacion);
        var id = generarIdNotificacion();
        notificacion.setId(id);

        NotificacionEntity notificacionEntity = NotificacionEntityAssembler.getInstance().toEntity(notificacion);
        factory.getNotificacionDAO().create(notificacionEntity);
    }

    @Override
    public List<NotificacionDomain> consultarNotificaciones(NotificacionDomain filtro) throws PathOrderException {
        NotificacionEntity notificacionEntity = NotificacionEntityAssembler.getInstance().toEntity(filtro);
        List<NotificacionEntity> notificacionEntities = factory.getNotificacionDAO().listByFilter(notificacionEntity);
        return NotificacionEntityAssembler.getInstance().toDomains(notificacionEntities);
    }

    private UUID generarIdNotificacion() throws PathOrderException {
        UUID id;
        boolean existeId;
        do {
            id = UtilUUID.generarNuevoUUID();
            var notificacion = factory.getNotificacionDAO().listById(id);
            existeId = !UtilUUID.esValorDefecto(notificacion.getId());
        } while (existeId);

        return id;
    }

    private void validarIntegridadInformacionNotificacion(NotificacionDomain notificacion) throws PathOrderException {
        validarFecha(notificacion.getFecha());
        validarTipoNotificacion(notificacion.getTipoNotificacion());
        validarReserva(notificacion.getReserva());
    }

    private void validarFecha(Object fecha) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(fecha)) {
            throw BusinessLogicPathOrderException.reportar("La fecha de la notificación es obligatoria");
        }
    }

    private void validarTipoNotificacion(TipoNotificacionDomain tipoNotificacion) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(tipoNotificacion)) {
            throw BusinessLogicPathOrderException.reportar("El tipo de notificación es obligatorio");
        }
    }

    private void validarReserva(Object reserva) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(reserva)) {
            throw BusinessLogicPathOrderException.reportar("La reserva asociada a la notificación es obligatoria");
        }
    }
}