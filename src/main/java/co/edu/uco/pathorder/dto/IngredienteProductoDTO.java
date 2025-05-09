package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.util.UUID;

public class IngredienteProductoDTO {

    private UUID id;
    private ProductoEntity productoVenta;
    private ProductoEntity productoIngrediente;
    private int cantidad;

    public IngredienteProductoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setProductoVenta(ProductoEntity.obtenerValorDefecto());
        setProductoIngrediente(ProductoEntity.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoDTO(final UUID id) {
        setId(id);
        setProductoVenta(ProductoEntity.obtenerValorDefecto());
        setProductoIngrediente(ProductoEntity.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoDTO(final UUID id, final ProductoEntity productoVenta, final ProductoEntity productoIngrediente, final int cantidad) {
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

    public ProductoEntity getProductoVenta() {
        return productoVenta;
    }

    public IngredienteProductoDTO setProductoVenta(final ProductoEntity productoVenta) {
        this.productoVenta = ProductoEntity.obtenerValorDefecto(productoVenta);
        return this;
    }

    public ProductoEntity getProductoIngrediente() {
        return productoIngrediente;
    }

    public IngredienteProductoDTO setProductoIngrediente(final ProductoEntity productoIngrediente) {
        this.productoIngrediente = ProductoEntity.obtenerValorDefecto(productoIngrediente);
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
