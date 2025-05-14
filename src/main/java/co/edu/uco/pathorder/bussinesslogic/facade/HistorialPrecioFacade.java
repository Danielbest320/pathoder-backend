package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.HistorialPrecioDTO;

import java.util.List;

public interface HistorialPrecioFacade {

    void registrarNuevoPrecioHistorial(HistorialPrecioDTO historialPrecio);

    List<HistorialPrecioDTO> consultarHistorialPrecioProducto(HistorialPrecioDTO filtro);

}
