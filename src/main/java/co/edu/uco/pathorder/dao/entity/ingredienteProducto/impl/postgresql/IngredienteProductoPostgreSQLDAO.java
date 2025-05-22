package co.edu.uco.pathorder.dao.entity.ingredienteProducto.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.IngredienteProductoDao;
import co.edu.uco.pathorder.entity.IngredienteProductoEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class IngredienteProductoPostgreSQLDAO implements IngredienteProductoDao {

    private Connection conexion;

    public IngredienteProductoPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(IngredienteProductoEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<IngredienteProductoEntity> listByFilter(IngredienteProductoEntity entity) {
        return List.of();
    }

    @Override
    public List<IngredienteProductoEntity> listAll() {
        return List.of();
    }

    @Override
    public IngredienteProductoEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, IngredienteProductoEntity entity) {

    }
}
