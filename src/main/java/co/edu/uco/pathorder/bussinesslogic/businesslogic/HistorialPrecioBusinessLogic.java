package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HistorialPrecioDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;

public interface HistorialPrecioBusinessLogic {

    void registrarNuevoPrecioHistorial(HistorialPrecioDomain historialPrecio) throws PathOrderException;

    List<HistorialPrecioDomain> consultarHistorialPrecioProducto(HistorialPrecioDomain filtro) throws PathOrderException;

}
