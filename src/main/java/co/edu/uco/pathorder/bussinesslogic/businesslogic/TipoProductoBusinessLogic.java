package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;

public interface TipoProductoBusinessLogic {

    void crearTipoProductoPredeterminado(TipoProductoDomain tipoProducto) throws PathOrderException;

    List<TipoProductoDomain> consultarTipoProductos(TipoProductoDomain filtro) throws PathOrderException;

}

