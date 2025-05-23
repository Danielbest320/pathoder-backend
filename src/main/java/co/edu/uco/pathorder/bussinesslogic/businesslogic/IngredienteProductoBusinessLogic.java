package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.IngredienteProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface IngredienteProductoBusinessLogic {

    void asignarIngredienteProducto(IngredienteProductoDomain ingredienteProducto) throws PathOrderException;


    void modificarCantidadIngrediente(IngredienteProductoDomain ingredienteProducto, UUID id) throws PathOrderException;

    void eliminarIngredienteProducto(UUID id) throws PathOrderException;

    List<IngredienteProductoDomain> consultarIngredientesProductos(IngredienteProductoDomain filtro) throws PathOrderException;
}
