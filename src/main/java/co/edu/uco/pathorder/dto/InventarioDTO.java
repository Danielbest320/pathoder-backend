package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.util.UUID;

public class InventarioDTO {

    private UUID id;
    private ProductoEntity producto;
    private int disponibilidad;


    public InventarioDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoEntity.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioDTO(final UUID id) {
        setId(id);
        setProducto(ProductoEntity.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioDTO(final UUID id, final ProductoEntity producto, final int disponibilidad) {
        setId(id);
        setProducto(producto);
        setDisponibilidad(disponibilidad);
    }

    public UUID getId() {
        return id;
    }

    public InventarioDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public InventarioDTO setProducto(final ProductoEntity producto) {
        this.producto = ProductoEntity.obtenerValorDefecto(producto);
        return this;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public InventarioDTO setDisponibilidad(final int disponibilidad) {
        this.disponibilidad = UtilNumerico.getInstance().obtenerValorDefecto( disponibilidad);
        return this;
    }
}
