package co.edu.uco.pathorder.data.dao.entity.inventario.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.inventario.InventarioDao;
import co.edu.uco.pathorder.entity.InventarioEntity;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventarioPostgreSQLDAO implements InventarioDao {

    private Connection conexion;

    public InventarioPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(InventarioEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO Inventario(id, producto, disponibilidad) VALUES(?, ?, ?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getProducto().getId());
            sentenciaPreparada.setInt(3, entity.getDisponibilidad());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo registrar el inventario.";
            var mensajeTecnico = "Se presentó una SQLException al registrar un nuevo inventario.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al registrar el inventario.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar el inventario.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("DELETE FROM Inventario WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo eliminar el inventario.";
            var mensajeTecnico = "Se presentó una SQLException al eliminar un inventario.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al eliminar el inventario.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar un inventario.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<InventarioEntity> listByFilter(InventarioEntity entity) throws PathOrderException {
        var listaInventarios = new ArrayList<InventarioEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto, disponibilidad FROM Inventario WHERE 1=1");

        var filtrarId = entity != null && entity.getId() != null;
        var filtrarProducto = entity != null && entity.getProducto() != null && entity.getProducto().getId() != null;

        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarProducto) {
            sentenciaSQL.append(" AND producto = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var parametroIndex = 1;
            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarProducto) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getProducto().getId());
            }

            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                while (cursorResultado.next()) {
                    var inventario = new InventarioEntity();
                    inventario.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));

                    var producto = new ProductoEntity();
                    producto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("producto")));
                    inventario.setProducto(producto);

                    inventario.setDisponibilidad(cursorResultado.getInt("disponibilidad"));
                    listaInventarios.add(inventario);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de inventarios.";
            var mensajeTecnico = "Se presentó una SQLException al listar inventarios filtrados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar inventarios.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar inventarios.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaInventarios;
    }

    @Override
    public List<InventarioEntity> listAll() throws PathOrderException {
        var listaInventarios = new ArrayList<InventarioEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto, disponibilidad FROM Inventario;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursorResultado = sentenciaPreparada.executeQuery()) {
            while (cursorResultado.next()) {
                var inventario = new InventarioEntity();
                inventario.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));

                var producto = new ProductoEntity();
                producto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("producto")));
                inventario.setProducto(producto);

                inventario.setDisponibilidad(cursorResultado.getInt("disponibilidad"));
                listaInventarios.add(inventario);
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de inventarios.";
            var mensajeTecnico = "Se presentó una SQLException al listar todos los inventarios.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar inventarios.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todos los inventarios.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaInventarios;
    }

    @Override
    public InventarioEntity listById(UUID uuid) throws PathOrderException {
        var inventario = new InventarioEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, producto, disponibilidad FROM Inventario WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);

            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                if (cursorResultado.next()) {
                    inventario.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));

                    var producto = new ProductoEntity();
                    producto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("producto")));
                    inventario.setProducto(producto);

                    inventario.setDisponibilidad(cursorResultado.getInt("disponibilidad"));
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener el inventario solicitado.";
            var mensajeTecnico = "Se presentó una SQLException al consultar inventario por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al obtener el inventario.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar inventario por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return inventario;
    }

    @Override
    public void update(UUID uuid, InventarioEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE Inventario SET producto = ?, disponibilidad = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getProducto().getId());
            sentenciaPreparada.setInt(2, entity.getDisponibilidad());
            sentenciaPreparada.setObject(3, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo actualizar el inventario.";
            var mensajeTecnico = "Se presentó una SQLException al modificar un inventario.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al actualizar el inventario.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al modificar un inventario.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
