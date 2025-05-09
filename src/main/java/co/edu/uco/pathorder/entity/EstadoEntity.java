package co.edu.uco.pathorder.entity;

import java.util.UUID;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

public final class EstadoEntity {

    private UUID id;
    private String nombre;

    public EstadoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public EstadoEntity(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static EstadoEntity obtenerValorDefecto() {
        return new EstadoEntity();
    }

    public static EstadoEntity obtenerValorDefecto(final EstadoEntity entity) {
        return UtilObjeto.getInstance().obtenerValorDefecto(entity, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }
}
