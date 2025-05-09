package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class CategoriaDTO {

    private UUID id;
    private String nombre;

    public CategoriaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public CategoriaDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public CategoriaDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static CategoriaDTO obtenerValorDefecto() {
        return new CategoriaDTO();
    }

    public static CategoriaDTO obtenerValorDefecto(final CategoriaDTO categoria) {
        return UtilObjeto.getInstance().obtenerValorDefecto(categoria, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public CategoriaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public CategoriaDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
        return this;
    }

}
