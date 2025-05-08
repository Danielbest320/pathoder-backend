package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class TipoProductoEntity {

    private UUID id;
    private String nombre;

    public TipoProductoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoProductoEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoProductoEntity(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static TipoProductoEntity obtenerValorDefecto() {
        return new TipoProductoEntity();
    }

    public static TipoProductoEntity obtenerValorDefecto(final TipoProductoEntity tipoProducto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoProducto, obtenerValorDefecto());
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
