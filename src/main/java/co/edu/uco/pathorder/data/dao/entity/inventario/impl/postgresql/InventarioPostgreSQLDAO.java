package co.edu.uco.pathorder.data.dao.entity.inventario.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.inventario.InventarioDao;
import co.edu.uco.pathorder.entity.InventarioEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class InventarioPostgreSQLDAO implements InventarioDao {

    private Connection conexion;

    public InventarioPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(InventarioEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<InventarioEntity> listByFilter(InventarioEntity entity) {
        return List.of();
    }

    @Override
    public List<InventarioEntity> listAll() {
        return List.of();
    }

    @Override
    public InventarioEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, InventarioEntity entity) {

    }
}
