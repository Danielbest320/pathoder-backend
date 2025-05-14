package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.HistorialPrecioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.HistorialPrecioBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.HistorialPrecioFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.HistorialPrecioDTO;

import java.util.List;

public class HistorialPrecioFacadeImpl implements HistorialPrecioFacade {

    private DAOFactory daoFactory;
    private HistorialPrecioBusinessLogic historialPrecioBusinessLogic;


    public HistorialPrecioFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        historialPrecioBusinessLogic = new HistorialPrecioBusinessLogicImpl(daoFactory);

    }

    @Override
    public void registrarNuevoPrecioHistorial(HistorialPrecioDTO historialPrecio) {

    }

    @Override
    public List<HistorialPrecioDTO> consultarHistorialPrecioProducto(HistorialPrecioDTO filtro) {
        return List.of();
    }
}
