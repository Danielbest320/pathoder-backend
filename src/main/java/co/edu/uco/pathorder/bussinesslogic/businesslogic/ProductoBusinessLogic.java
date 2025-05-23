package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface ProductoBusinessLogic {

    void registrarProducto(ProductoDomain producto) throws PathOrderException;


    void modificarProducto(UUID id, ProductoDomain producto) throws PathOrderException;

    void eliminarProducto(UUID id) throws PathOrderException;

    List<ProductoDomain> consultarProducto(ProductoDomain filtro) throws PathOrderException;

    List<ProductoDomain> consultarProductoDisponible(ProductoDomain filtro) throws PathOrderException;
}
