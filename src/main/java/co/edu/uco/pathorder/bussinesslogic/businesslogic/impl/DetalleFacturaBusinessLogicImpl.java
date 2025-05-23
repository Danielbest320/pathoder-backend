package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.DetalleFacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.DetalleFacturaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.DetalleFacturaEntity;

import java.util.List;
import java.util.UUID;

public class DetalleFacturaBusinessLogicImpl implements DetalleFacturaBusinessLogic {

    private DAOFactory factory;

    public DetalleFacturaBusinessLogicImpl(DAOFactory daoFactory) {
        this.factory = daoFactory;
    }

    @Override
    public void crearDetalleFactura(DetalleFacturaDomain detalleFactura) throws PathOrderException  {
        DetalleFacturaEntity detalleFacturaEntity = new DetalleFacturaEntity();
        factory.getDetalleFacturaDAO().create(detalleFacturaEntity);
    }

    @Override
    public void eliminarDetalleFactura(UUID id) throws PathOrderException{
        factory.getDetalleFacturaDAO().delete(id);
    }

    @Override
    public List<DetalleFacturaDomain> consultarDetalleFactura(DetalleFacturaDomain filtro)throws PathOrderException{
        DetalleFacturaEntity detalleFacturaEntity = new DetalleFacturaEntity();

        List<DetalleFacturaEntity> facturaEntities = factory.getDetalleFacturaDAO().listByFilter(detalleFacturaEntity);
        List<DetalleFacturaDomain> datosARetornar = null;
        return datosARetornar;
    }

    @Override
    public void modificarDetalleFactura(DetalleFacturaDomain detalleFactura, UUID id) throws PathOrderException{
        DetalleFacturaEntity detalleFacturaEntity = new DetalleFacturaEntity();
        factory.getDetalleFacturaDAO().update(id,detalleFacturaEntity);
    }
}
