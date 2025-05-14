package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class InventarioDomain {

    private UUID id;
    private ProductoDomain producto;
    private int disponibilidad;


    InventarioDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoDomain.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioDomain(final UUID id) {
        setId(id);
        setProducto(ProductoDomain.obtenerValorDefecto());
        setDisponibilidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public InventarioDomain(final UUID id, final ProductoDomain producto, final int disponibilidad) {
        setId(id);
        setProducto(producto);
        setDisponibilidad(disponibilidad);
    }

    static InventarioDomain obtenerValorDefecto() {
        return new InventarioDomain();
    }

    static InventarioDomain obtenerValorDefecto(final InventarioDomain inventario) {
        return UtilObjeto.getInstance().obtenerValorDefecto(inventario, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoDomain getProducto() {
        return producto;
    }

    private void setProducto(final ProductoDomain producto) {
        this.producto = ProductoDomain.obtenerValorDefecto(producto);
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    private void setDisponibilidad(final int disponibilidad) {
        this.disponibilidad = UtilNumerico.getInstance().obtenerValorDefecto( disponibilidad);
    }
}
