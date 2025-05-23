package co.edu.uco.pathorder.data.dao.entity.tipoProducto.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.tipoProducto.TipoProductoDao;
import co.edu.uco.pathorder.entity.TipoProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TipoProductoPostgreSQLDAO implements TipoProductoDao {

    private Connection conexion;

    public TipoProductoPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(TipoProductoEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO TipoProducto(id, nombre) VALUES(?, ?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo registrar el tipo de producto.";
            var mensajeTecnico = "Se presentó una SQLException al registrar un nuevo tipo de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al registrar el tipo de producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar el tipo de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<TipoProductoEntity> listByFilter(TipoProductoEntity entity) throws PathOrderException {
        var listaTipoProductos = new ArrayList<TipoProductoEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre FROM TipoProducto WHERE 1=1");

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
                sentenciaPreparada.setObject(parametroIndex++, "%" + entity.getNombre().trim() + "%");
            }

            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                while (cursorResultado.next()) {
                    var tipoProducto = new TipoProductoEntity();
                    tipoProducto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    tipoProducto.setNombre(cursorResultado.getString("nombre"));
                    listaTipoProductos.add(tipoProducto);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de tipos de producto.";
            var mensajeTecnico = "Se presentó una SQLException al listar tipos de producto filtrados.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar tipos de producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar tipos de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaTipoProductos;
    }

    @Override
    public List<TipoProductoEntity> listAll() throws PathOrderException {
        var listaTipoProductos = new ArrayList<TipoProductoEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre FROM TipoProducto;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursorResultado = sentenciaPreparada.executeQuery()) {
            while (cursorResultado.next()) {
                var tipoProducto = new TipoProductoEntity();
                tipoProducto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                tipoProducto.setNombre(cursorResultado.getString("nombre"));
                listaTipoProductos.add(tipoProducto);
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de tipos de producto.";
            var mensajeTecnico = "Se presentó una SQLException al listar todos los tipos de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar tipos de producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todos los tipos de producto.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaTipoProductos;
    }

    @Override
    public TipoProductoEntity listById(UUID uuid) throws PathOrderException {
        var tipoProducto = new TipoProductoEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre FROM TipoProducto WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                if (cursorResultado.next()) {
                    tipoProducto.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    tipoProducto.setNombre(cursorResultado.getString("nombre"));
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener el tipo de producto solicitado.";
            var mensajeTecnico = "Se presentó una SQLException al consultar un tipo de producto por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al obtener el tipo de producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar tipo de producto por ID.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return tipoProducto;
    }
}
