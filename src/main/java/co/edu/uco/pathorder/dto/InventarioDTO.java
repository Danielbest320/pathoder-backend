package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class InventarioDTO {

    private UUID id;
    private ProductoDTO producto;
    private int disponibilidad;


    public InventarioDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoDTO.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioDTO(final UUID id) {
        setId(id);
        setProducto(ProductoDTO.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioDTO(final UUID id, final ProductoDTO producto, final int disponibilidad) {
        setId(id);
        setProducto(producto);
        setDisponibilidad(disponibilidad);
    }

    public static InventarioDTO obtenerValorDefecto() {
        return new InventarioDTO();
    }

    public static InventarioDTO obtenerValorDefecto(final InventarioDTO inventario) {
        return UtilObjeto.getInstance().obtenerValorDefecto(inventario, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public InventarioDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public InventarioDTO setProducto(final ProductoDTO producto) {
        this.producto = ProductoDTO.obtenerValorDefecto(producto);
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
