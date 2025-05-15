package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.NotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.NotificacionBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.NotificacionFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.NotificacionDTO;
import co.edu.uco.pathorder.entity.NotificacionEntity;

import java.util.List;

public class NotificacionFacadeImpl implements NotificacionFacade {

    private DAOFactory daoFactory;
    private NotificacionBusinessLogic notificacionBusinessLogic;

    public NotificacionFacadeImpl(DAOFactory factory) {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        notificacionBusinessLogic = new NotificacionBusinessLogicImpl(daoFactory);
    }


    @Override
    public void enviarNotificacionConfirmacionReserva(NotificacionDTO notificacionDTO) {

    }

    @Override
    public void enviarNotificacionCancelacionReserva(NotificacionDTO notificacionDTO) {

    }

    @Override
    public void enviarNotificacionReserva(NotificacionDTO notificacionDTO) {

    }

    @Override
    public List<NotificacionDTO> consultarNotificaciones(NotificacionDTO notificacionDTO) {
        return List.of();
    }
}
