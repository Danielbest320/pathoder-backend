package co.edu.uco.pathorder.data.dao.entity.tiponotificacion.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.tiponotificacion.TipoNotificacionDao;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TipoNotificacionPostgreSQLDAO implements TipoNotificacionDao {

    private final Connection conexion;

    public TipoNotificacionPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(TipoNotificacionEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO TipoNotificacion(id, nombre, mensaje, descripcion) VALUES(?,?,?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());
            sentenciaPreparada.setString(3, entity.getMensaje());
            sentenciaPreparada.setString(4, entity.getDescripcion());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al registrar un tipo de notificación.";
            var mensajeUsuario = "No fue posible registrar el tipo de notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM TipoNotificacion WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al eliminar un tipo de notificación.";
            var mensajeUsuario = "No fue posible eliminar el tipo de notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<TipoNotificacionEntity> listByFilter(TipoNotificacionEntity entity) throws PathOrderException {
        var listaTipos = new ArrayList<TipoNotificacionEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, mensaje, descripcion FROM TipoNotificacion WHERE 1=1");

        if (entity != null && entity.getId() != null) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (entity != null && entity.getNombre() != null && !entity.getNombre().isBlank()) {
            sentenciaSQL.append(" AND nombre = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int index = 1;
            if (entity != null && entity.getId() != null) {
                sentenciaPreparada.setObject(index++, entity.getId());
            }
            if (entity != null && entity.getNombre() != null && !entity.getNombre().isBlank()) {
                sentenciaPreparada.setString(index++, entity.getNombre());
            }

            try (var resultado = sentenciaPreparada.executeQuery()) {
                while (resultado.next()) {
                    var tipo = new TipoNotificacionEntity();
                    tipo.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    tipo.setNombre(resultado.getString("nombre"));
                    tipo.setMensaje(resultado.getString("mensaje"));
                    tipo.setDescripcion(resultado.getString("descripcion"));
                    listaTipos.add(tipo);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar tipos de notificación.";
            var mensajeUsuario = "No fue posible consultar los tipos de notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaTipos;
    }

    @Override
    public List<TipoNotificacionEntity> listAll() throws PathOrderException {
        var listaTipos = new ArrayList<TipoNotificacionEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, mensaje, descripcion FROM TipoNotificacion;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var resultado = sentenciaPreparada.executeQuery()) {
            while (resultado.next()) {
                var tipo = new TipoNotificacionEntity();
                tipo.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                tipo.setNombre(resultado.getString("nombre"));
                tipo.setMensaje(resultado.getString("mensaje"));
                tipo.setDescripcion(resultado.getString("descripcion"));
                listaTipos.add(tipo);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al listar todos los tipos de notificación.";
            var mensajeUsuario = "No fue posible listar los tipos de notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaTipos;
    }

    @Override
    public TipoNotificacionEntity listById(UUID uuid) throws PathOrderException {
        TipoNotificacionEntity tipo = null;
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, mensaje, descripcion FROM TipoNotificacion WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var resultado = sentenciaPreparada.executeQuery()) {
                if (resultado.next()) {
                    tipo = new TipoNotificacionEntity();
                    tipo.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    tipo.setNombre(resultado.getString("nombre"));
                    tipo.setMensaje(resultado.getString("mensaje"));
                    tipo.setDescripcion(resultado.getString("descripcion"));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar un tipo de notificación por ID.";
            var mensajeUsuario = "No fue posible consultar el tipo de notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return tipo;
    }

    @Override
    public void update(UUID uuid, TipoNotificacionEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE TipoNotificacion SET nombre = ?, mensaje = ?, descripcion = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setString(2, entity.getMensaje());
            sentenciaPreparada.setString(3, entity.getDescripcion());
            sentenciaPreparada.setObject(4, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al actualizar un tipo de notificación.";
            var mensajeUsuario = "No fue posible actualizar el tipo de notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}