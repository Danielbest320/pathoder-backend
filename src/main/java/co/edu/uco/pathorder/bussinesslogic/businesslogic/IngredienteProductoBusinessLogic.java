package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.IngredienteProductoDomain;

import java.util.List;
import java.util.UUID;

public interface IngredienteProductoBusinessLogic {

    void asignarIngredienteProducto(IngredienteProductoDomain ingredienteProducto);


    void modificarCantidadIngrediente(IngredienteProductoDomain ingredienteProducto, UUID id);

    void eliminarIngredienteProducto(UUID id);

    List<IngredienteProductoDomain> consultarIngredientesProductos(IngredienteProductoDomain filtro);
}
