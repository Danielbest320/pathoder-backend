package co.edu.uco.pathorder.dao.entity.detallefactura.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.detallefactura.DetalleFacturaDao;
import co.edu.uco.pathorder.entity.DetalleFacturaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class DetalleFacturaPostgreSQLDAO implements DetalleFacturaDao {

    private Connection connection;

    public DetalleFacturaPostgreSQLDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(DetalleFacturaEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<DetalleFacturaEntity> listByFilter(DetalleFacturaEntity entity) {
        return List.of();
    }

    @Override
    public List<DetalleFacturaEntity> listAll() {
        return List.of();
    }

    @Override
    public DetalleFacturaEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, DetalleFacturaEntity entity) {

    }
}
