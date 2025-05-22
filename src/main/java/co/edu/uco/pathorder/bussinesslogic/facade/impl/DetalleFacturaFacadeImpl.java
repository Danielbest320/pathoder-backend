package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.DetalleFacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.DetalleFacturaBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.DetalleFacturaFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.DetalleFacturaDTO;

import java.util.List;
import java.util.UUID;

public class DetalleFacturaFacadeImpl implements DetalleFacturaFacade {

    private DAOFactory daoFactory;
    private DetalleFacturaBusinessLogic detalleFacturaBusinessLogic;

    public DetalleFacturaFacadeImpl(DAOFactory daoFactory) {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        detalleFacturaBusinessLogic = new DetalleFacturaBusinessLogicImpl(daoFactory);
    }


    @Override
    public void crearDetalleFactura(DetalleFacturaDTO detalleFactura) {

    }

    @Override
    public void eliminarDetalleFactura(UUID id) {

    }

    @Override
    public List<DetalleFacturaDTO> consultarDetalleFactura(DetalleFacturaDTO filtro) {
        return List.of();
    }

    @Override
    public void modificarDetalleFactura(DetalleFacturaDTO detalleFactura, UUID id) {

    }
}
