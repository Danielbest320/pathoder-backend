package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;

import java.util.List;

public interface TipoNotificacionBusinessLogic {

    void crearTiposNotificacion(TipoNotificacionDomain tipoNotificacionDomain);

    List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro);

}
