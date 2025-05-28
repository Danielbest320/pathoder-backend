package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilBooleano;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;

import java.util.UUID;

public  class AdministradorDomain extends UsuarioDomain {

    private String usuario;

    AdministradorDomain() {
        super();
        setUsuario(UtilTexto.getInstance().obtenerValorDefecto());
        setConfirmacionCorreo(UtilBooleano.getInstance().obtenerValorDefecto());
        setConfirmacionTelefono(UtilBooleano.getInstance().obtenerValorDefecto());
        setEstadoCuenta(UtilBooleano.getInstance().obtenerValorDefecto());

    }

    public AdministradorDomain(final UUID id) {
        super(id);
        setUsuario(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public AdministradorDomain(final UUID id, final String di, final String nombre, final String apellido, final String correo,
                               final String telefono, final String contrasena, final boolean confirmacionCorreo,
                               final boolean confirmacionTelefono, final boolean estadoCuenta, final String usuario) {
        super(id, di, nombre, apellido, correo, telefono, contrasena, confirmacionCorreo, confirmacionTelefono, estadoCuenta);
        setUsuario(usuario);
    }

    static AdministradorDomain obtenerValorDefecto() {
        return new AdministradorDomain();
    }

    static AdministradorDomain obtenerValorDefecto(final AdministradorDomain administrador) {
        return UtilObjeto.getInstance().obtenerValorDefecto(administrador, obtenerValorDefecto());
    }

    public String getUsuario() {
        return usuario;
    }

    private void setUsuario(final String usuario) {
        this.usuario = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(usuario);
    }
}
