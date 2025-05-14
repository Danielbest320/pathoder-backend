package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoProductoDomain;

import java.util.List;

public interface TipoProductoBusinessLogic {

    void crearTipoProductoPredeterminado(TipoProductoDomain tipoProducto);

    List<TipoProductoDomain> consultarTipoProductos(TipoProductoDomain filtro);

}

