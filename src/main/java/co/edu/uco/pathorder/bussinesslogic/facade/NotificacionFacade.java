package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.NotificacionDTO;

import java.util.List;

public interface NotificacionFacade {

    void enviarNotificacionConfirmacionReserva(NotificacionDTO notificacionDTO) throws PathOrderException;

    void enviarNotificacionCancelacionReserva(NotificacionDTO notificacionDTO) throws PathOrderException;

    void enviarNotificacionReserva(NotificacionDTO notificacionDTO) throws PathOrderException;

    List<NotificacionDTO> consultarNotificaciones(NotificacionDTO notificacionDTO) throws PathOrderException;

}
