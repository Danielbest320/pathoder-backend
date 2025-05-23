package co.edu.uco.pathorder.data.dao.entity.producto.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.producto.ProductoDao;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductoPostgreSQLDAO implements ProductoDao {

    private Connection conexion;

    public ProductoPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(ProductoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO Producto(id, nombre, tipo_producto, descripcion, precio, categoria) VALUES(?, ?, ?, ?, ?, ?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());
            sentenciaPreparada.setObject(3, entity.getTipoProducto().getId());
            sentenciaPreparada.setString(4, entity.getDescripcion());
            sentenciaPreparada.setInt(5, entity.getPrecio());
            sentenciaPreparada.setObject(6, entity.getCategoria().getId());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo registrar el producto.";
            var mensajeTecnico = "Se presentó una SQLException al registrar un nuevo producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al registrar el producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar el producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }


    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("DELETE FROM Producto WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al eliminar un producto.";
            var mensajeUsuario = "No se pudo eliminar el producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar un producto.";
            var mensajeUsuario = "Ocurrió un error inesperado al eliminar el producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<ProductoEntity> listByFilter(ProductoEntity entity) throws PathOrderException {
        var listaProductos = new ArrayList<ProductoEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre, tipo_producto, descripcion, precio, categoria FROM Producto WHERE 1=1");

        var filtrarId = entity != null && entity.getId() != null;
        var filtrarNombre = entity != null && entity.getNombre() != null && !entity.getNombre().isBlank();

        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarNombre) {
            sentenciaSQL.append(" AND nombre ILIKE ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var parametroIndex = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarNombre) {
                sentenciaPreparada.setString(parametroIndex++, "%" + entity.getNombre().trim() + "%");
            }

            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                while (cursorResultado.next()) {
                    var producto = new ProductoEntity();
                    producto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    producto.setNombre(cursorResultado.getString("nombre"));

                    var tipoProducto = new co.edu.uco.pathorder.entity.TipoProductoEntity();
                    tipoProducto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("tipo_producto")));
                    producto.setTipoProducto(tipoProducto);

                    producto.setDescripcion(cursorResultado.getString("descripcion"));
                    producto.setPrecio(cursorResultado.getInt("precio"));

                    var categoria = new co.edu.uco.pathorder.entity.CategoriaEntity();
                    categoria.setId(UtilUUID.convertirAUUID(cursorResultado.getString("categoria")));
                    producto.setCategoria(categoria);

                    listaProductos.add(producto);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de productos.";
            var mensajeTecnico = "Se presentó una SQLException al listar productos filtrados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar productos.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar productos.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaProductos;
    }

    @Override
    public List<ProductoEntity> listAll() throws PathOrderException {
        var listaProductos = new ArrayList<ProductoEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre, tipo_producto, descripcion, precio, categoria FROM Producto");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursorResultado = sentenciaPreparada.executeQuery()) {
            while (cursorResultado.next()) {
                var producto = new ProductoEntity();
                producto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                producto.setNombre(cursorResultado.getString("nombre"));

                var tipoProducto = new co.edu.uco.pathorder.entity.TipoProductoEntity();
                tipoProducto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("tipo_producto")));
                producto.setTipoProducto(tipoProducto);

                producto.setDescripcion(cursorResultado.getString("descripcion"));
                producto.setPrecio(cursorResultado.getInt("precio"));

                var categoria = new co.edu.uco.pathorder.entity.CategoriaEntity();
                categoria.setId(UtilUUID.convertirAUUID(cursorResultado.getString("categoria")));
                producto.setCategoria(categoria);

                listaProductos.add(producto);
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de productos.";
            var mensajeTecnico = "Se presentó una SQLException al listar todos los productos.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar productos.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todos los productos.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaProductos;
    }

    @Override
    public ProductoEntity listById(UUID uuid) throws PathOrderException {
        var producto = new ProductoEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre, tipo_producto, descripcion, precio, categoria FROM Producto WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                if (cursorResultado.next()) {
                    producto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    producto.setNombre(cursorResultado.getString("nombre"));

                    var tipoProducto = new co.edu.uco.pathorder.entity.TipoProductoEntity();
                    tipoProducto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("tipo_producto")));
                    producto.setTipoProducto(tipoProducto);

                    producto.setDescripcion(cursorResultado.getString("descripcion"));
                    producto.setPrecio(cursorResultado.getInt("precio"));

                    var categoria = new co.edu.uco.pathorder.entity.CategoriaEntity();
                    categoria.setId(UtilUUID.convertirAUUID(cursorResultado.getString("categoria")));
                    producto.setCategoria(categoria);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener el producto solicitado.";
            var mensajeTecnico = "Se presentó una SQLException al consultar un producto por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al obtener el producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar un producto por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return producto;
    }

    @Override
    public void update(UUID uuid, ProductoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE Producto SET nombre = ?, tipo_producto = ?, descripcion = ?, precio = ?, categoria = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setObject(2, entity.getTipoProducto().getId());
            sentenciaPreparada.setString(3, entity.getDescripcion());
            sentenciaPreparada.setInt(4, entity.getPrecio());
            sentenciaPreparada.setObject(5, entity.getCategoria().getId());
            sentenciaPreparada.setObject(6, uuid);

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo actualizar el producto.";
            var mensajeTecnico = "Se presentó una SQLException al modificar un producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al actualizar el producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al modificar un producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
