package co.edu.uco.pathorder.data.dao.entity.administrador.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.administrador.AdministradorDao;
import co.edu.uco.pathorder.entity.AdministradorEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdministradorPostgreSQLDAO implements AdministradorDao {

    private final Connection conexion;

    public AdministradorPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(AdministradorEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append( "INSERT INTO Administrador(id, di, nombre, apellido, correo, telefono, contrasena, "
                + "confirmacion_correo, confirmacion_telefono, estado_cuenta, usuario) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?);");
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getDi());
            sentenciaPreparada.setObject(3, entity.getNombre());
            sentenciaPreparada.setObject(4, entity.getApellido());
            sentenciaPreparada.setObject(5, entity.getCorreo());
            sentenciaPreparada.setObject(6, entity.getTelefono());
            sentenciaPreparada.setObject(7, entity.getContrasena());
            sentenciaPreparada.setObject(8, entity.isConfirmacionCorreo());
            sentenciaPreparada.setObject(9, entity.isConfirmacionTelefono());
            sentenciaPreparada.setObject(10, entity.isEstadoCuenta());
            sentenciaPreparada.setObject(11, entity.getUsuario());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de registrar un nuevo administrador.";
            var mensajeUsuario = "No se pudo registrar el administrador.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar un nuevo administrador.";
            var mensajeUsuario = "Ocurrió un error inesperado al registrar el administrador.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Administrador WHERE id = ?");
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de eliminar un administrador.";
            var mensajeUsuario = "No se pudo eliminar el administrador.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar un administrador.";
            var mensajeUsuario = "Ocurrió un error inesperado al eliminar el administrador.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<AdministradorEntity> listByFilter(AdministradorEntity entity) throws PathOrderException {
        var listaPaises = new ArrayList<AdministradorEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, di, nombre, apellido, correo, telefono, contrasena, ")
                .append("confirmacion_correo, confirmacion_telefono, estado_cuenta, usuario ")
                .append("FROM Administrador WHERE 1=1");
        var filtrarId = entity != null && entity.getId() != null;
        var filtrarUsuario = entity != null && entity.getUsuario() != null && !entity.getUsuario().isBlank();
        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarUsuario) {
            sentenciaSQL.append(" AND usuario LIKE ?");
        }
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var parametroIndex = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarUsuario) {
                sentenciaPreparada.setObject(parametroIndex++, "%" + entity.getUsuario().trim() + "%");
            }
            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                while (cursorResultado.next()) {
                    var admin = new AdministradorEntity();
                    admin.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    admin.setDi(cursorResultado.getString("di"));
                    admin.setNombre(cursorResultado.getString("nombre"));
                    admin.setApellido(cursorResultado.getString("apellido"));
                    admin.setCorreo(cursorResultado.getString("correo"));
                    admin.setTelefono(cursorResultado.getString("telefono"));
                    admin.setContrasena(cursorResultado.getString("contrasena"));
                    admin.setConfirmacionCorreo(cursorResultado.getBoolean("confirmacion_correo"));
                    admin.setConfirmacionTelefono(cursorResultado.getBoolean("confirmacion_telefono"));
                    admin.setEstadoCuenta(cursorResultado.getBoolean("estado_cuenta"));
                    admin.setUsuario(cursorResultado.getString("usuario"));
                    listaPaises.add(admin);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de listar administradores filtrados.";
            var mensajeUsuario = "No se pudo obtener la lista de administradores.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar administradores filtrados.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar administradores.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return listaPaises;
    }

    @Override
    public List<AdministradorEntity> listAll() throws PathOrderException {
        var listaAdministradores = new ArrayList<AdministradorEntity>();
        var sentenciaSQL = new StringBuilder();
         sentenciaSQL.append("SELECT id, di, nombre, apellido, correo, telefono, contrasena, "
                + "confirmacion_correo, confirmacion_telefono, estado_cuenta, usuario "
                + "FROM Administrador;");
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursorResultado = sentenciaPreparada.executeQuery()) {
            while (cursorResultado.next()) {
                var admin = new AdministradorEntity();
                admin.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                admin.setDi(cursorResultado.getString("di"));
                admin.setNombre(cursorResultado.getString("nombre"));
                admin.setApellido(cursorResultado.getString("apellido"));
                admin.setCorreo(cursorResultado.getString("correo"));
                admin.setTelefono(cursorResultado.getString("telefono"));
                admin.setContrasena(cursorResultado.getString("contrasena"));
                admin.setConfirmacionCorreo(cursorResultado.getBoolean("confirmacion_correo"));
                admin.setConfirmacionTelefono(cursorResultado.getBoolean("confirmacion_telefono"));
                admin.setEstadoCuenta(cursorResultado.getBoolean("estado_cuenta"));
                admin.setUsuario(cursorResultado.getString("usuario"));
                listaAdministradores.add(admin);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de listar todos los administradores.";
            var mensajeUsuario = "No se pudo obtener la lista de administradores.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todos los administradores.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar administradores.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return listaAdministradores;
    }

    @Override
    public AdministradorEntity listById(UUID uuid) throws PathOrderException {
        var administradorEntityRetorno = new AdministradorEntity();
        var sentenciaSQL =new StringBuilder();
         sentenciaSQL.append("SELECT id, di, nombre, apellido, correo, telefono, contrasena, "
                + "confirmacion_correo, confirmacion_telefono, estado_cuenta, usuario "
                + "FROM Administrador WHERE id = ?;");
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                if (cursorResultado.next()) {

                    administradorEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    administradorEntityRetorno.setDi(cursorResultado.getString("di"));
                    administradorEntityRetorno.setNombre(cursorResultado.getString("nombre"));
                    administradorEntityRetorno.setApellido(cursorResultado.getString("apellido"));
                    administradorEntityRetorno.setCorreo(cursorResultado.getString("correo"));
                    administradorEntityRetorno.setTelefono(cursorResultado.getString("telefono"));
                    administradorEntityRetorno.setContrasena(cursorResultado.getString("contrasena"));
                    administradorEntityRetorno.setConfirmacionCorreo(cursorResultado.getBoolean("confirmacion_correo"));
                    administradorEntityRetorno.setConfirmacionTelefono(cursorResultado.getBoolean("confirmacion_telefono"));
                    administradorEntityRetorno.setEstadoCuenta(cursorResultado.getBoolean("estado_cuenta"));
                    administradorEntityRetorno.setUsuario(cursorResultado.getString("usuario"));

                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de consultar un administrador por id.";
            var mensajeUsuario = "No se pudo obtener el administrador solicitado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar un administrador por id.";
            var mensajeUsuario = "Ocurrió un error inesperado al obtener el administrador.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return administradorEntityRetorno;
    }

    @Override
    public void update(UUID uuid, AdministradorEntity entity) throws PathOrderException {
        var sentenciaSQL =new StringBuilder();

        sentenciaSQL.append("UPDATE Administrador SET di = ?, nombre = ?, apellido = ?, correo = ?, telefono = ?, "
                + "contrasena = ?, confirmacion_correo = ?, confirmacion_telefono = ?, estado_cuenta = ?, usuario = ? "
                + "WHERE id = ?;");
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getDi());
            sentenciaPreparada.setObject(2, entity.getNombre());
            sentenciaPreparada.setObject(3, entity.getApellido());
            sentenciaPreparada.setObject(4, entity.getCorreo());
            sentenciaPreparada.setObject(5, entity.getTelefono());
            sentenciaPreparada.setObject(6, entity.getContrasena());
            sentenciaPreparada.setObject(7, entity.isConfirmacionCorreo());
            sentenciaPreparada.setObject(8, entity.isConfirmacionTelefono());
            sentenciaPreparada.setObject(9, entity.isEstadoCuenta());
            sentenciaPreparada.setObject(10, entity.getUsuario());
            sentenciaPreparada.setObject(11, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una.SQLException tratando de modificar un administrador.";
            var mensajeUsuario = "No se pudo actualizar el administrador.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al modificar un administrador.";
            var mensajeUsuario = "Ocurrió un error inesperado al actualizar el administrador.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
