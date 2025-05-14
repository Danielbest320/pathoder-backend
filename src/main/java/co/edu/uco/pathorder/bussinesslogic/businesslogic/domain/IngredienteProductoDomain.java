package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class IngredienteProductoDomain {

    private UUID id;
    private ProductoDomain productoVenta;
    private ProductoDomain productoIngrediente;
    private int cantidad;

    IngredienteProductoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setProductoVenta(ProductoDomain.obtenerValorDefecto());
        setProductoIngrediente(ProductoDomain.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoDomain(final UUID id) {
        setId(id);
        setProductoVenta(ProductoDomain.obtenerValorDefecto());
        setProductoIngrediente(ProductoDomain.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public IngredienteProductoDomain(final UUID id, final ProductoDomain productoVenta, final ProductoDomain productoIngrediente, final int cantidad) {
        setId(id);
        setProductoVenta(productoVenta);
        setProductoIngrediente(productoIngrediente);
        setCantidad(cantidad);
    }

    static IngredienteProductoDomain obtenerValorDefecto() {
        return new IngredienteProductoDomain();
    }

    static IngredienteProductoDomain obtenerValorDefecto (final IngredienteProductoDomain ingredienteProducto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(ingredienteProducto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoDomain getProductoVenta() {
        return productoVenta;
    }

    private void setProductoVenta(final ProductoDomain productoVenta) {
        this.productoVenta = ProductoDomain.obtenerValorDefecto(productoVenta);
    }

    public ProductoDomain getProductoIngrediente() {
        return productoIngrediente;
    }

    private void setProductoIngrediente(final ProductoDomain productoIngrediente) {
        this.productoIngrediente = ProductoDomain.obtenerValorDefecto(productoIngrediente);
    }

    public int getCantidad() {
        return cantidad;
    }

    private void setCantidad(final int cantidad) {
        this.cantidad = UtilNumerico.getInstance().obtenerValorDefecto(cantidad);
    }
}
