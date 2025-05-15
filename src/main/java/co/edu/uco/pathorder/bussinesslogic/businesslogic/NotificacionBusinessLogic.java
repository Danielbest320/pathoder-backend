package co.edu.uco.pathorder.bussinesslogic.businesslogic;

public interface NotificacionBusinessLogic {

    void enviarNotificacionConfirmacionReserva(NotificacionDomain notificacionDomain);

    void enviarNotificacionCancelacionReserva(NotificacionDomain notificacionDomain);

    void enviarNotificacionReserva(NotificacionDomain notificacionDomain);

    List<NotificacionDomain> consultarNotificaciones(NotificacionDomain notificacionDomain);

}
