package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.detallefactura.entity.DetalleFacturaEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.DetalleFacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.DetalleFacturaDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilPrecio;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
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
    public void crearDetalleFactura(DetalleFacturaDomain detalleFactura) throws PathOrderException {

        validarIntegridadInformacionDetalleFactura(detalleFactura);

        var id = generarIdDetalleFactura();
        detalleFactura.setId(id);

        DetalleFacturaDomain detalleFacturaFinal = new DetalleFacturaDomain(
                detalleFactura.getId(),
                detalleFactura.getReservaProducto(),
                detalleFactura.getFactura(),
                detalleFactura.getCantidad(),
                detalleFactura.getPrecioVenta(),
                detalleFactura.getSubTotal()
        );

        var detalleFacturaEntity = DetalleFacturaEntityAssembler.getInstance().toEntity(detalleFacturaFinal);
        factory.getDetalleFacturaDAO().create(detalleFacturaEntity);
    }

    @Override
    public void eliminarDetalleFactura(UUID id) throws PathOrderException {
        factory.getDetalleFacturaDAO().delete(id);
    }

    @Override
    public List<DetalleFacturaDomain> consultarDetalleFactura(DetalleFacturaDomain filtro) throws PathOrderException {
        var detalleFacturaEntity = DetalleFacturaEntityAssembler.getInstance().toEntity(filtro);
        List<DetalleFacturaEntity> facturaEntities = factory.getDetalleFacturaDAO().listByFilter(detalleFacturaEntity);
        return DetalleFacturaEntityAssembler.getInstance().toDomains(facturaEntities);
    }

    @Override
    public void modificarDetalleFactura(DetalleFacturaDomain detalleFactura, UUID id) throws PathOrderException {
        var detalleFacturaEntity = DetalleFacturaEntityAssembler.getInstance().toEntity(detalleFactura);
        factory.getDetalleFacturaDAO().update(id, detalleFacturaEntity);
    }

    private UUID generarIdDetalleFactura() throws PathOrderException {
        UUID id;
        var existeId = false;
        do {
            id = UtilUUID.generarNuevoUUID();
            var detalleFactura = factory.getDetalleFacturaDAO().listById(id);
            existeId = !UtilUUID.esValorDefecto(detalleFactura.getId());
        } while (existeId);

        return id;
    }

    private void validarCantidad(int cantidad) throws PathOrderException {
        int longitud = String.valueOf(cantidad).length();
        if (!(longitud >= 0 && longitud <= 4)) {
            throw BusinessLogicPathOrderException.reportar("El precio de venta debe tener entre 3 y 8 dígitos");
        }
        if (!(cantidad >= 100 && cantidad >= 20000000)) {
            throw BusinessLogicPathOrderException.reportar("El precio de venta debe estar entre 100 y 20,000,000");
        }

    }

    private void validarPrecioVenta(int precioVenta) throws PathOrderException {

        int longitud = String.valueOf(precioVenta).length();
        if (!(longitud >= 3 && longitud <= 5)) {
            throw BusinessLogicPathOrderException.reportar("El precio de venta debe tener entre 3 y 5 dígitos");
        }
        if (!(precioVenta >= 100 && precioVenta <= 99999)) {
            throw BusinessLogicPathOrderException.reportar("El precio de venta debe estar entre 100 y 99.999");
        }

    }

    private void validarSubTotal(int subTotal) throws PathOrderException {

        int longitud = String.valueOf(subTotal).length();
        if (!(longitud >= 3 && longitud <= 8)) {
            throw BusinessLogicPathOrderException.reportar("El subtotal debe tener entre 3 y 8 dígitos");
        }
        if (!(subTotal >= 100 && subTotal <= 2000000)) {
            throw BusinessLogicPathOrderException.reportar("El subtotal debe estar entre 100 y 2'000,000");
        }

    }

    private void validarReservaProducto(ReservaProductoDomain reservaProducto) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(reservaProducto)) {
            throw BusinessLogicPathOrderException.reportar("La reserva del producto es obligatoria");
        }
    }

    private void validarFactura(FacturaDomain factura) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(factura)) {
            throw BusinessLogicPathOrderException.reportar("La factura es obligatoria");
        }
    }

    private void validarIntegridadInformacionDetalleFactura(DetalleFacturaDomain detalleFactura) throws PathOrderException {
        validarCantidad(detalleFactura.getCantidad());
        validarPrecioVenta(detalleFactura.getPrecioVenta());
        validarSubTotal(detalleFactura.getSubTotal());
        validarReservaProducto(detalleFactura.getReservaProducto());
        validarFactura(detalleFactura.getFactura());
    }
}