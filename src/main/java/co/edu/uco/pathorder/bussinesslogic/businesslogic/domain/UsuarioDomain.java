package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class UsuarioDomain {

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

    UsuarioDomain() {
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

    public UsuarioDomain(final UUID id) {
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

    public UsuarioDomain(final UUID id, final String di, final String nombre, final String apellido,
                         final String correo, final String telefono, final String contrasena,
                         final boolean confirmacionCorreo, final boolean confirmacionTelefono,
                         final boolean estadoCuenta) {
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

    static UsuarioDomain obtenerValorDefecto() {
        return new UsuarioDomain();
    }

    static UsuarioDomain obtenerValorDefecto(final UsuarioDomain domain) {
        return UtilObjeto.getInstance().obtenerValorDefecto(domain, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getDi() {
        return di;
    }

    private void setDi(final String di) {
        this.di = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(di);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }

    public String getApellido() {
        return apellido;
    }

    private void setApellido(final String apellido) {
        this.apellido = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(apellido);
    }

    public String getCorreo() {
        return correo;
    }

    private void setCorreo(final String correo) {
        this.correo = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(correo);
    }

    public String getTelefono() {
        return telefono;
    }

    private void setTelefono(final String telefono) {
        this.telefono = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(telefono);
    }

    public String getContrasena() {
        return contrasena;
    }

    private void setContrasena(final String contrasena) {
        this.contrasena = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(contrasena);
    }

    public boolean isConfirmacionCorreo() {
        return confirmacionCorreo;
    }

    private void setConfirmacionCorreo(final boolean confirmacionCorreo) {
        this.confirmacionCorreo = confirmacionCorreo;
    }

    public boolean isConfirmacionTelefono() {
        return confirmacionTelefono;
    }

    private void setConfirmacionTelefono(final boolean confirmacionTelefono) {
        this.confirmacionTelefono = confirmacionTelefono;
    }

    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    private void setEstadoCuenta(final boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
}

