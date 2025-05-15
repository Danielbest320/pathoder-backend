package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class ReservaProductoDomain {

    private UUID id;
    private ReservaDomain reserva;
    private ProductoDomain producto;
    private int cantidad;

    ReservaProductoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setReserva(ReservaDomain.obtenerValorDefecto());
        setProducto(ProductoDomain.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public ReservaProductoDomain(final UUID id){
        setId(id);
        setReserva(ReservaDomain.obtenerValorDefecto());
        setProducto(ProductoDomain.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public ReservaProductoDomain(final UUID id, final ReservaDomain reserva, final ProductoDomain producto, final int cantidad) {
        setId(id);
        setReserva(reserva);
        setProducto(producto);
        setCantidad(cantidad);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ReservaDomain getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDomain reserva) {
        this.reserva = ReservaDomain.obtenerValorDefecto(reserva);
    }

    public ProductoDomain getProducto() {
        return producto;
    }

    public void setProducto(ProductoDomain producto) {
        this.producto = ProductoDomain.obtenerValorDefecto(producto);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = UtilNumerico.getInstance().obtenerValorDefecto(cantidad);
    }

    static ReservaProductoDomain obtenerValorDefecto() {
        return new ReservaProductoDomain();
    }

    static ReservaProductoDomain obtenerValorDefecto(ReservaProductoDomain reservaProducto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(reservaProducto, obtenerValorDefecto());
    }
}
