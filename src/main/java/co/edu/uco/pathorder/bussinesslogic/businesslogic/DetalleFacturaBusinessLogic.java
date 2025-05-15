package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import java.util.List;
import java.util.UUID;

public interface DetalleFacturaBusinessLogic {

    void crearDetalleFactura(DetalleFacturaDomain detalleFactura);

    void eliminarDetalleFactura(UUID id);

    List<DetalleFacturaDomain> consultarDetalleFactura(DetalleFacturaDomain filtro);

    void modificarDetalleFactura(DetalleFacturaDomain detalleFactura, UUID id);

}
