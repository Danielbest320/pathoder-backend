package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public class UsuarioEntity {

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

    public UsuarioEntity() {
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


    public UsuarioEntity(final UUID id){
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

    public UsuarioEntity(final UUID id,final String di, final String nombre,final String apellido,final String correo,final String telefono,final String contrasena,final boolean confirmacionCorreo,final boolean confirmacionTelefono, final boolean estadoCuenta) {
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



    public static UsuarioEntity obtenerValorDefecto() {
        return new UsuarioEntity();
    }

    public static UsuarioEntity obtenerValorDefecto(final UsuarioEntity usuario) {
        return UtilObjeto.getInstance().obtenerValorDefecto(usuario,obtenerValorDefecto());
    }


    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getDi() {
        return di; }

    public void setDi(final String di) {
        this.di = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(di);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(nombre);
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(final String apellido) {
        this.apellido = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(apellido);
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(final String correo) {
        this.correo = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(correo);
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(final String telefono) {
        this.telefono = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(telefono);
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(final String contrasena) {
        this.contrasena = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(contrasena);
    }

    public boolean isConfirmacionCorreo() {
        return confirmacionCorreo;
    }
    public void setConfirmacionCorreo(final boolean confirmacionCorreo) {
        this.confirmacionCorreo = confirmacionCorreo;
    }

    public boolean isConfirmacionTelefono() {
        return confirmacionTelefono;
    }
    public void setConfirmacionTelefono(final boolean confirmacionTelefono) {
        this.confirmacionTelefono = confirmacionTelefono;
    }

    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }
    public void setEstadoCuenta(final boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
}