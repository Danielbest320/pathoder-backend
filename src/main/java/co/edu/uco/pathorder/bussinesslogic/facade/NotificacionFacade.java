package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.NotificacionDTO;
import java.util.List;

public interface NotificacionFacade {

    void enviarNotificacionConfirmacionReserva(NotificacionDTO notificacionDTO);

    void enviarNotificacionCancelacionReserva(NotificacionDTO notificacionDTO);

    void enviarNotificacionReserva(NotificacionDTO notificacionDTO);

    List<NotificacionDTO> consultarNotificaciones(NotificacionDTO notificacionDTO);

}
