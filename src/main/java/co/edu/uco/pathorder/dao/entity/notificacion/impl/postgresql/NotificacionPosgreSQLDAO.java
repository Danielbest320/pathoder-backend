package co.edu.uco.pathorder.dao.entity.notificacion.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.notificacion.NotificacionDao;
import co.edu.uco.pathorder.entity.NotificacionEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class NotificacionPosgreSQLDAO implements NotificacionDao {

    private Connection conexion;

    public NotificacionPosgreSQLDAO(Connection conexion) {this.conexion = conexion;}


    @Override
    public void create(NotificacionEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<NotificacionEntity> listByFilter(NotificacionEntity entity) {
        return List.of();
    }

    @Override
    public List<NotificacionEntity> listAll() {
        return List.of();
    }

    @Override
    public NotificacionEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, NotificacionEntity entity) {

    }
}
