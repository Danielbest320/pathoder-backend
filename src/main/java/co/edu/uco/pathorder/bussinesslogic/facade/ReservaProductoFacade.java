package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.ReservaProductoDTO;

import java.util.List;
import java.util.UUID;

public interface ReservaProductoFacade {

    void crearReservaProducto(ReservaProductoDTO reservaProducto);

    void eliminarReservaProducto(UUID id);

    void modificarReservaProducto(ReservaProductoDTO reservaProducto, UUID id);

    List<ReservaProductoDTO> consultarReservaProducto(ReservaProductoDTO filtro);

}
