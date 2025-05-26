package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.ReservaProductoDTO;

import java.util.List;
import java.util.UUID;

public interface ReservaProductoFacade {

    void crearReservaProducto(ReservaProductoDTO reservaProducto) throws PathOrderException;

    void eliminarReservaProducto(UUID id) throws PathOrderException;

    void modificarReservaProducto(ReservaProductoDTO reservaProducto, UUID id) throws PathOrderException;

    List<ReservaProductoDTO> consultarReservaProducto(ReservaProductoDTO filtro) throws PathOrderException;

}
