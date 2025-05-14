package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilPrecio;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class ProductoDomain {

    private UUID id;
    private String nombre;
    private TipoProductoDomain tipoProducto;
    private String descripcion;
    private int precio;
    private CategoriaDomain categoria;

    ProductoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoDomain.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaDomain.obtenerValorDefecto());
    }
    public ProductoDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoDomain.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaDomain.obtenerValorDefecto());
    }

    public ProductoDomain(final UUID id, final String nombre, final TipoProductoDomain tipoProducto, final String descripcion, final int precio, final CategoriaDomain categoria) {
        setId(id);
        setNombre(nombre);
        setTipoProducto(tipoProducto);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCategoria(categoria);
    }

    static ProductoDomain obtenerValorDefecto() {
        return new ProductoDomain();
    }

    static ProductoDomain obtenerValorDefecto(final ProductoDomain producto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(producto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }

    public TipoProductoDomain getTipoProducto() {
        return tipoProducto;
    }

    private void setTipoProducto(final TipoProductoDomain tipoProducto) {
        this.tipoProducto = TipoProductoDomain.obtenerValorDefecto(tipoProducto);
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(descripcion);
    }

    public int getPrecio() {
        return precio;
    }

    private void setPrecio(final int precio) {
        this.precio = precio;
    }

    public CategoriaDomain getCategoria() {
        return categoria;
    }

    private void setCategoria(final CategoriaDomain categoria) {
        this.categoria = CategoriaDomain.obtenerValorDefecto(categoria);
    }
}
