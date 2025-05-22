package co.edu.uco.pathorder.dao.entity.historialPrecio.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.historialPrecio.HistorialPrecioDao;
import co.edu.uco.pathorder.entity.HistorialPrecioEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class HistorialPrecioPostgreSQLDAO implements HistorialPrecioDao {

    private Connection conexion;

    public HistorialPrecioPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(HistorialPrecioEntity entity) {

    }

    @Override
    public List<HistorialPrecioEntity> listByFilter(HistorialPrecioEntity entity) {
        return List.of();
    }

    @Override
    public List<HistorialPrecioEntity> listAll() {
        return List.of();
    }

    @Override
    public HistorialPrecioEntity listById(UUID uuid) {
        return null;
    }
}
