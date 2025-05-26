package co.edu.uco.pathorder.data.dao.entity.detallefactura.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.detallefactura.DetalleFacturaDao;
import co.edu.uco.pathorder.entity.DetalleFacturaEntity;
import co.edu.uco.pathorder.entity.FacturaEntity;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DetalleFacturaPostgreSQLDAO implements DetalleFacturaDao {

    private final Connection conexion;

    public DetalleFacturaPostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(DetalleFacturaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO DetalleFactura(id, reservaProducto, factura, cantidad, precioVenta, subTotal) VALUES(?,?,?,?,?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getReservaProducto().getId());
            sentenciaPreparada.setObject(3, entity.getFactura().getId());
            sentenciaPreparada.setInt(4, entity.getCantidad());
            sentenciaPreparada.setInt(5, entity.getPrecioVenta());
            sentenciaPreparada.setInt(6, entity.getSubTotal());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al registrar un detalle de factura.";
            var mensajeUsuario = "No fue posible registrar el detalle de factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM DetalleFactura WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al eliminar un detalle de factura.";
            var mensajeUsuario = "No fue posible eliminar el detalle de factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<DetalleFacturaEntity> listByFilter(DetalleFacturaEntity entity) throws PathOrderException {
        var listaDetalles = new ArrayList<DetalleFacturaEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, reservaProducto, factura, cantidad, precioVenta, subTotal FROM DetalleFactura WHERE 1=1");

        if (entity != null && entity.getId() != null) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (entity != null && entity.getFactura() != null && entity.getFactura().getId() != null) {
            sentenciaSQL.append(" AND factura = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int index = 1;
            if (entity != null && entity.getId() != null) {
                sentenciaPreparada.setObject(index++, entity.getId());
            }
            if (entity != null && entity.getFactura() != null && entity.getFactura().getId() != null) {
                sentenciaPreparada.setObject(index++, entity.getFactura().getId());
            }

            try (var resultado = sentenciaPreparada.executeQuery()) {
                while (resultado.next()) {
                    var detalle = new DetalleFacturaEntity();
                    detalle.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    detalle.setReservaProducto(new ReservaProductoEntity(UtilUUID.convertirAUUID(resultado.getString("reservaProducto"))));
                    detalle.setFactura(new FacturaEntity(UtilUUID.convertirAUUID(resultado.getString("factura"))));
                    detalle.setCantidad(resultado.getInt("cantidad"));
                    detalle.setPrecioVenta(resultado.getInt("precioVenta"));
                    detalle.setSubTotal(resultado.getInt("subTotal"));
                    listaDetalles.add(detalle);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar detalles de factura.";
            var mensajeUsuario = "No fue posible consultar los detalles de factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaDetalles;
    }

    @Override
    public List<DetalleFacturaEntity> listAll() throws PathOrderException {
        var listaDetalles = new ArrayList<DetalleFacturaEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, reservaProducto, factura, cantidad, precioVenta, subTotal FROM DetalleFactura;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var resultado = sentenciaPreparada.executeQuery()) {
            while (resultado.next()) {
                var detalle = new DetalleFacturaEntity();
                detalle.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                detalle.setReservaProducto(new ReservaProductoEntity(UtilUUID.convertirAUUID(resultado.getString("reservaProducto"))));
                detalle.setFactura(new FacturaEntity(UtilUUID.convertirAUUID(resultado.getString("factura"))));
                detalle.setCantidad(resultado.getInt("cantidad"));
                detalle.setPrecioVenta(resultado.getInt("precioVenta"));
                detalle.setSubTotal(resultado.getInt("subTotal"));
                listaDetalles.add(detalle);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al listar todos los detalles de factura.";
            var mensajeUsuario = "No fue posible listar los detalles de factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaDetalles;
    }

    @Override
    public DetalleFacturaEntity listById(UUID uuid) throws PathOrderException {
        DetalleFacturaEntity detalle = null;
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, reservaProducto, factura, cantidad, precioVenta, subTotal FROM DetalleFactura WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var resultado = sentenciaPreparada.executeQuery()) {
                if (resultado.next()) {
                    detalle = new DetalleFacturaEntity();
                    detalle.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                    detalle.setReservaProducto(new ReservaProductoEntity(UtilUUID.convertirAUUID(resultado.getString("reservaProducto"))));
                    detalle.setFactura(new FacturaEntity(UtilUUID.convertirAUUID(resultado.getString("factura"))));
                    detalle.setCantidad(resultado.getInt("cantidad"));
                    detalle.setPrecioVenta(resultado.getInt("precioVenta"));
                    detalle.setSubTotal(resultado.getInt("subTotal"));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al consultar un detalle de factura por ID.";
            var mensajeUsuario = "No fue posible consultar el detalle de factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return detalle;
    }

    @Override
    public void update(UUID uuid, DetalleFacturaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE DetalleFactura SET reservaProducto = ?, factura = ?, cantidad = ?, precioVenta = ?, subTotal = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getReservaProducto().getId());
            sentenciaPreparada.setObject(2, entity.getFactura().getId());
            sentenciaPreparada.setInt(3, entity.getCantidad());
            sentenciaPreparada.setInt(4, entity.getPrecioVenta());
            sentenciaPreparada.setInt(5, entity.getSubTotal());
            sentenciaPreparada.setObject(6, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó un error al actualizar un detalle de factura.";
            var mensajeUsuario = "No fue posible actualizar el detalle de factura.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}