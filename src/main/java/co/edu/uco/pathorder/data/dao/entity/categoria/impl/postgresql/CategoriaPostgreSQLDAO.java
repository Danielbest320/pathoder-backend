package co.edu.uco.pathorder.data.dao.entity.categoria.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.categoria.CategoriaDao;
import co.edu.uco.pathorder.entity.CategoriaEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoriaPostgreSQLDAO implements CategoriaDao {

    private Connection conexion;

    public CategoriaPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(CategoriaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO categoria (id, nombre) VALUES (?, ?)");

        try (var statement = conexion.prepareStatement(sentenciaSQL.toString())) {
            statement.setObject(1, entity.getId());
            statement.setString(2, entity.getNombre());
            statement.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo registrar la categoría.";
            var mensajeTecnico = "Se presentó una SQLException tratando de registrar una nueva categoría.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al registrar la categoría.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar una nueva categoría.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

    }

    @Override
    public void delete(UUID uuid)  throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Categoria WHERE id = ?");
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo eliminar la categoría.";
            var mensajeTecnico = "Se presentó una SQLException tratando de eliminar una categoría.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al eliminar la categoría.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar una categoría.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<CategoriaEntity> listByFilter(CategoriaEntity entity) throws PathOrderException {
        var listaCategorias = new ArrayList<CategoriaEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Categoria WHERE 1=1");

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
                    var categoria = new CategoriaEntity();
                    categoria.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    categoria.setNombre(cursorResultado.getString("nombre"));
                    listaCategorias.add(categoria);
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la lista de categorías.";
            var mensajeTecnico = "Se presentó una SQLException tratando de listar categorías filtradas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al listar categorías.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar categorías filtradas.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return listaCategorias;
    }

    @Override
    public List<CategoriaEntity> listAll() throws PathOrderException{
        var listaCategorias = new ArrayList<CategoriaEntity>();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre FROM Categoria;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursorResultado = sentenciaPreparada.executeQuery()) {
            while (cursorResultado.next()) {
                var categoria = new CategoriaEntity();
                categoria.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                categoria.setNombre(cursorResultado.getString("nombre"));
                listaCategorias.add(categoria);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de listar todas las categorías.";
            var mensajeUsuario = "No se pudo obtener la lista de categorías.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todas las categorías.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar categorías.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return listaCategorias;
    }

    @Override
    public CategoriaEntity listById(UUID uuid) throws PathOrderException{
        var categoriaEntityRetorno = new CategoriaEntity();
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre FROM Categoria WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                if (cursorResultado.next()) {
                    categoriaEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    categoriaEntityRetorno.setNombre(cursorResultado.getString("nombre"));
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo obtener la categoría solicitada.";
            var mensajeTecnico = "Se presentó una SQLException tratando de consultar una categoría por id.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al obtener la categoría.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar una categoría por id.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
        return categoriaEntityRetorno;
    }

    @Override
    public void update(UUID uuid, CategoriaEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE Categoria SET nombre = ? WHERE id = ?;");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setObject(2, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeUsuario = "No se pudo actualizar la categoría.";
            var mensajeTecnico = "Se presentó una SQLException tratando de modificar una categoría.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeUsuario = "Ocurrió un error INESPERADO al actualizar la categoría.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al modificar una categoría.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
