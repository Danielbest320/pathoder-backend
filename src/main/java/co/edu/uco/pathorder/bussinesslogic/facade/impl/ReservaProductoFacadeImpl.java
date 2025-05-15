package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.ReservaProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.ReservaProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.ReservaProductoFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.ReservaProductoDTO;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;

import java.util.List;
import java.util.UUID;

public class ReservaProductoFacadeImpl implements ReservaProductoFacade {

    private DAOFactory daoFactory;
    private ReservaProductoBusinessLogic reservaProductoBusinessLogic;

    public ReservaProductoFacadeImpl(DAOFactory factory) {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        reservaProductoBusinessLogic = new ReservaProductoBusinessLogicImpl(daoFactory);
    }

    @Override
    public void crearReservaProducto(ReservaProductoDTO reservaProducto) {

    }

    @Override
    public void eliminarReservaProducto(UUID id) {

    }

    @Override
    public void modificarReservaProducto(ReservaProductoDTO reservaProducto, UUID id) {

    }

    @Override
    public List<ReservaProductoDTO> consultarReservaProducto(ReservaProductoDTO filtro) {
        return List.of();
    }
}
