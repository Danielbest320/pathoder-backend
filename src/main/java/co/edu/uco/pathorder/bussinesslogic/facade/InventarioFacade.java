package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.InventarioDTO;

import java.util.List;
import java.util.UUID;

public interface InventarioFacade {

    void crearInventario(InventarioDTO inventario)throws PathOrderException;


    void actualizarInventario(InventarioDTO inventario, UUID id) throws PathOrderException;

    void actualizarInventarioMomentoReserva(InventarioDTO inventario, UUID id) throws PathOrderException;

    void eliminarInventario(UUID id) throws PathOrderException;

    List<InventarioDTO> consultarInventario(InventarioDTO filtro) throws PathOrderException;
}
