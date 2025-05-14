package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HistorialPrecioDomain;

import java.util.List;

public interface HistorialPrecioBusinessLogic {

    void registrarNuevoPrecioHistorial(HistorialPrecioDomain historialPrecio);

    List<HistorialPrecioDomain> consultarHistorialPrecioProducto(HistorialPrecioDomain filtro);

}
