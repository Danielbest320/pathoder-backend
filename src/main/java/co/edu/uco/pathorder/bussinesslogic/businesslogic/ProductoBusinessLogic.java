package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ProductoDomain;

import java.util.List;
import java.util.UUID;

public interface ProductoBusinessLogic {

    void registrarProducto(ProductoDomain producto);


    void modificarProducto(UUID id, ProductoDomain producto);

    void eliminarProducto(UUID id);

    List<ProductoDomain> consultarProducto(ProductoDomain filtro);

    List<ProductoDomain> consultarProductoDisponible(ProductoDomain filtro);
}
