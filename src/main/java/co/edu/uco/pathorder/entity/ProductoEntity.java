package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilPrecio;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class ProductoEntity {

    private UUID id;
    private String nombre;
    private TipoProductoEntity tipoProducto;
    private String descripcion;
    private int precio;
    private CategoriaEntity categoria;

    public ProductoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoEntity.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaEntity.obtenerValorDefecto());
    }
    public ProductoEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoEntity.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaEntity.obtenerValorDefecto());
    }

    public ProductoEntity(final UUID id, final String nombre, final TipoProductoEntity tipoProducto, final String descripcion, final int precio, final CategoriaEntity categoria) {
        setId(id);
        setNombre(nombre);
        setTipoProducto(tipoProducto);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCategoria(categoria);
    }

    public static ProductoEntity obtenerValorDefecto() {
        return new ProductoEntity();
    }

    public static ProductoEntity obtenerValorDefecto(final ProductoEntity producto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(producto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }

    public TipoProductoEntity getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(final TipoProductoEntity tipoProducto) {
        this.tipoProducto = TipoProductoEntity.obtenerValorDefecto(tipoProducto);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(descripcion);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(final int precio) {
        this.precio = precio;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(final CategoriaEntity categoria) {
        this.categoria = CategoriaEntity.obtenerValorDefecto(categoria);
    }
}
