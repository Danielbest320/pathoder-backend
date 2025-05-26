package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.TipoNotificacionDTO;

import java.util.List;

public interface TipoNotificacionFacade {

    void crearTiposNotificacion(TipoNotificacionDTO tipoNotificacionDTO) throws PathOrderException;

    List<TipoNotificacionDTO> consultarTiposNotificacion(TipoNotificacionDTO filtro) throws PathOrderException;

}
