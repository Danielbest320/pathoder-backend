package co.edu.uco.pathorder.bussinesslogic.businesslogic;

public interface TipoNotificacionBusinessLogic {

    void crearTiposNotificacion(TipoNotificacionDomain tipoNotificacionDomain);

    List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro);

}
