package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.TipoProductoDTO;

import java.util.List;

public interface TipoProductoFacade {

    void crearTipoProductoPredeterminado(TipoProductoDTO tipoProducto) throws PathOrderException;

    List<TipoProductoDTO> consultarTipoProductos(TipoProductoDTO filtro) throws PathOrderException;

}

