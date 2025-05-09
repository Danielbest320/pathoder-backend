package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilPrecio;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.Date;
import java.util.UUID;

public class HistorialPrecioEntity {

    private UUID id;
    private ProductoEntity producto;
    private int precio;
    private Date fechaDesde;
    private Date fechaHasta;


    public HistorialPrecioEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setProducto(ProductoEntity.obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setFechaDesde(UtilFecha.getInstance().obtenerValorDefectoComoDate());
        setFechaHasta(UtilFecha.getInstance().obtenerValorDefectoComoDate());
    }

    public HistorialPrecioEntity(final UUID id) {
        setId(id);
        setProducto(ProductoEntity.obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setFechaDesde(UtilFecha.getInstance().obtenerValorDefectoComoDate());
        setFechaHasta(UtilFecha.getInstance().obtenerValorDefectoComoDate());
    }

    public HistorialPrecioEntity(final UUID id, final ProductoEntity producto, final int precio, final Date fechaDesde, final Date fechaHasta) {
        setId(id);
        setProducto(producto);
        setPrecio(precio);
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);
    }


    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(final ProductoEntity producto) {
        this.producto = ProductoEntity.obtenerValorDefecto(producto);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(final int precio) {
        this.precio = UtilPrecio.getInstance().obtenerValorDefecto(precio);
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(final Date fechaDesde) {
        this.fechaDesde = UtilFecha.getInstance().obtenerValorDefectoComoDate(fechaDesde);
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(final Date fechaHasta) {
        this.fechaHasta = UtilFecha.getInstance().obtenerValorDefectoComoDate(fechaHasta);
    }
}
