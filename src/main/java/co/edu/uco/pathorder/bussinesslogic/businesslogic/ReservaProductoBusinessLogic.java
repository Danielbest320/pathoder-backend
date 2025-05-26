package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface ReservaProductoBusinessLogic {

    void crearReservaProducto(ReservaProductoDomain reservaProducto) throws PathOrderException;

    void eliminarReservaProducto(UUID id) throws PathOrderException;

    void modificarReservaProducto(ReservaProductoDomain reservaProducto, UUID id) throws PathOrderException;

    List<ReservaProductoDomain> consultarReservaProducto(ReservaProductoDomain filtro) throws PathOrderException;

}
