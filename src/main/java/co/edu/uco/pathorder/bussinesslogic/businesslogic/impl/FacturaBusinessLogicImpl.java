package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.FacturaEntity;
import co.edu.uco.pathorder.entity.NotificacionEntity;

import java.util.List;
import java.util.UUID;

public class FacturaBusinessLogicImpl implements FacturaBusinessLogic {

    private DAOFactory factory;

    public FacturaBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void generarFactura(FacturaDomain factura) {
        FacturaEntity facturaEntity = new FacturaEntity();
        factory.getFacturaDAO().create(facturaEntity);
    }

    @Override
    public List<FacturaDomain> consultarFactura(FacturaDomain filtro) {
        FacturaEntity facturaEntity = new FacturaEntity();

        List<FacturaEntity> facturaEntities = factory.getFacturaDAO().listByFilter(facturaEntity);
        List<FacturaDomain> datosARetornar = null;
        return datosARetornar;
    }

    @Override
    public List<FacturaDomain> consultarFacturaCliente(FacturaDomain filtro) {
        FacturaEntity facturaEntity = new FacturaEntity();

        List<FacturaEntity> facturaEntities = factory.getFacturaDAO().listByFilter(facturaEntity);
        List<FacturaDomain> datosARetornar = null;
        return datosARetornar;
    }

    @Override
    public void anularFactura(UUID id) {
        factory.getFacturaDAO().delete(id);
    }
}
