package co.edu.uco.pathorder.data.dao.entity.reservaproducto.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.reservaproducto.ReservaProductoDao;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;
import co.edu.uco.pathorder.entity.ReservaEntity;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservaProductoPostgreSQLDAO implements ReservaProductoDao {

    private final Connection conexion;

    public ReservaProductoPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(ReservaProductoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO ReservaProducto(id, reserva, producto, cantidad) VALUES(?,?,?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getReserva().getId());
            sentenciaPreparada.setObject(3, entity.getProducto().getId());
            sentenciaPreparada.setInt(4, entity.getCantidad());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al registrar un producto de reserva.";
            var mensajeUsuario = "No fue posible registrar el producto de la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM ReservaProducto WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al eliminar un producto de reserva.";
            var mensajeUsuario = "No fue posible eliminar el producto de la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<ReservaProductoEntity> listByFilter(ReservaProductoEntity entity) throws PathOrderException {
        var listaReservaProductos = new ArrayList<ReservaProductoEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, reserva, producto, cantidad ")
                .append("FROM ReservaProducto WHERE 1=1");
        var filtrarId = entity != null && entity.getId() != null;
        var filtrarReserva = entity != null && entity.getReserva() != null && entity.getReserva().getId() != null;
        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarReserva) {
            sentenciaSQL.append(" AND reserva = ?");
        }
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var parametroIndex = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarReserva) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getReserva().getId());
            }
            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                while (cursorResultado.next()) {
                    var producto = new ReservaProductoEntity();
                    producto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    producto.setReserva(new ReservaEntity(UtilUUID.convertirAUUID(cursorResultado.getString("reserva"))));
                    producto.setProducto(new ProductoEntity(UtilUUID.convertirAUUID(cursorResultado.getString("producto"))));
                    producto.setCantidad(cursorResultado.getInt("cantidad"));
                    listaReservaProductos.add(producto);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de listar productos de reserva filtrados.";
            var mensajeUsuario = "No se pudo obtener la lista de productos de la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar productos de reserva filtrados.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar productos de la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return listaReservaProductos;
    }

    @Override
    public List<ReservaProductoEntity> listAll() throws PathOrderException {
        var listaReservaProductos = new ArrayList<ReservaProductoEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, reserva, producto, cantidad FROM ReservaProducto;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var resultado = sentenciaPreparada.executeQuery()) {
            while (resultado.next()) {
                var producto = new ReservaProductoEntity();
                producto.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                producto.setReserva(new ReservaEntity(UtilUUID.convertirAUUID(resultado.getString("reserva"))));
                producto.setProducto(new ProductoEntity(UtilUUID.convertirAUUID(resultado.getString("producto"))));
                producto.setCantidad(resultado.getInt("cantidad"));
                listaReservaProductos.add(producto);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al listar todos los productos de reserva.";
            var mensajeUsuario = "No fue posible listar los productos de la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaReservaProductos;
    }

    @Override
    public ReservaProductoEntity listById(UUID uuid) throws PathOrderException {
        ReservaProductoEntity producto = null;
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, reserva, producto, cantidad FROM ReservaProducto WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var resultado = sentenciaPreparada.executeQuery()) {
                if (resultado.next()) {
                    producto = new ReservaProductoEntity();
                    producto.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    producto.setReserva(new ReservaEntity(UtilUUID.convertirAUUID(resultado.getString("reserva"))));
                    producto.setProducto(new ProductoEntity(UtilUUID.convertirAUUID(resultado.getString("producto"))));
                    producto.setCantidad(resultado.getInt("cantidad"));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar un producto de reserva por ID.";
            var mensajeUsuario = "No fue posible consultar el producto de la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return producto;
    }

    @Override
    public void update(UUID uuid, ReservaProductoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE ReservaProducto SET reserva = ?, producto = ?, cantidad = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getReserva().getId());
            sentenciaPreparada.setObject(2, entity.getProducto().getId());
            sentenciaPreparada.setInt(3, entity.getCantidad());
            sentenciaPreparada.setObject(4, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al actualizar un producto de reserva.";
            var mensajeUsuario = "No fue posible actualizar el producto de la reserva.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}