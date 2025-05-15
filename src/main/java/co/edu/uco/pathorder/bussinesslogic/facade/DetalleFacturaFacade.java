package co.edu.uco.pathorder.bussinesslogic.facade;


import co.edu.uco.pathorder.dto.DetalleFacturaDTO;

import java.util.List;
import java.util.UUID;

public interface DetalleFacturaFacade {

    void crearDetalleFactura(DetalleFacturaDTO detalleFactura);

    void eliminarDetalleFactura(UUID id);

    List<DetalleFacturaDTO> consultarDetalleFactura(DetalleFacturaDTO filtro);

    void modificarDetalleFactura(DetalleFacturaDTO detalleFactura, UUID id);

}
