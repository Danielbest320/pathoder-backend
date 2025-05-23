package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.HistorialPrecioDTO;

import java.util.List;

public interface HistorialPrecioFacade {

    void registrarNuevoPrecioHistorial(HistorialPrecioDTO historialPrecio) throws PathOrderException;

    List<HistorialPrecioDTO> consultarHistorialPrecioProducto(HistorialPrecioDTO filtro) throws PathOrderException;

}
