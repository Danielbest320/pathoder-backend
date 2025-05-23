package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.InventarioDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface InventarioBusinessLogic {

    void crearInventario(InventarioDomain inventario) throws PathOrderException;


    void actualizarInventario(InventarioDomain inventario, UUID id) throws PathOrderException;

    void actualizarInventarioMomentoReserva(InventarioDomain inventario, UUID id)throws PathOrderException;

    void eliminarInventario(UUID id) throws PathOrderException;

    List<InventarioDomain> consultarInventario(InventarioDomain filtro) throws PathOrderException;
}
