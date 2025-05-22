package co.edu.uco.pathorder.dao.entity.categoria.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.categoria.CategoriaDao;
import co.edu.uco.pathorder.entity.CategoriaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class CategoriaPostgreSQLDAO implements CategoriaDao {

    private Connection conexion;

    public CategoriaPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(CategoriaEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<CategoriaEntity> listByFilter(CategoriaEntity entity) {
        return List.of();
    }

    @Override
    public List<CategoriaEntity> listAll() {
        return List.of();
    }

    @Override
    public CategoriaEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, CategoriaEntity entity) {

    }
}
