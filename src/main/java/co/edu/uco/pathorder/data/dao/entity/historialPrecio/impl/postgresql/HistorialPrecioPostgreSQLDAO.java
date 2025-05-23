package co.edu.uco.pathorder.data.dao.entity.historialPrecio.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.historialPrecio.HistorialPrecioDao;
import co.edu.uco.pathorder.entity.HistorialPrecioEntity;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HistorialPrecioPostgreSQLDAO implements HistorialPrecioDao {

    private Connection conexion;

    public HistorialPrecioPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(HistorialPrecioEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO HistorialPrecio(id, producto, precio, fecha_desde, fecha_hasta) VALUES(?, ?, ?, ?, ?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getProducto().getId());
            sentenciaPreparada.setInt(3, entity.getPrecio());
            sentenciaPreparada.setDate(4, new java.sql.Date(entity.getFechaDesde().getTime()));
            sentenciaPreparada.setDate(5, new java.sql.Date(entity.getFechaHasta().getTime()));

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo registrar el historial de precio.";
            var mensajeTecnico = "Se presentó una SQLException al registrar el historial de precio.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al registrar el historial de precio.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar historial de precio.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<HistorialPrecioEntity> listByFilter(HistorialPrecioEntity entity) throws PathOrderException {
        var listaHistorial = new ArrayList<HistorialPrecioEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto, precio, fecha_desde, fecha_hasta FROM HistorialPrecio WHERE 1=1");

        var filtrarId = entity != null && entity.getId() != null;
        var filtrarProducto = entity != null && entity.getProducto() != null && entity.getProducto().getId() != null;

        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarProducto) {
            sentenciaSQL.append(" AND producto = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int parametroIndex = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarProducto) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getProducto().getId());
            }

            try (var cursor = sentenciaPreparada.executeQuery()) {
                while (cursor.next()) {
                    var historial = new HistorialPrecioEntity();
                    historial.setId(UtilUUID.convertirAUUID(cursor.getString("id")));

                    var producto = new ProductoEntity();
                    producto.setId(UtilUUID.convertirAUUID(cursor.getString("producto")));
                    historial.setProducto(producto);

                    historial.setPrecio(cursor.getInt("precio"));
                    historial.setFechaDesde(new Date(cursor.getDate("fecha_desde").getTime()));
                    historial.setFechaHasta(new Date(cursor.getDate("fecha_hasta").getTime()));

                    listaHistorial.add(historial);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener el historial de precios.";
            var mensajeTecnico = "Se presentó una SQLException al consultar historial de precios filtrado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al consultar el historial de precios.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar historial de precios.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaHistorial;
    }

    @Override
    public List<HistorialPrecioEntity> listAll() throws PathOrderException {
        var listaHistorial = new ArrayList<HistorialPrecioEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto, precio, fecha_desde, fecha_hasta FROM HistorialPrecio");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursor = sentenciaPreparada.executeQuery()) {
            while (cursor.next()) {
                var historial = new HistorialPrecioEntity();
                historial.setId(UtilUUID.convertirAUUID(cursor.getString("id")));

                var producto = new ProductoEntity();
                producto.setId(UtilUUID.convertirAUUID(cursor.getString("producto")));
                historial.setProducto(producto);

                historial.setPrecio(cursor.getInt("precio"));
                historial.setFechaDesde(new Date(cursor.getDate("fecha_desde").getTime()));
                historial.setFechaHasta(new Date(cursor.getDate("fecha_hasta").getTime()));

                listaHistorial.add(historial);
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener el historial de precios.";
            var mensajeTecnico = "Se presentó una SQLException al listar historial de precios.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar historial de precios.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar historial de precios.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaHistorial;
    }

    @Override
    public HistorialPrecioEntity listById(UUID uuid) throws PathOrderException {
        var historial = new HistorialPrecioEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto, precio, fecha_desde, fecha_hasta FROM HistorialPrecio WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var cursor = sentenciaPreparada.executeQuery()) {
                if (cursor.next()) {
                    historial.setId(UtilUUID.convertirAUUID(cursor.getString("id")));

                    var producto = new ProductoEntity();
                    producto.setId(UtilUUID.convertirAUUID(cursor.getString("producto")));
                    historial.setProducto(producto);

                    historial.setPrecio(cursor.getInt("precio"));
                    historial.setFechaDesde(new Date(cursor.getDate("fecha_desde").getTime()));
                    historial.setFechaHasta(new Date(cursor.getDate("fecha_hasta").getTime()));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al consultar historial de precio por ID.";
            var mensajeUsuario = "No se pudo obtener el historial de precio solicitado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al obtener el historial de precio.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar historial de precio por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return historial;
    }

    @Override
    public void update(UUID uuid, HistorialPrecioEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE HistorialPrecio SET producto = ?, precio = ?, fecha_desde = ?, fecha_hasta = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getProducto().getId());
            sentenciaPreparada.setInt(2, entity.getPrecio());
            sentenciaPreparada.setDate(3, new java.sql.Date(entity.getFechaDesde().getTime()));
            sentenciaPreparada.setDate(4, new java.sql.Date(entity.getFechaHasta().getTime()));
            sentenciaPreparada.setObject(5, uuid);

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo actualizar el historial de precio.";
            var mensajeTecnico = "Se presentó una SQLException al actualizar un historial de precio.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al actualizar el historial de precio.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al actualizar un historial de precio.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
