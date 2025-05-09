package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.*;
import co.edu.uco.pathorder.dto.ProductoDTO;
import co.edu.uco.pathorder.dto.ReservaDTO;

import java.util.UUID;

public final class ReservaProductoDTO {

    private UUID id;
    private ReservaDTO reserva;
    private ProductoDTO producto;
    private int cantidad;

    public ReservaProductoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setReserva(ReservaDTO.obtenerValorDefecto());
        setProducto(ProductoDTO.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public ReservaProductoDTO(final UUID id){
        setId(id);
        setReserva(ReservaDTO.obtenerValorDefecto());
        setProducto(ProductoDTO.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public ReservaProductoDTO(final UUID id, final ReservaDTO reserva, final ProductoDTO producto, final int cantidad) {
        setId(id);
        setReserva(reserva);
        setProducto(producto);
        setCantidad(cantidad);
    }

    public UUID getId() {
        return id;
    }

    public ReservaProductoDTO setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ReservaDTO getReserva() {
        return reserva;
    }

    public ReservaProductoDTO setReserva(ReservaDTO reserva) {
        this.reserva = ReservaDTO.obtenerValorDefecto(reserva);
        return this;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public ReservaProductoDTO setProducto(ProductoDTO producto) {
        this.producto = ProductoDTO.obtenerValorDefecto(producto);
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ReservaProductoDTO setCantidad(int cantidad) {
        this.cantidad = UtilNumerico.getInstance().obtenerValorDefecto(cantidad);
        return this;
    }

    public static ReservaProductoDTO obtenerValorDefecto() {
        return new ReservaProductoDTO();
    }

    public static ReservaProductoDTO obtenerValorDefecto(ReservaProductoDTO reservaProducto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(reservaProducto, obtenerValorDefecto());
    }
}
