package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilPrecio;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.entity.CategoriaEntity;
import co.edu.uco.pathorder.entity.TipoProductoEntity;

import java.util.UUID;

public class ProductoDTO {

    private UUID id;
    private String nombre;
    private TipoProductoEntity tipoProducto;
    private String descripcion;
    private int precio;
    private CategoriaEntity categoria;

    public ProductoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoEntity.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaEntity.obtenerValorDefecto());
    }
    public ProductoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoEntity.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaEntity.obtenerValorDefecto());
    }

    public ProductoDTO(final UUID id, final String nombre, final TipoProductoEntity tipoProducto, final String descripcion, final int precio, final CategoriaEntity categoria) {
        setId(id);
        setNombre(nombre);
        setTipoProducto(tipoProducto);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCategoria(categoria);
    }

    public static ProductoDTO obtenerValorDefecto() {
        return new ProductoDTO();
    }

    public static ProductoDTO obtenerValorDefecto(final ProductoDTO producto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(producto, obtenerValorDefecto());
    }



    public UUID getId() {
        return id;
    }

    public ProductoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public ProductoDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
        return this;
    }

    public TipoProductoEntity getTipoProducto() {
        return tipoProducto;
    }

    public ProductoDTO setTipoProducto(final TipoProductoEntity tipoProducto) {
        this.tipoProducto = TipoProductoEntity.obtenerValorDefecto(tipoProducto);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ProductoDTO setDescripcion(final String descripcion) {
        this.descripcion = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(descripcion);
        return this;
    }

    public int getPrecio() {
        return precio;
    }

    public ProductoDTO setPrecio(final int precio) {
        this.precio = precio;
        return this;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public ProductoDTO setCategoria(final CategoriaEntity categoria) {
        this.categoria = CategoriaEntity.obtenerValorDefecto(categoria);
        return this;
    }
}
