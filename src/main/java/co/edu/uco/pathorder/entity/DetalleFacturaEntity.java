package co.edu.uco.pathorder.entity;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class DetalleFacturaEntity {

    private UUID id;
    private ReservaProductoEntity reservaProducto;
    private FacturaEntity factura;
    private int cantidad;
    private int precioVenta;
    private int subTotal;

    public DetalleFacturaEntity(){
        setId(UtilUUID.obtenerValorDefecto());
        setReservaProducto(ReservaProductoEntity.obtenerValorDefecto());
        setFactura(FacturaEntity.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
        setPrecioVenta(UtilNumerico.getInstance().obtenerValorDefecto());
        setSubTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public DetalleFacturaEntity(final UUID id){
        setId(id);
        setReservaProducto(ReservaProductoEntity.obtenerValorDefecto());
        setFactura(FacturaEntity.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
        setPrecioVenta(UtilNumerico.getInstance().obtenerValorDefecto());
        setSubTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public DetalleFacturaEntity(final UUID id, final ReservaProductoEntity reservaProducto, final FacturaEntity factura, final int cantidad, final int precioVenta, final int subTotal) {
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

    public void setCantidad(int cantidad) {
        this.cantidad = UtilNumerico.getInstance().obtenerValorDefecto(cantidad);
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = UtilNumerico.getInstance().obtenerValorDefecto(precioVenta);
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = FacturaEntity.obtenerValorDefecto(factura);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = UtilNumerico.getInstance().obtenerValorDefecto(subTotal);
    }

    public ReservaProductoEntity getReservaProducto() {
        return reservaProducto;
    }

    public void setReservaProducto(ReservaProductoEntity reservaProducto) {
        this.reservaProducto = ReservaProductoEntity.obtenerValorDefecto(reservaProducto);
    }

    public static DetalleFacturaEntity obtenerValorDefecto() {
        return new DetalleFacturaEntity();
    }

    public static DetalleFacturaEntity obtenerValorDefecto(final DetalleFacturaEntity detalleFacturaEntity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(detalleFacturaEntity, obtenerValorDefecto());
    }
}
