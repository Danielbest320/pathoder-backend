package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class CategoriaEntity {

    private UUID id;
    private String nombre;

    public CategoriaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public CategoriaEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public CategoriaEntity(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static CategoriaEntity obtenerValorDefecto() {
        return new CategoriaEntity();
    }

    public static CategoriaEntity obtenerValorDefecto(final CategoriaEntity categoria) {
        return UtilObjeto.getInstance().obtenerValorDefecto(categoria, obtenerValorDefecto());
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
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }

}
