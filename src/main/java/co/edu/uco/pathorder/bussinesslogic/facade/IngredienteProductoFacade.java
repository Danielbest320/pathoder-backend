package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.IngredienteProductoDTO;

import java.util.List;
import java.util.UUID;

public interface IngredienteProductoFacade {

    void asignarIngredienteProducto(IngredienteProductoDTO ingredienteProducto);


    void modificarCantidadIngrediente(IngredienteProductoDTO ingredienteProducto, UUID id);

    void eliminarIngredienteProducto(UUID id);

    List<IngredienteProductoDTO> consultarIngredientesProductos(IngredienteProductoDTO filtro);
}
