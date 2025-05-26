package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;

public interface TipoNotificacionBusinessLogic {

    void crearTiposNotificacion(TipoNotificacionDomain tipoNotificacionDomain) throws PathOrderException;

    List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro) throws PathOrderException;

}
