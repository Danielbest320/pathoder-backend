package co.edu.uco.pathorder.bussinesslogic.facade;


import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.DetalleFacturaDTO;

import java.util.List;
import java.util.UUID;

public interface DetalleFacturaFacade {

    void crearDetalleFactura(DetalleFacturaDTO detalleFactura) throws PathOrderException;

    void eliminarDetalleFactura(UUID id) throws PathOrderException;

    List<DetalleFacturaDTO> consultarDetalleFactura(DetalleFacturaDTO filtro) throws PathOrderException;

    void modificarDetalleFactura(DetalleFacturaDTO detalleFactura, UUID id) throws PathOrderException;

}
