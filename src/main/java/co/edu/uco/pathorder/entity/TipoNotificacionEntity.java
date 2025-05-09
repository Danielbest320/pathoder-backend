package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class TipoNotificacionEntity {

    private UUID id;
    private String nombre;
    private String mensaje;
    private String descripcion;

    public TipoNotificacionEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoNotificacionEntity(final UUID id){
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoNotificacionEntity(final UUID id, final String nombre, final String mensaje, final String descripcion) {
        setId(id);
        setNombre(nombre);
        setMensaje(mensaje);
        setDescripcion(descripcion);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().obtenerValorDefecto(nombre);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = UtilTexto.getInstance().obtenerValorDefecto(mensaje);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = UtilTexto.getInstance().obtenerValorDefecto(descripcion);
    }

    public static TipoNotificacionEntity obtenerValorDefecto() {
        return new TipoNotificacionEntity();
    }

    public static TipoNotificacionEntity obtenerValorDefecto(final TipoNotificacionEntity tipoNotificacion) {
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoNotificacion, obtenerValorDefecto());
    }
}
