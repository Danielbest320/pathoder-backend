package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.*;

import java.util.List;

public interface NotificacionBusinessLogic {

    void enviarNotificacionConfirmacionReserva(NotificacionDomain notificacionDomain);

    void enviarNotificacionCancelacionReserva(NotificacionDomain notificacionDomain);

    void enviarNotificacionReserva(NotificacionDomain notificacionDomain);

    List<NotificacionDomain> consultarNotificaciones(NotificacionDomain notificacionDomain);

}
