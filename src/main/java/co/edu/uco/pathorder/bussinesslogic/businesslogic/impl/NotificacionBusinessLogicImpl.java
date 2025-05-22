package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.NotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.NotificacionEntity;

import java.util.List;

public class NotificacionBusinessLogicImpl implements NotificacionBusinessLogic {

    private DAOFactory factory;

    public  NotificacionBusinessLogicImpl(DAOFactory factory) {
        this.factory=factory;
    }

    @Override
    public void enviarNotificacionConfirmacionReserva(NotificacionDomain notificacionDomain) {
        NotificacionEntity notificacionEntity = new NotificacionEntity();
        factory.getNotificacionDAO().create(notificacionEntity);
    }

    @Override
    public void enviarNotificacionCancelacionReserva(NotificacionDomain notificacionDomain) {
        NotificacionEntity notificacionEntity = new NotificacionEntity();
        factory.getNotificacionDAO().create(notificacionEntity);
    }

    @Override
    public void enviarNotificacionReserva(NotificacionDomain notificacionDomain) {
        NotificacionEntity notificacionEntity = new NotificacionEntity();
        factory.getNotificacionDAO().create(notificacionEntity);
    }

    @Override
    public List<NotificacionDomain> consultarNotificaciones(NotificacionDomain notificacionDomain) {
        NotificacionEntity NotificacionEntity = null;

        List<NotificacionEntity> tipoNotificacionEntities = factory.getNotificacionDAO().listByFilter(NotificacionEntity);
        List<NotificacionDomain> datosARetornar = null;
        return datosARetornar;
    }
}
