package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.List;
import java.util.UUID;

public class TipoNotificacionDomain {

    private UUID id;
    private String nombre;
    private String mensaje;
    private String descripcion;

    TipoNotificacionDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoNotificacionDomain(final UUID id){
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setMensaje(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoNotificacionDomain(final UUID id, final String nombre, final String mensaje, final String descripcion) {
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

    static TipoNotificacionDomain obtenerValorDefecto() {
        return new TipoNotificacionDomain();
    }

    static TipoNotificacionDomain obtenerValorDefecto(final TipoNotificacionDomain tipoNotificacion) {
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoNotificacion, obtenerValorDefecto());
    }

}
