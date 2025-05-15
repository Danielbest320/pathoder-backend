package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.TipoNotificacionDTO;

import java.util.List;

public interface TipoNotificacionFacade {

    void crearTiposNotificacion(TipoNotificacionDTO tipoNotificacionDTO);

    List<TipoNotificacionDTO> consultarTiposNotificacion(TipoNotificacionDTO filtro);

}
