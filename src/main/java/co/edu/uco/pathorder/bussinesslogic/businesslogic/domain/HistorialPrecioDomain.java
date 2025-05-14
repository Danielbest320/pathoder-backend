package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilPrecio;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.Date;
import java.util.UUID;

public class HistorialPrecioDomain {

    private UUID id;
    private ProductoDomain producto;
    private int precio;
    private Date fechaDesde;
    private Date fechaHasta;


    HistorialPrecioDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoDomain.obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setFechaDesde(UtilFecha.getInstance().obtenerValorDefectoComoDate());
        setFechaHasta(UtilFecha.getInstance().obtenerValorDefectoComoDate());
    }

    public HistorialPrecioDomain(final UUID id) {
        setId(id);
        setProducto(ProductoDomain.obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setFechaDesde(UtilFecha.getInstance().obtenerValorDefectoComoDate());
        setFechaHasta(UtilFecha.getInstance().obtenerValorDefectoComoDate());
    }

    public HistorialPrecioDomain(final UUID id, final ProductoDomain producto, final int precio, final Date fechaDesde, final Date fechaHasta) {
        setId(id);
        setProducto(producto);
        setPrecio(precio);
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);
    }

    static HistorialPrecioDomain obtenerValorDefecto() {
        return new HistorialPrecioDomain();
    }

    static HistorialPrecioDomain obtenerValorDefecto (final HistorialPrecioDomain historialPrecio) {
        return UtilObjeto.getInstance().obtenerValorDefecto(historialPrecio, obtenerValorDefecto());
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

    public int getPrecio() {
        return precio;
    }

    private void setPrecio(final int precio) {
        this.precio = UtilPrecio.getInstance().obtenerValorDefecto(precio);
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    private void setFechaDesde(final Date fechaDesde) {
        this.fechaDesde = UtilFecha.getInstance().obtenerValorDefectoComoDate(fechaDesde);
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    private void setFechaHasta(final Date fechaHasta) {
        this.fechaHasta = UtilFecha.getInstance().obtenerValorDefectoComoDate(fechaHasta);
    }
}
