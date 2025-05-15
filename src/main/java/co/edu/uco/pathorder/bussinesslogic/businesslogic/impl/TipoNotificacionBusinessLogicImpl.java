package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.AdministradorEntity;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;

import java.util.List;

public class TipoNotificacionBusinessLogicImpl implements TipoNotificacionBusinessLogic {

    private final DAOFactory factory;

    public TipoNotificacionBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearTiposNotificacion(TipoNotificacionDomain tipoNotificacionDomain) {
        TipoNotificacionEntity tipoNotificacionEntity = new TipoNotificacionEntity();
        factory.getTipoNotificacionDAO().create(tipoNotificacionEntity);
    }

    @Override
    public List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro) {
        TipoNotificacionEntity tipoNotificacionEntity = new TipoNotificacionEntity();
        List<TipoNotificacionEntity> tipoNotificacionEntities = factory.getTipoNotificacionDAO().listByFilter(tipoNotificacionEntity);
        List<TipoNotificacionDomain> datosARetornar = null;
        return datosARetornar;
    }
}
