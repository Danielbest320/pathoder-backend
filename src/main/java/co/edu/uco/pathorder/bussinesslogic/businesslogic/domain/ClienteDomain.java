package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public  class ClienteDomain extends UsuarioDomain {

    ClienteDomain() {
        super();
    }

    public ClienteDomain(final UUID id) {
        super(id);
    }

    public ClienteDomain(final UUID id, final String di, final String nombre, final String apellido,
                         final String correo, final String telefono, final String contrasena,
                         final boolean confirmacionCorreo, final boolean confirmacionTelefono, final boolean estadoCuenta) {
        super(id, di, nombre, apellido, correo, telefono, contrasena, confirmacionCorreo, confirmacionTelefono, estadoCuenta);
    }

    static ClienteDomain obtenerValorDefecto() {
        return new ClienteDomain();
    }

    static ClienteDomain obtenerValorDefecto(final ClienteDomain cliente) {
        return UtilObjeto.getInstance().obtenerValorDefecto(cliente, obtenerValorDefecto());
    }
}
