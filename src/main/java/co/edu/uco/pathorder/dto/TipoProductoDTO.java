package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class TipoProductoDTO {

    private UUID id;
    private String nombre;

    public TipoProductoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoProductoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoProductoDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static TipoProductoDTO obtenerValorDefecto() {
        return new TipoProductoDTO();
    }

    public static TipoProductoDTO obtenerValorDefecto(final TipoProductoDTO tipoProducto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoProducto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public TipoProductoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoProductoDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
        return this;
    }
}
