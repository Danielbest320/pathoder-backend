package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;

import java.util.List;
import java.util.UUID;

public interface ReservaProductoBusinessLogic {

    void crearReservaProducto(ReservaProductoDomain reservaProducto);

    void eliminarReservaProducto(UUID id);

    void modificarReservaProducto(ReservaProductoDomain reservaProducto, UUID id);

    List<ReservaProductoDomain> consultarReservaProducto(ReservaProductoDomain filtro);

}
