package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.ProductoDTO;

import java.util.List;
import java.util.UUID;

public interface ProductoFacade {

    void registrarProducto(ProductoDTO producto) throws PathOrderException;


    void modificarProducto(UUID id, ProductoDTO producto) throws PathOrderException;

    void eliminarProducto(UUID id) throws PathOrderException;

    List<ProductoDTO> consultarProducto(ProductoDTO filtro) throws PathOrderException;

    List<ProductoDTO> consultarProductoDisponible(ProductoDTO filtro) throws PathOrderException;
}
