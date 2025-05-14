package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.InventarioDomain;

import java.util.List;
import java.util.UUID;

public interface InventarioBusinessLogic {

    void crearInventario(InventarioDomain inventario);


    void actualizarInventario(InventarioDomain inventario, UUID id);

    void actualizarInventarioMomentoReserva(InventarioDomain inventario, UUID id);

    void eliminarInventario(UUID id);

    List<InventarioDomain> consultarInventario(InventarioDomain filtro);
}
