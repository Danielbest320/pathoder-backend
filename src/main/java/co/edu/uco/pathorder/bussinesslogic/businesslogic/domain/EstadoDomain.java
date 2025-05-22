package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public  class EstadoDomain {

    private UUID id;
    private String nombre;

    EstadoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }
    public EstadoDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());

    }

    public EstadoDomain(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    static EstadoDomain obtenerValorDefecto() {
        return new EstadoDomain();
    }

    static EstadoDomain obtenerValorDefecto(final EstadoDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }
}

