package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.TipoProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.TipoProductoFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.TipoProductoDTO;

import java.util.List;

public class TipoProductoFacadeImpl implements TipoProductoFacade {

    private DAOFactory daoFactory;
    private TipoProductoBusinessLogic tipoProductoBusinessLogic;


    public TipoProductoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        tipoProductoBusinessLogic = new TipoProductoBusinessLogicImpl(daoFactory);

    }

    @Override
    public void crearTipoProductoPredeterminado(TipoProductoDTO tipoProducto) {

    }

    @Override
    public List<TipoProductoDTO> consultarTipoProductos(TipoProductoDTO filtro) {
        return List.of();
    }
}
