package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;

import java.util.UUID;

public final class AdministradorEntity extends UsuarioEntity {

    private String usuario;

    public AdministradorEntity() {
        super();
        setUsuario(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public AdministradorEntity(final UUID id) {
        super(id);
        setUsuario(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public AdministradorEntity(final UUID id,final  String di,final String nombre,final String apellido,final String correo,final String telefono,final String contrasena,final boolean confirmacionCorreo,final boolean confirmacionTelefono,final boolean estadoCuenta, String usuario) {
        super(id, di, nombre, apellido, correo, telefono, contrasena, confirmacionCorreo, confirmacionTelefono, estadoCuenta);
        setUsuario(usuario);
    }

    public static AdministradorEntity obtenerValorDefecto() {
        return new AdministradorEntity();
    }

    public static AdministradorEntity obtenerValorDefecto(final AdministradorEntity administrador) {
        return UtilObjeto.getIntance().obtenerValorDefecto(administrador,obtenerValorDefecto());
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(usuario);
    }
}