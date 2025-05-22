package co.edu.uco.pathorder.dao.entity.factura.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.factura.FacturaDao;
import co.edu.uco.pathorder.entity.FacturaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class FacturaPosgreSQLDAO implements FacturaDao {

    private Connection conexion;

    public FacturaPosgreSQLDAO(Connection conexion) {this.conexion = conexion;}

    @Override
    public void create(FacturaEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<FacturaEntity> listByFilter(FacturaEntity entity) {
        return List.of();
    }

    @Override
    public List<FacturaEntity> listAll() {
        return List.of();
    }

    @Override
    public FacturaEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, FacturaEntity entity) {

    }
}
