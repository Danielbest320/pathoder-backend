package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class DetalleFacturaDomain {

    private UUID id;
    private ReservaProductoDomain reservaProducto;
    private FacturaDomain factura;
    private int cantidad;
    private int precioVenta;
    private int subTotal;

    DetalleFacturaDomain(){
        setId(UtilUUID.obtenerValorDefecto());
        setReservaProducto(ReservaProductoDomain.obtenerValorDefecto());
        setFactura(FacturaDomain.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
        setPrecioVenta(UtilNumerico.getInstance().obtenerValorDefecto());
        setSubTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public DetalleFacturaDomain(final UUID id){
        setId(id);
        setReservaProducto(ReservaProductoDomain.obtenerValorDefecto());
        setFactura(FacturaDomain.obtenerValorDefecto());
        setCantidad(UtilNumerico.getInstance().obtenerValorDefecto());
        setPrecioVenta(UtilNumerico.getInstance().obtenerValorDefecto());
        setSubTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public DetalleFacturaDomain(final UUID id, final ReservaProductoDomain reservaProducto, final FacturaDomain factura, final int cantidad, final int precioVenta, final int subTotal) {
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

    public FacturaDomain getFactura() {
        return factura;
    }

    public void setFactura(FacturaDomain factura) {
        this.factura = FacturaDomain.obtenerValorDefecto(factura);
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

    public ReservaProductoDomain getReservaProducto() {
        return reservaProducto;
    }

    public void setReservaProducto(ReservaProductoDomain reservaProducto) {
        this.reservaProducto = ReservaProductoDomain.obtenerValorDefecto(reservaProducto);
    }

    static DetalleFacturaDomain obtenerValorDefecto() {
        return new DetalleFacturaDomain();
    }

    static DetalleFacturaDomain obtenerValorDefecto(final DetalleFacturaDomain detalleFacturaDomain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(detalleFacturaDomain, obtenerValorDefecto());
    }
}
