package co.edu.uco.pathorder.data.dao.entity.estado.impl.postgreSQLDAO;

import co.edu.uco.pathorder.data.dao.entity.estado.EstadoDao;
import co.edu.uco.pathorder.entity.EstadoEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class EstadoPostgreSQLDAO implements EstadoDao {


    private Connection conexion;

    public EstadoPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }



    @Override
    public void create(EstadoEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<EstadoEntity> listByFilter(EstadoEntity entity) {
        return List.of();
    }

    @Override
    public List<EstadoEntity> listAll() {
        return List.of();
    }

    @Override
    public EstadoEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, EstadoEntity entity) {

    }
}
