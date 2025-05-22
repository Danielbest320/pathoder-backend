package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.FacturaBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.FacturaFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.FacturaDTO;

import java.util.List;
import java.util.UUID;

public class FacturaFacadeImpl implements FacturaFacade {

    private DAOFactory daoFactory;
    private FacturaBusinessLogic facturaBusinessLogic;

    public FacturaFacadeImpl(DAOFactory factory) {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        facturaBusinessLogic = new FacturaBusinessLogicImpl(daoFactory);
    }


    @Override
    public void generarFactura(FacturaDTO factura) {

    }

    @Override
    public List<FacturaDTO> consultarFactura(FacturaDTO filtro) {
        return List.of();
    }

    @Override
    public List<FacturaDTO> consultarFacturaCliente(FacturaDTO filtro) {
        return List.of();
    }

    @Override
    public void anularFactura(UUID id) {

    }
}
