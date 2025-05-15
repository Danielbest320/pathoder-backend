package co.edu.uco.pathorder.data.dao.entity.tiponotificacion.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.tiponotificacion.TipoNotificacionDao;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;
import co.edu.uco.pathorder.entity.UsuarioEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class TipoNotificacionPostgreSQLDAO implements TipoNotificacionDao {

    private Connection connection;

    public TipoNotificacionPostgreSQLDAO(Connection connection){this.connection=connection;}

    @Override
    public void create(TipoNotificacionEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<TipoNotificacionEntity> listByFilter(TipoNotificacionEntity entity) {
        return List.of();
    }

    @Override
    public List<TipoNotificacionEntity> listAll() {
        return List.of();
    }

    @Override
    public TipoNotificacionEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, TipoNotificacionEntity entity) {

    }
}
