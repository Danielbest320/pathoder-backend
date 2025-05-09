package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.*;

import java.util.UUID;

public final class TipoNotificacionDTO {

    private UUID id;
    private String nombre;
    private String mensaje;
    private String descripcion;

    public TipoNotificacionDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoNotificacionDTO(final UUID id){
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoNotificacionDTO(final UUID id, final String nombre, final String mensaje, final String descripcion) {
        setId(id);
        setNombre(nombre);
        setMensaje(mensaje);
        setDescripcion(descripcion);
    }

    public UUID getId() {
        return id;
    }

    public TipoNotificacionDTO setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoNotificacionDTO setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().obtenerValorDefecto(nombre);
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public TipoNotificacionDTO setMensaje(String mensaje) {
        this.mensaje = UtilTexto.getInstance().obtenerValorDefecto(mensaje);
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoNotificacionDTO setDescripcion(String descripcion) {
        this.descripcion = UtilTexto.getInstance().obtenerValorDefecto(descripcion);
        return this;
    }

    public static TipoNotificacionDTO obtenerValorDefecto() {
        return new TipoNotificacionDTO();
    }

    public static TipoNotificacionDTO obtenerValorDefecto(final TipoNotificacionDTO tipoNotificacion) {
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoNotificacion, obtenerValorDefecto());
    }
}
