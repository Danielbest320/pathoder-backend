package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.TipoProductoDTO;

import java.util.List;

public interface TipoProductoFacade {

    void crearTipoProductoPredeterminado(TipoProductoDTO tipoProducto);

    List<TipoProductoDTO> consultarTipoProductos(TipoProductoDTO filtro);

}

