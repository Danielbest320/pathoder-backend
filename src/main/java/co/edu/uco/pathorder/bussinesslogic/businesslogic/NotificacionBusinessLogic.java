package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;

public interface NotificacionBusinessLogic {

    void enviarNotificacionConfirmacionReserva(NotificacionDomain notificacionDomain) throws PathOrderException;

    void enviarNotificacionCancelacionReserva(NotificacionDomain notificacionDomain) throws PathOrderException;

    void enviarNotificacionReserva(NotificacionDomain notificacionDomain) throws PathOrderException;

    List<NotificacionDomain> consultarNotificaciones(NotificacionDomain notificacionDomain) throws PathOrderException;

}
