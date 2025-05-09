package co.edu.uco.pathorder.dto;

import java.util.UUID;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;


public final class EstadoDTO {

    private UUID id;
    private String nombre;

    public EstadoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }
    public EstadoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public EstadoDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static EstadoDTO obtenerValorDefecto() {
        return new EstadoDTO();
    }

    public static EstadoDTO obtenerValorDefecto(final EstadoDTO estado) {
        return UtilObjeto.getInstance().obtenerValorDefecto(estado, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public EstadoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
        return this;
    }
}
