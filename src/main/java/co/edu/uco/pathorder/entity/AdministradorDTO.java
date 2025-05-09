package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;

import java.util.UUID;

public final class AdministradorDTO extends UsuarioEntity {

    private String usuario;

    public AdministradorDTO() {
        super();
        setUsuario(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public AdministradorDTO(final UUID id) {
        super(id);
        setUsuario(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public AdministradorDTO(final UUID id, final  String di, final String nombre, final String apellido, final String correo, final String telefono, final String contrasena, final boolean confirmacionCorreo, final boolean confirmacionTelefono, final boolean estadoCuenta, String usuario) {
        super(id, di, nombre, apellido, correo, telefono, contrasena, confirmacionCorreo, confirmacionTelefono, estadoCuenta);
        setUsuario(usuario);
    }

    public static AdministradorDTO obtenerValorDefecto() {
        return new AdministradorDTO();
    }

    public static AdministradorDTO obtenerValorDefecto(final AdministradorDTO administrador) {
        return UtilObjeto.getInstance().obtenerValorDefecto(administrador,obtenerValorDefecto());
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(usuario);
    }
}