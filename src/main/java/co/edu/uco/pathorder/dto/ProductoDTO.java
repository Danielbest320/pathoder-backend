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
    private TipoProductoDTO tipoProducto;
    private String descripcion;
    private int precio;
    private CategoriaDTO categoria;

    public ProductoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoDTO.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaDTO.obtenerValorDefecto());
    }
    public ProductoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoProducto(TipoProductoDTO.obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
        setPrecio(UtilPrecio.getInstance().obtenerValorDefecto());
        setCategoria(CategoriaDTO.obtenerValorDefecto());
    }

    public ProductoDTO(final UUID id, final String nombre, final TipoProductoDTO tipoProducto, final String descripcion, final int precio, final CategoriaDTO categoria) {
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

    public TipoProductoDTO getTipoProducto() {
        return tipoProducto;
    }

    public ProductoDTO setTipoProducto(final TipoProductoDTO tipoProducto) {
        this.tipoProducto = TipoProductoDTO.obtenerValorDefecto(tipoProducto);
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

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public ProductoDTO setCategoria(final CategoriaDTO categoria) {
        this.categoria = CategoriaDTO.obtenerValorDefecto(categoria);
        return this;
    }
}
