package co.edu.uco.pathorder.data.dao.entity.reserva.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.reserva.ReservaDao;
import co.edu.uco.pathorder.entity.ClienteEntity;
import co.edu.uco.pathorder.entity.EstadoEntity;
import co.edu.uco.pathorder.entity.ReservaEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservaPostgreSQLDAO implements ReservaDao {

    private final Connection conexion;

    public ReservaPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(ReservaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Reserva(id, cliente, pin, estado) VALUES(?,?,?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getCliente().getId());
            sentenciaPreparada.setObject(3, entity.getPin());
            sentenciaPreparada.setObject(4, entity.getEstado().getId());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al registrar una nueva reserva.";
            var mensajeUsuario = "No se pudo registrar la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar una nueva reserva.";
            var mensajeUsuario = "Ocurrió un error inesperado al registrar la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Reserva WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al eliminar una reserva.";
            var mensajeUsuario = "No se pudo eliminar la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar una reserva.";
            var mensajeUsuario = "Ocurrió un error inesperado al eliminar la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<ReservaEntity> listByFilter(ReservaEntity entity) throws PathOrderException {
        var listaReservas = new ArrayList<ReservaEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, cliente, pin, estado FROM Reserva WHERE 1=1");

        var filtrarId = entity != null && entity.getId() != null;
        var filtrarCliente = entity != null && entity.getCliente() != null && entity.getCliente().getId() != null;

        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarCliente) {
            sentenciaSQL.append(" AND cliente = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var idx = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(idx++, entity.getId());
            }
            if (filtrarCliente) {
                sentenciaPreparada.setObject(idx++, entity.getCliente().getId());
            }

            try (var rs = sentenciaPreparada.executeQuery()) {
                while (rs.next()) {
                    var reserva = new ReservaEntity();
                    reserva.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                    reserva.setCliente(new ClienteEntity(rs.getObject("cliente", UUID.class)));
                    reserva.setPin(rs.getInt("pin"));
                    reserva.setEstado(new EstadoEntity(rs.getObject("estado", UUID.class)));
                    listaReservas.add(reserva);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al consultar reservas filtradas.";
            var mensajeUsuario = "No se pudo consultar la lista de reservas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar reservas filtradas.";
            var mensajeUsuario = "Ocurrió un error inesperado al consultar reservas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaReservas;
    }

    @Override
    public List<ReservaEntity> listAll() throws PathOrderException {
        var listaReservas = new ArrayList<ReservaEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, cliente, pin, estado FROM Reserva");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var rs = sentenciaPreparada.executeQuery()) {
            while (rs.next()) {
                var reserva = new ReservaEntity();
                reserva.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                reserva.setCliente(new ClienteEntity(rs.getObject("cliente", UUID.class)));
                reserva.setPin(rs.getInt("pin"));
                reserva.setEstado(new EstadoEntity(rs.getObject("estado", UUID.class)));
                listaReservas.add(reserva);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al listar todas las reservas.";
            var mensajeUsuario = "No se pudo obtener la lista de reservas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todas las reservas.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar reservas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaReservas;
    }

    @Override
    public ReservaEntity listById(UUID uuid) throws PathOrderException {
        ReservaEntity reservaRetorno = new ReservaEntity();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, cliente, pin, estado FROM Reserva WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            try (var rs = sentenciaPreparada.executeQuery()) {
                if (rs.next()) {
                    reservaRetorno = new ReservaEntity();
                    reservaRetorno.setId(UtilUUID.convertirAUUID(rs.getString("id")));
                    reservaRetorno.setCliente(new ClienteEntity(rs.getObject("cliente", UUID.class)));
                    reservaRetorno.setPin(rs.getInt("pin"));
                    reservaRetorno.setEstado(new EstadoEntity(rs.getObject("estado", UUID.class)));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al consultar reserva por ID.";
            var mensajeUsuario = "No se pudo obtener la reserva solicitada.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar reserva por ID.";
            var mensajeUsuario = "Ocurrió un error inesperado al obtener la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return reservaRetorno;
    }

    @Override
    public void update(UUID uuid, ReservaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Reserva SET cliente = ?, pin = ?, estado = ? WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getCliente().getId());
            sentenciaPreparada.setObject(2, entity.getPin());
            sentenciaPreparada.setObject(3, entity.getEstado().getId());
            sentenciaPreparada.setObject(4, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al actualizar una reserva.";
            var mensajeUsuario = "No se pudo actualizar la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al actualizar una reserva.";
            var mensajeUsuario = "Ocurrió un error inesperado al actualizar la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
