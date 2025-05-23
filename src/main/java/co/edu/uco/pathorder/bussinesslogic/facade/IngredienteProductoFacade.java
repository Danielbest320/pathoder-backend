package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.IngredienteProductoDTO;

import java.util.List;
import java.util.UUID;

public interface IngredienteProductoFacade {

    void asignarIngredienteProducto(IngredienteProductoDTO ingredienteProducto) throws PathOrderException;


    void modificarCantidadIngrediente(IngredienteProductoDTO ingredienteProducto, UUID id)throws PathOrderException;

    void eliminarIngredienteProducto(UUID id)throws PathOrderException;

    List<IngredienteProductoDTO> consultarIngredientesProductos(IngredienteProductoDTO filtro)throws PathOrderException;
}
