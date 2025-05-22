package co.edu.uco.pathorder.dao.entity.reservaproducto.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.reservaproducto.ReservaProductoDao;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ReservaProductoPostgreSQLDAO implements ReservaProductoDao {

    private Connection conexion;

    public ReservaProductoPostgreSQLDAO(Connection conexion) {this.conexion = conexion;}



    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<ReservaProductoEntity> listByFilter(ReservaProductoEntity entity) {
        return List.of();
    }

    @Override
    public List<ReservaProductoEntity> listAll() {
        return List.of();
    }

    @Override
    public ReservaProductoEntity listById(UUID uuid) {
        return null;
    }


    @Override
    public void create(ReservaProductoEntity entity) {

    }

    @Override
    public void update(UUID uuid, ReservaProductoEntity reservaProductoEntity) {

    }
}
