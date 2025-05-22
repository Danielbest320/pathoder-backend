package co.edu.uco.pathorder.dao.entity.reserva.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.reserva.ReservaDao;
import co.edu.uco.pathorder.entity.ReservaEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ReservaPostgreSQLDAO implements ReservaDao {

    private Connection conexion;

    public ReservaPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }



    @Override
    public void create(ReservaEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<ReservaEntity> listByFilter(ReservaEntity entity) {
        return null;
    }

    @Override
    public List<ReservaEntity> listAll() {
        return null;
    }

    @Override
    public ReservaEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, ReservaEntity entity) {

    }
}
