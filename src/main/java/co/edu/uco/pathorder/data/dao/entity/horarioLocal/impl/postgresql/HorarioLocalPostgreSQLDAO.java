package co.edu.uco.pathorder.data.dao.entity.horarioLocal.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.horarioLocal.HorarioLocalDao;
import co.edu.uco.pathorder.entity.HorarioLocalEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HorarioLocalPostgreSQLDAO implements HorarioLocalDao {

    private final Connection conexion;

    public HorarioLocalPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(HorarioLocalEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO HorarioLocal(id, estado_local, hora_desde, hora_hasta) VALUES(?, ?, ?, ?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setBoolean(2, entity.getEstadoLocal());
            sentenciaPreparada.setTimestamp(3, Timestamp.valueOf(entity.getHoraDesde()));
            sentenciaPreparada.setTimestamp(4, Timestamp.valueOf(entity.getHoraHasta()));

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo registrar el horario local.";
            var mensajeTecnico = "Se presentó una SQLException al registrar el horario local.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al registrar el horario local.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar el horario local.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<HorarioLocalEntity> listByFilter(HorarioLocalEntity entity) throws PathOrderException {
        var listaHorarios = new ArrayList<HorarioLocalEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, estado_local, hora_desde, hora_hasta FROM HorarioLocal WHERE 1=1");

        var filtrarId = entity != null && entity.getId() != null;

        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int parametroIndex = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }

            try (var cursor = sentenciaPreparada.executeQuery()) {
                while (cursor.next()) {
                    var horario = new HorarioLocalEntity();
                    horario.setId(UtilUUID.convertirAUUID(cursor.getString("id")));
                    horario.setEstadoLocal(cursor.getBoolean("estado_local"));
                    horario.setHoraDesde(cursor.getTimestamp("hora_desde").toLocalDateTime());
                    horario.setHoraHasta(cursor.getTimestamp("hora_hasta").toLocalDateTime());
                    listaHorarios.add(horario);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de horarios locales.";
            var mensajeTecnico = "Se presentó una SQLException al consultar horarios locales filtrados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al consultar horarios locales.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar horarios locales.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaHorarios;
    }

    @Override
    public List<HorarioLocalEntity> listAll() throws PathOrderException {
        var listaHorarios = new ArrayList<HorarioLocalEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, estado_local, hora_desde, hora_hasta FROM HorarioLocal");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursor = sentenciaPreparada.executeQuery()) {
            while (cursor.next()) {
                var horario = new HorarioLocalEntity();
                horario.setId(UtilUUID.convertirAUUID(cursor.getString("id")));
                horario.setEstadoLocal(cursor.getBoolean("estado_local"));
                horario.setHoraDesde(cursor.getTimestamp("hora_desde").toLocalDateTime());
                horario.setHoraHasta(cursor.getTimestamp("hora_hasta").toLocalDateTime());
                listaHorarios.add(horario);
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de horarios locales.";
            var mensajeTecnico = "Se presentó una SQLException al listar todos los horarios locales.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar horarios locales.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todos los horarios locales.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaHorarios;
    }

    @Override
    public HorarioLocalEntity listById(UUID uuid) throws PathOrderException {
        var horario = new HorarioLocalEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, estado_local, hora_desde, hora_hasta FROM HorarioLocal WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var cursor = sentenciaPreparada.executeQuery()) {
                if (cursor.next()) {
                    horario.setId(UtilUUID.convertirAUUID(cursor.getString("id")));
                    horario.setEstadoLocal(cursor.getBoolean("estado_local"));
                    horario.setHoraDesde(cursor.getTimestamp("hora_desde").toLocalDateTime());
                    horario.setHoraHasta(cursor.getTimestamp("hora_hasta").toLocalDateTime());
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener el horario local solicitado.";
            var mensajeTecnico = "Se presentó una SQLException al consultar horario local por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al consultar el horario local.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar horario local por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return horario;
    }

    @Override
    public void update(UUID uuid, HorarioLocalEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE HorarioLocal SET estado_local = ?, hora_desde = ?, hora_hasta = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setBoolean(1, entity.getEstadoLocal());
            sentenciaPreparada.setTimestamp(2, Timestamp.valueOf(entity.getHoraDesde()));
            sentenciaPreparada.setTimestamp(3, Timestamp.valueOf(entity.getHoraHasta()));
            sentenciaPreparada.setObject(4, uuid);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo actualizar el horario local.";
            var mensajeTecnico = "Se presentó una SQLException al modificar un horario local.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al actualizar el horario local.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al modificar un horario local.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
