package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class IngredienteProductoEntity {

    private UUID id;
    private ProductoEntity productoVenta;
    private ProductoEntity productoIngrediente;
    private int cantidad;

    public IngredienteProductoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setProductoVenta(ProductoEntity.obtenerValorDefecto());
        setProductoIngrediente(ProductoEntity.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoEntity(final UUID id) {
        setId(id);
        setProductoVenta(ProductoEntity.obtenerValorDefecto());
        setProductoIngrediente(ProductoEntity.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoEntity(final UUID id, final ProductoEntity productoVenta, final ProductoEntity productoIngrediente, final int cantidad) {
        setId(id);
        setProductoVenta(productoVenta);
        setProductoIngrediente(productoIngrediente);
        setCantidad(cantidad);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoEntity getProductoVenta() {
        return productoVenta;
    }

    public void setProductoVenta(final ProductoEntity productoVenta) {
        this.productoVenta = ProductoEntity.obtenerValorDefecto(productoVenta);
    }

    public ProductoEntity getProductoIngrediente() {
        return productoIngrediente;
    }

    public void setProductoIngrediente(final ProductoEntity productoIngrediente) {
        this.productoIngrediente = ProductoEntity.obtenerValorDefecto(productoIngrediente);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(final int cantidad) {
        this.cantidad = UtilNumerico.getInstance().obtenerValorDefecto(cantidad);
    }
}
