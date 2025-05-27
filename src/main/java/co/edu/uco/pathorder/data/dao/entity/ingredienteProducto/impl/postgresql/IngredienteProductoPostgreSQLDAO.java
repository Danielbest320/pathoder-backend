package co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.IngredienteProductoDao;
import co.edu.uco.pathorder.entity.IngredienteProductoEntity;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IngredienteProductoPostgreSQLDAO implements IngredienteProductoDao {

    private final Connection conexion;

    public IngredienteProductoPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(IngredienteProductoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO IngredienteProducto(id, producto_venta, producto_ingrediente, cantidad) VALUES(?, ?, ?, ?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getProductoVenta().getId());
            sentenciaPreparada.setObject(3, entity.getProductoIngrediente().getId());
            sentenciaPreparada.setInt(4, entity.getCantidad());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo registrar el ingrediente del producto.";
            var mensajeTecnico = "Se presentó una SQLException al registrar un ingrediente de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al registrar el ingrediente del producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar un ingrediente del producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("DELETE FROM IngredienteProducto WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo eliminar el ingrediente del producto.";
            var mensajeTecnico = "Se presentó una SQLException al eliminar un ingrediente de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al eliminar el ingrediente del producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar un ingrediente del producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<IngredienteProductoEntity> listByFilter(IngredienteProductoEntity entity) throws PathOrderException {
        var listaIngredientes = new ArrayList<IngredienteProductoEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto_venta, producto_ingrediente, cantidad FROM IngredienteProducto WHERE 1=1");

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
                    var ingrediente = new IngredienteProductoEntity();
                    ingrediente.setId(UtilUUID.convertirAUUID(cursor.getString("id")));

                    var productoVenta = new ProductoEntity();
                    productoVenta.setId(UtilUUID.convertirAUUID(cursor.getString("producto_venta")));
                    ingrediente.setProductoVenta(productoVenta);

                    var productoIngrediente = new ProductoEntity();
                    productoIngrediente.setId(UtilUUID.convertirAUUID(cursor.getString("producto_ingrediente")));
                    ingrediente.setProductoIngrediente(productoIngrediente);

                    ingrediente.setCantidad(cursor.getInt("cantidad"));

                    listaIngredientes.add(ingrediente);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de ingredientes de producto.";
            var mensajeTecnico = "Se presentó una SQLException al consultar ingredientes de producto filtrados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al consultar ingredientes de producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar ingredientes de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaIngredientes;
    }

    @Override
    public List<IngredienteProductoEntity> listAll() throws PathOrderException {
        var listaIngredientes = new ArrayList<IngredienteProductoEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto_venta, producto_ingrediente, cantidad FROM IngredienteProducto");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursor = sentenciaPreparada.executeQuery()) {
            while (cursor.next()) {
                var ingrediente = new IngredienteProductoEntity();
                ingrediente.setId(UtilUUID.convertirAUUID(cursor.getString("id")));

                var productoVenta = new ProductoEntity();
                productoVenta.setId(UtilUUID.convertirAUUID(cursor.getString("producto_venta")));
                ingrediente.setProductoVenta(productoVenta);

                var productoIngrediente = new ProductoEntity();
                productoIngrediente.setId(UtilUUID.convertirAUUID(cursor.getString("producto_ingrediente")));
                ingrediente.setProductoIngrediente(productoIngrediente);

                ingrediente.setCantidad(cursor.getInt("cantidad"));

                listaIngredientes.add(ingrediente);
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de ingredientes de producto.";
            var mensajeTecnico = "Se presentó una SQLException al listar todos los ingredientes de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar ingredientes de producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar ingredientes de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaIngredientes;
    }

    @Override
    public IngredienteProductoEntity listById(UUID uuid) throws PathOrderException {
        var ingrediente = new IngredienteProductoEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto_venta, producto_ingrediente, cantidad FROM IngredienteProducto WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var cursor = sentenciaPreparada.executeQuery()) {
                if (cursor.next()) {
                    ingrediente.setId(UtilUUID.convertirAUUID(cursor.getString("id")));

                    var productoVenta = new ProductoEntity();
                    productoVenta.setId(UtilUUID.convertirAUUID(cursor.getString("producto_venta")));
                    ingrediente.setProductoVenta(productoVenta);

                    var productoIngrediente = new ProductoEntity();
                    productoIngrediente.setId(UtilUUID.convertirAUUID(cursor.getString("producto_ingrediente")));
                    ingrediente.setProductoIngrediente(productoIngrediente);

                    ingrediente.setCantidad(cursor.getInt("cantidad"));
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener el ingrediente del producto solicitado.";
            var mensajeTecnico = "Se presentó una SQLException al consultar ingrediente de producto por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al consultar el ingrediente del producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar ingrediente de producto por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return ingrediente;
    }

    @Override
    public void update(UUID uuid, IngredienteProductoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE IngredienteProducto SET producto_venta = ?, producto_ingrediente = ?, cantidad = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getProductoVenta().getId());
            sentenciaPreparada.setObject(2, entity.getProductoIngrediente().getId());
            sentenciaPreparada.setInt(3, entity.getCantidad());
            sentenciaPreparada.setObject(4, uuid);

            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo actualizar el ingrediente del producto.";
            var mensajeTecnico = "Se presentó una SQLException al modificar un ingrediente del producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al actualizar el ingrediente del producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al modificar un ingrediente del producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
