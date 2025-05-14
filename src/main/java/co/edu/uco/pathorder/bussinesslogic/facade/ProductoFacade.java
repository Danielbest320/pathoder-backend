package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.ProductoDTO;

import java.util.List;
import java.util.UUID;

public interface ProductoFacade {

    void registrarProducto(ProductoDTO producto);


    void modificarProducto(UUID id, ProductoDTO producto);

    void eliminarProducto(UUID id);

    List<ProductoDTO> consultarProducto(ProductoDTO filtro);

    List<ProductoDTO> consultarProductoDisponible(ProductoDTO filtro);
}
