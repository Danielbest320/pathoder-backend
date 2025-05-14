package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class CategoriaDomain {

    private UUID id;
    private String nombre;

    CategoriaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public CategoriaDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public CategoriaDomain(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    static CategoriaDomain obtenerValorDefecto() {
        return new CategoriaDomain();
    }

    static CategoriaDomain obtenerValorDefecto(final CategoriaDomain categoria) {
        return UtilObjeto.getInstance().obtenerValorDefecto(categoria, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }

}
