package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class InventarioEntity {

    private UUID id;
    private ProductoEntity producto;
    private int disponibilidad;


    public InventarioEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoEntity.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioEntity(final UUID id) {
        setId(id);
        setProducto(ProductoEntity.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioEntity(final UUID id, final ProductoEntity producto, final int disponibilidad) {
        setId(id);
        setProducto(producto);
        setDisponibilidad(disponibilidad);
    }

    public static InventarioEntity obtenerValorDefecto() {
        return new InventarioEntity();
    }

    public static InventarioEntity obtenerValorDefecto(final InventarioEntity inventario) {
        return UtilObjeto.getInstance().obtenerValorDefecto(inventario, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(final ProductoEntity producto) {
        this.producto = ProductoEntity.obtenerValorDefecto(producto);
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(final int disponibilidad) {
        this.disponibilidad = UtilNumerico.getInstance().obtenerValorDefecto( disponibilidad);
    }
}
