package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.util.UUID;

public class IngredienteProductoDTO {

    private UUID id;
    private ProductoDTO productoVenta;
    private ProductoDTO productoIngrediente;
    private int cantidad;

    public IngredienteProductoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setProductoVenta(ProductoDTO.obtenerValorDefecto());
        setProductoIngrediente(ProductoDTO.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoDTO(final UUID id) {
        setId(id);
        setProductoVenta(ProductoDTO.obtenerValorDefecto());
        setProductoIngrediente(ProductoDTO.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoDTO(final UUID id, final ProductoDTO productoVenta, final ProductoDTO productoIngrediente, final int cantidad) {
        setId(id);
        setProductoVenta(productoVenta);
        setProductoIngrediente(productoIngrediente);
        setCantidad(cantidad);
    }

    public UUID getId() {
        return id;
    }

    public IngredienteProductoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ProductoDTO getProductoVenta() {
        return productoVenta;
    }

    public IngredienteProductoDTO setProductoVenta(final ProductoDTO productoVenta) {
        this.productoVenta = ProductoDTO.obtenerValorDefecto(productoVenta);
        return this;
    }

    public ProductoDTO getProductoIngrediente() {
        return productoIngrediente;
    }

    public IngredienteProductoDTO setProductoIngrediente(final ProductoDTO productoIngrediente) {
        this.productoIngrediente = ProductoDTO.obtenerValorDefecto(productoIngrediente);
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public IngredienteProductoDTO setCantidad(final int cantidad) {
        this.cantidad = UtilNumerico.getInstance().obtenerValorDefecto(cantidad);
        return this;
    }
}
