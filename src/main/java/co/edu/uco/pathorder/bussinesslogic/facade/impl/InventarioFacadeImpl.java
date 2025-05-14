package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.InventarioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.InventarioBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.InventarioFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.InventarioDTO;

import java.util.List;
import java.util.UUID;

public class InventarioFacadeImpl implements InventarioFacade {

    private DAOFactory daoFactory;
    private InventarioBusinessLogic inventarioBusinessLogic;


    public InventarioFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        inventarioBusinessLogic = new InventarioBusinessLogicImpl(daoFactory);

    }

    @Override
    public void crearInventario(InventarioDTO inventario) {

    }

    @Override
    public void actualizarInventario(InventarioDTO inventario, UUID id) {

    }

    @Override
    public void actualizarInventarioMomentoReserva(InventarioDTO inventario, UUID id) {

    }

    @Override
    public void eliminarInventario(UUID id) {

    }

    @Override
    public List<InventarioDTO> consultarInventario(InventarioDTO filtro) {
        return List.of();
    }
}
