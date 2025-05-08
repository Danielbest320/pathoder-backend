package co.edu.uco.pathorder.entity;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;

import java.util.UUID;

public final class DetalleFacturaEntity {

    private UUID id;
    private ReservaProductoEntity reservaProducto;
    private FacturaEntity factura;
    private int cantidad;
    private int precioVenta;
    private int subTotal;

    public DetalleFacturaEntity(){
        set
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
        this.precioVenta = precioVenta;
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
        this.id = id;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
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
        return UtilObjeto.getIntance().obtenerValorDefecto(detalleFacturaEntity, obtenerValorDefecto());
    }
}
