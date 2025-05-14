package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.data.dao.entity.producto.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.producto.ProductoDao;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ProductoPostgreSQLDAO implements ProductoDao {

    private Connection conexion;

    public ProductoPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(ProductoEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<ProductoEntity> listByFilter(ProductoEntity entity) {
        return List.of();
    }

    @Override
    public List<ProductoEntity> listAll() {
        return List.of();
    }

    @Override
    public ProductoEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, ProductoEntity entity) {

    }
}
