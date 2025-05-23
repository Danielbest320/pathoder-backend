package co.edu.uco.pathorder.data.dao.entity.estado.impl.postgreSQLDAO;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.estado.EstadoDao;
import co.edu.uco.pathorder.entity.EstadoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EstadoPostgreSQLDAO implements EstadoDao {

    private final Connection conexion;

    public EstadoPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(EstadoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Estado(id, nombre) VALUES(?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getNombre());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al registrar un nuevo estado.";
            var mensajeUsuario = "No se pudo registrar el estado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar un nuevo estado.";
            var mensajeUsuario = "Ocurrió un error inesperado al registrar el estado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Estado WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al eliminar un estado.";
            var mensajeUsuario = "No se pudo eliminar el estado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar un estado.";
            var mensajeUsuario = "Ocurrió un error inesperado al eliminar el estado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<EstadoEntity> listByFilter(EstadoEntity entity) throws PathOrderException {
        var listaEstados = new ArrayList<EstadoEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Estado WHERE 1=1");

        var filtrarId = entity != null && entity.getId() != null;
        var filtrarNombre = entity != null && entity.getNombre() != null && !entity.getNombre().isBlank();

        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarNombre) {
            sentenciaSQL.append(" AND nombre LIKE ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var idx = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(idx++, entity.getId());
            }
            if (filtrarNombre) {
                sentenciaPreparada.setObject(idx++, "%" + entity.getNombre().trim() + "%");
            }

            try (var rs = sentenciaPreparada.executeQuery()) {
                while (rs.next()) {
                    var estado = new EstadoEntity();
                    estado.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                    estado.setNombre(rs.getString("nombre"));
                    listaEstados.add(estado);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al consultar estados filtrados.";
            var mensajeUsuario = "No se pudo consultar la lista de estados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar estados filtrados.";
            var mensajeUsuario = "Ocurrió un error inesperado al consultar estados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaEstados;
    }

    @Override
    public List<EstadoEntity> listAll() throws PathOrderException {
        var listaEstados = new ArrayList<EstadoEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Estado");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var rs = sentenciaPreparada.executeQuery()) {
            while (rs.next()) {
                var estado = new EstadoEntity();
                estado.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                estado.setNombre(rs.getString("nombre"));
                listaEstados.add(estado);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al listar todos los estados.";
            var mensajeUsuario = "No se pudo obtener la lista de estados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todos los estados.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar estados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaEstados;
    }

    @Override
    public EstadoEntity listById(UUID uuid) throws PathOrderException {
        EstadoEntity estadoRetorno = new EstadoEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Estado WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            try (var rs = sentenciaPreparada.executeQuery()) {
                if (rs.next()) {
                    estadoRetorno = new EstadoEntity();
                    estadoRetorno.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                    estadoRetorno.setNombre(rs.getString("nombre"));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al consultar estado por ID.";
            var mensajeUsuario = "No se pudo obtener el estado solicitado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar estado por ID.";
            var mensajeUsuario = "Ocurrió un error inesperado al obtener el estado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return estadoRetorno;
    }

    @Override
    public void update(UUID uuid, EstadoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Estado SET nombre = ? WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getNombre());
            sentenciaPreparada.setObject(2, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al actualizar un estado.";
            var mensajeUsuario = "No se pudo actualizar el estado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al actualizar un estado.";
            var mensajeUsuario = "Ocurrió un error inesperado al actualizar el estado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
