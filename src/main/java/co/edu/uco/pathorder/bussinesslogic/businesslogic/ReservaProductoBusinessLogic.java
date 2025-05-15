package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import java.util.UUID;

public interface ReservaProductoBusinessLogic {

    void crearReservaProducto(ReservaProductoDomain reservaProducto);

    void eliminarReservaProducto(UUID id);

    void modificarReservaProducto(ReservaProductoDomain reservaProducto, UUID id);

    List<ReservaProductoDomain> consultarReservaProducto(ReservaProductoDomain filtro);

}
