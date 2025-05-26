package co.edu.uco.pathorder.data.dao.entity.factura.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.factura.FacturaDao;
import co.edu.uco.pathorder.entity.AdministradorEntity;
import co.edu.uco.pathorder.entity.FacturaEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacturaPostgreSQLDAO implements FacturaDao {

    private final Connection conexion;

    public FacturaPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(FacturaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Factura(id, administrador, fechaHora, total) VALUES(?,?,?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getAdministrador().getId());
            sentenciaPreparada.setObject(3, entity.getFechaHora());
            sentenciaPreparada.setInt(4, entity.getTotal());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al registrar una factura.";
            var mensajeUsuario = "No fue posible registrar la factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Factura WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al eliminar una factura.";
            var mensajeUsuario = "No fue posible eliminar la factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<FacturaEntity> listByFilter(FacturaEntity entity) throws PathOrderException {
        var listaFacturas = new ArrayList<FacturaEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, administrador, fechaHora, total ")
                .append("FROM Factura WHERE 1=1");
        var filtrarId = entity != null && entity.getId() != null;
        var filtrarAdministrador = entity != null && entity.getAdministrador() != null && entity.getAdministrador().getId() != null;
        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarAdministrador) {
            sentenciaSQL.append(" AND administrador = ?");
        }
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var parametroIndex = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarAdministrador) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getAdministrador().getId());
            }
            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                while (cursorResultado.next()) {
                    var factura = new FacturaEntity();
                    factura.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    factura.setAdministrador(new AdministradorEntity(UtilUUID.convertirAUUID(cursorResultado.getString("administrador"))));
                    factura.setFechaHora(cursorResultado.getObject("fechaHora", LocalDateTime.class));
                    factura.setTotal(cursorResultado.getInt("total"));
                    listaFacturas.add(factura);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de listar facturas filtradas.";
            var mensajeUsuario = "No se pudo obtener la lista de facturas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar facturas filtradas.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar facturas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return listaFacturas;
    }

    @Override
    public List<FacturaEntity> listAll() throws PathOrderException {
        var listaFacturas = new ArrayList<FacturaEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, administrador, fechaHora, total FROM Factura;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var resultado = sentenciaPreparada.executeQuery()) {
            while (resultado.next()) {
                var factura = new FacturaEntity();
                factura.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                factura.setAdministrador(new AdministradorEntity(UtilUUID.convertirAUUID(resultado.getString("administrador"))));
                factura.setFechaHora(resultado.getObject("fechaHora", LocalDateTime.class));
                factura.setTotal(resultado.getInt("total"));
                listaFacturas.add(factura);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al listar todas las facturas.";
            var mensajeUsuario = "No fue posible listar las facturas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaFacturas;
    }

    @Override
    public FacturaEntity listById(UUID uuid) throws PathOrderException {
        FacturaEntity factura = null;
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, administrador, fechaHora, total FROM Factura WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var resultado = sentenciaPreparada.executeQuery()) {
                if (resultado.next()) {
                    factura = new FacturaEntity();
                    factura.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    factura.setAdministrador(new AdministradorEntity(UtilUUID.convertirAUUID(resultado.getString("administrador"))));
                    factura.setFechaHora(resultado.getObject("fechaHora", LocalDateTime.class));
                    factura.setTotal(resultado.getInt("total"));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar una factura por ID.";
            var mensajeUsuario = "No fue posible consultar la factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return factura;
    }

    @Override
    public void update(UUID uuid, FacturaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Factura SET administrador = ?, fechaHora = ?, total = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getAdministrador().getId());
            sentenciaPreparada.setObject(2, entity.getFechaHora());
            sentenciaPreparada.setInt(3, entity.getTotal());
            sentenciaPreparada.setObject(4, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al actualizar una factura.";
            var mensajeUsuario = "No fue posible actualizar la factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}