package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.DetalleFacturaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface DetalleFacturaBusinessLogic {

    void crearDetalleFactura(DetalleFacturaDomain detalleFactura) throws PathOrderException;

    void eliminarDetalleFactura(UUID id)throws PathOrderException;

    List<DetalleFacturaDomain> consultarDetalleFactura(DetalleFacturaDomain filtro)throws PathOrderException;

    void modificarDetalleFactura(DetalleFacturaDomain detalleFactura, UUID id)throws PathOrderException;

}
