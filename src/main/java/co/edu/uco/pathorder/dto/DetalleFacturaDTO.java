package co.edu.uco.pathorder.dto;
import co.edu.uco.pathorder.crosscutting.utilitarios.*;
import co.edu.uco.pathorder.dto.FacturaDTO;
import co.edu.uco.pathorder.dto.ReservaProductoDTO;

import java.util.UUID;

public final class DetalleFacturaDTO {

    private UUID id;
    private ReservaProductoDTO reservaProducto;
    private FacturaDTO factura;
    private int cantidad;
    private int precioVenta;
    private int subTotal;

    public DetalleFacturaDTO(){
        setId(UtilUUID.obtenerValorDefecto());
        setReservaProducto(ReservaProductoDTO.obtenerValorDefecto());
        setFactura(FacturaDTO.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
        setPrecioVenta(UtilNumerico.getInstance().obtenerValorDefecto());
        setSubTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public DetalleFacturaDTO(final UUID id){
        setId(id);
        setReservaProducto(ReservaProductoDTO.obtenerValorDefecto());
        setFactura(FacturaDTO.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
        setPrecioVenta(UtilNumerico.getInstance().obtenerValorDefecto());
        setSubTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public DetalleFacturaDTO(final UUID id, final ReservaProductoDTO reservaProducto, final FacturaDTO factura, final int cantidad, final int precioVenta, final int subTotal) {
        setId(id);
        setReservaProducto(reservaProducto);
        setFactura(factura);
        setCantidad(cantidad);
        setPrecioVenta(precioVenta);
        setSubTotal(subTotal);
    }

    public int getCantidad() {
        return cantidad;
    }

    public DetalleFacturaDTO setCantidad(int cantidad) {
        this.cantidad = UtilNumerico.getInstance().obtenerValorDefecto(cantidad);
        return this;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public DetalleFacturaDTO setPrecioVenta(int precioVenta) {
        this.precioVenta = UtilNumerico.getInstance().obtenerValorDefecto(precioVenta);
        return this;
    }

    public FacturaDTO getFactura() {
        return factura;
    }

    public DetalleFacturaDTO setFactura(FacturaDTO factura) {
        this.factura = FacturaDTO.obtenerValorDefecto(factura);
        return this;
    }

    public UUID getId() {
        return id;
    }

    public DetalleFacturaDTO setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public DetalleFacturaDTO setSubTotal(int subTotal) {
        this.subTotal = UtilNumerico.getInstance().obtenerValorDefecto(subTotal);
        return this;
    }

    public ReservaProductoDTO getReservaProducto() {
        return reservaProducto;
    }

    public DetalleFacturaDTO setReservaProducto(ReservaProductoDTO reservaProducto) {
        this.reservaProducto = ReservaProductoDTO.obtenerValorDefecto(reservaProducto);
        return this;
    }

    public static DetalleFacturaDTO obtenerValorDefecto() {
        return new DetalleFacturaDTO();
    }

    public static DetalleFacturaDTO obtenerValorDefecto(final DetalleFacturaDTO detalleFacturaDTO) {
        return UtilObjeto.getInstance().obtenerValorDefecto(detalleFacturaDTO, obtenerValorDefecto());
    }
}
