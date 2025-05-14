package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.InventarioDTO;

import java.util.List;
import java.util.UUID;

public interface InventarioFacade {

    void crearInventario(InventarioDTO inventario);


    void actualizarInventario(InventarioDTO inventario, UUID id);

    void actualizarInventarioMomentoReserva(InventarioDTO inventario, UUID id);

    void eliminarInventario(UUID id);

    List<InventarioDTO> consultarInventario(InventarioDTO filtro);
}
