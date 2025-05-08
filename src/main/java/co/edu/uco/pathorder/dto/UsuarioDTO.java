package co.edu.uco.pathorder.dto;



import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class UsuarioDTO {

    private UUID id;
    private String di;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String contrasena;
    private boolean confirmacionCorreo;
    private boolean confirmacionTelefono;
    private boolean estadoCuenta;

    public UsuarioDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setDi(UtilTexto.getInstance().obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setApellido(UtilTexto.getInstance().obtenerValorDefecto());
        setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
        setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
        setContrasena(UtilTexto.getInstance().obtenerValorDefecto());
        setConfirmacionCorreo(false);
        setConfirmacionTelefono(false);
        setEstadoCuenta(false);
    }

    public UsuarioDTO(final UUID id) {
        setId(id);
        setDi(UtilTexto.getInstance().obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setApellido(UtilTexto.getInstance().obtenerValorDefecto());
        setCorreo(UtilTexto.getInstance().obtenerValorDefecto());
        setTelefono(UtilTexto.getInstance().obtenerValorDefecto());
        setContrasena(UtilTexto.getInstance().obtenerValorDefecto());
        setConfirmacionCorreo(false);
        setConfirmacionTelefono(false);
        setEstadoCuenta(false);

    }


    public UsuarioDTO(final UUID id, final String di, final String nombre, final String apellido, final String correo, final String telefono, final String contrasena, final boolean confirmacionCorreo, final boolean confirmacionTelefono, final boolean estadoCuenta) {
        setId(id);
        setDi(di);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setTelefono(telefono);
        setContrasena(contrasena);
        setConfirmacionCorreo(confirmacionCorreo);
        setConfirmacionTelefono(confirmacionTelefono);
        setEstadoCuenta(estadoCuenta);
    }

    public static UsuarioDTO obtenerValorDefecto() {
        return new UsuarioDTO();
    }

    public static UsuarioDTO obtenerValorDefecto(final UsuarioDTO dto) {
        return UtilObjeto.getIntance().obtenerValorDefecto(dto, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public UsuarioDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getDi() {
        return di;
    }

    public UsuarioDTO setDi(final String di) {
        this.di = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(di);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public UsuarioDTO setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public UsuarioDTO setApellido(final String apellido) {
        this.apellido = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(apellido);
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public UsuarioDTO setCorreo(final String correo) {
        this.correo = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(correo);
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public UsuarioDTO setTelefono(final String telefono) {
        this.telefono = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(telefono);
        return this;
    }

    public String getContrasena() {
        return contrasena;
    }

    public UsuarioDTO setContrasena(final String contrasena) {
        this.contrasena = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(contrasena);
        return this;
    }

    public boolean isConfirmacionCorreo() {
        return confirmacionCorreo;
    }

    public UsuarioDTO setConfirmacionCorreo(final boolean confirmacionCorreo) {
        this.confirmacionCorreo = confirmacionCorreo;
        return this;
    }

    public boolean isConfirmacionTelefono() {
        return confirmacionTelefono;
    }

    public UsuarioDTO setConfirmacionTelefono(final boolean confirmacionTelefono) {
        this.confirmacionTelefono = confirmacionTelefono;
        return this;
    }

    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    public UsuarioDTO setEstadoCuenta(final boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
        return this;
    }
}
