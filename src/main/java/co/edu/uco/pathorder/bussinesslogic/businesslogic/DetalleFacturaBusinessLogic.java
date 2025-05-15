package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.DetalleFacturaDomain;

import java.util.List;
import java.util.UUID;

public interface DetalleFacturaBusinessLogic {

    void crearDetalleFactura(DetalleFacturaDomain detalleFactura);

    void eliminarDetalleFactura(UUID id);

    List<DetalleFacturaDomain> consultarDetalleFactura(DetalleFacturaDomain filtro);

    void modificarDetalleFactura(DetalleFacturaDomain detalleFactura, UUID id);

}
