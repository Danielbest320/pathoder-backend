package co.edu.uco.pathorder.entity;

import java.util.UUID;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

public final class ReservaProductoEntity {

    private UUID id;
    private ReservaEntity reserva;
    private ProductoEntity producto;
    private int cantidad;

    public ReservaProductoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setReserva(ReservaEntity.obtenerValorDefecto());
        setProducto(ProductoEntity.obtenerValorDefecto());
        setCantidad(0);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = ReservaEntity.obtenerValorDefecto(reserva);
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = ProductoEntity.obtenerValorDefecto(producto);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static ReservaProductoEntity obtenerValorDefecto() {
        return new ReservaProductoEntity();
    }

    public static ReservaProductoEntity obtenerValorDefecto(ReservaProductoEntity reservaProducto) {
        return UtilObjeto.getIntance().obtenerValorDefecto(reservaProducto, obtenerValorDefecto());
    }
}
