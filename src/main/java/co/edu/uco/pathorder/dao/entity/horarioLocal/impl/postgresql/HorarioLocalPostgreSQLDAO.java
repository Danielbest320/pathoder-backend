package co.edu.uco.pathorder.dao.entity.horarioLocal.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.horarioLocal.HorarioLocalDao;
import co.edu.uco.pathorder.entity.HorarioLocalEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class HorarioLocalPostgreSQLDAO implements HorarioLocalDao {

    private Connection conexion;

    public HorarioLocalPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(HorarioLocalEntity entity) {

    }

    @Override
    public List<HorarioLocalEntity> listByFilter(HorarioLocalEntity entity) {
        return List.of();
    }

    @Override
    public List<HorarioLocalEntity> listAll() {
        return List.of();
    }

    @Override
    public HorarioLocalEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, HorarioLocalEntity entity) {

    }
}
