package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;


import java.util.UUID;



public final class ClienteDTO extends UsuarioDTO {

    public ClienteDTO() {
        super();
    }

    public ClienteDTO(final UUID id){
        super(id);

    }
    public ClienteDTO(final UUID id, final String di, final String nombre, final String apellido, final String correo, final String telefono, final String contrasena, final boolean confirmacionCorreo, final boolean confirmacionTelefono, final boolean estadoCuenta) {
        super(id,di,nombre,apellido,correo,telefono,contrasena, confirmacionCorreo, confirmacionTelefono, estadoCuenta);

    }

    public static ClienteDTO obtenerValorDefecto() {
        return new ClienteDTO();
    }

  public static ClienteDTO obtenerValorDefecto(final ClienteDTO cliente) {
        return UtilObjeto.getIntance().obtenerValorDefecto(cliente,obtenerValorDefecto());

  }

}
