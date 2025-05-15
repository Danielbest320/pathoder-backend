package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.TipoNotificacionBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.TipoNotificacionFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.TipoNotificacionDTO;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;

import java.util.List;

public class TipoNotificacionFacadeImpl implements TipoNotificacionFacade {

    private DAOFactory daoFactory;
    private TipoNotificacionBusinessLogic tipoNotificacionBusinessLogic;

    public TipoNotificacionFacadeImpl(DAOFactory factory) {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        tipoNotificacionBusinessLogic = new TipoNotificacionBusinessLogicImpl(daoFactory);
    }

    @Override
    public void crearTiposNotificacion(TipoNotificacionDTO tipoNotificacionDTO) {

    }

    @Override
    public List<TipoNotificacionDTO> consultarTiposNotificacion(TipoNotificacionDTO filtro) {
        return List.of();
    }
}
