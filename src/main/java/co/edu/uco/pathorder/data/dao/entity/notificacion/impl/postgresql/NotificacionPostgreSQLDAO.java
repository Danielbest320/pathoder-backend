package co.edu.uco.pathorder.data.dao.entity.notificacion.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.notificacion.NotificacionDao;
import co.edu.uco.pathorder.entity.NotificacionEntity;
import co.edu.uco.pathorder.entity.ReservaEntity;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotificacionPostgreSQLDAO implements NotificacionDao {

    private final Connection conexion;

    public NotificacionPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(NotificacionEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Notificacion(id, fecha, tipoNotificacion, reserva) VALUES(?,?,?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getFecha());
            sentenciaPreparada.setObject(3, entity.getTipoNotificacion().getId());
            sentenciaPreparada.setObject(4, entity.getReserva().getId());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al registrar una notificación.";
            var mensajeUsuario = "No fue posible registrar la notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Notificacion WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al eliminar una notificación.";
            var mensajeUsuario = "No fue posible eliminar la notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<NotificacionEntity> listByFilter(NotificacionEntity entity) throws PathOrderException {
        var listaNotificaciones = new ArrayList<NotificacionEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, fecha, tipoNotificacion, reserva FROM Notificacion WHERE 1=1");

        if (entity != null && entity.getId() != null) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (entity != null && entity.getTipoNotificacion() != null && entity.getTipoNotificacion().getId() != null) {
            sentenciaSQL.append(" AND tipoNotificacion = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int index = 1;
            if (entity != null && entity.getId() != null) {
                sentenciaPreparada.setObject(index++, entity.getId());
            }
            if (entity != null && entity.getTipoNotificacion() != null && entity.getTipoNotificacion().getId() != null) {
                sentenciaPreparada.setObject(index++, entity.getTipoNotificacion().getId());
            }

            try (var resultado = sentenciaPreparada.executeQuery()) {
                while (resultado.next()) {
                    var notificacion = new NotificacionEntity();
                    notificacion.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    notificacion.setFecha(resultado.getObject("fecha", LocalDateTime.class));
                    notificacion.setTipoNotificacion(new TipoNotificacionEntity(UtilUUID.convertirAUUID(resultado.getString("tipoNotificacion"))));
                    notificacion.setReserva(new ReservaEntity(UtilUUID.convertirAUUID(resultado.getString("reserva"))));
                    listaNotificaciones.add(notificacion);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar notificaciones.";
            var mensajeUsuario = "No fue posible consultar las notificaciones.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaNotificaciones;
    }

    @Override
    public List<NotificacionEntity> listAll() throws PathOrderException {
        var listaNotificaciones = new ArrayList<NotificacionEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, fecha, tipoNotificacion, reserva FROM Notificacion;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var resultado = sentenciaPreparada.executeQuery()) {
            while (resultado.next()) {
                var notificacion = new NotificacionEntity();
                notificacion.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                notificacion.setFecha(resultado.getObject("fecha", LocalDateTime.class));
                notificacion.setTipoNotificacion(new TipoNotificacionEntity(UtilUUID.convertirAUUID(resultado.getString("tipoNotificacion"))));
                notificacion.setReserva(new ReservaEntity(UtilUUID.convertirAUUID(resultado.getString("reserva"))));
                listaNotificaciones.add(notificacion);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al listar todas las notificaciones.";
            var mensajeUsuario = "No fue posible listar las notificaciones.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaNotificaciones;
    }

    @Override
    public NotificacionEntity listById(UUID uuid) throws PathOrderException {
        NotificacionEntity notificacion = null;
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, fecha, tipoNotificacion, reserva FROM Notificacion WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var resultado = sentenciaPreparada.executeQuery()) {
                if (resultado.next()) {
                    notificacion = new NotificacionEntity();
                    notificacion.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    notificacion.setFecha(resultado.getObject("fecha", LocalDateTime.class));
                    notificacion.setTipoNotificacion(new TipoNotificacionEntity(UtilUUID.convertirAUUID(resultado.getString("tipoNotificacion"))));
                    notificacion.setReserva(new ReservaEntity(UtilUUID.convertirAUUID(resultado.getString("reserva"))));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar una notificación por ID.";
            var mensajeUsuario = "No fue posible consultar la notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return notificacion;
    }

    @Override
    public void update(UUID uuid, NotificacionEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Notificacion SET fecha = ?, tipoNotificacion = ?, reserva = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getFecha());
            sentenciaPreparada.setObject(2, entity.getTipoNotificacion().getId());
            sentenciaPreparada.setObject(3, entity.getReserva().getId());
            sentenciaPreparada.setObject(4, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al actualizar una notificación.";
            var mensajeUsuario = "No fue posible actualizar la notificación.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}