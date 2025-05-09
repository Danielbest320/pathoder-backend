package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;

import java.util.UUID;

public final class ClienteEntity extends UsuarioEntity {

    public ClienteEntity() {
        super();
    }
    public ClienteEntity(final UUID id) {
        super(id);

    }

    public ClienteEntity(final UUID id, final String di, final String nombre, final String apellido, final String correo, final String telefono, final String contrasena, final boolean confirmacionCorreo, final boolean confirmacionTelefono, final boolean estadoCuenta) {
        super(id, di, nombre, apellido, correo, telefono, contrasena, confirmacionCorreo, confirmacionTelefono, estadoCuenta);
    }

    public static ClienteEntity obtenerValorDefecto() {
        return new ClienteEntity();
    }

    public static ClienteEntity obtenerValorDefecto(final ClienteEntity cliente) {
        return UtilObjeto.getInstance().obtenerValorDefecto(cliente, obtenerValorDefecto());
    }
}