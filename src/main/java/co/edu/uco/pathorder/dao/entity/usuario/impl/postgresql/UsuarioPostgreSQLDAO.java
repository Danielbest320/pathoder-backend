package co.edu.uco.pathorder.dao.entity.usuario.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.usuario.UsuarioDao;
import co.edu.uco.pathorder.entity.UsuarioEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class UsuarioPostgreSQLDAO implements UsuarioDao {

    private Connection conexion;

    public UsuarioPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(UsuarioEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<UsuarioEntity> listByFilter(UsuarioEntity entity) {
        return null;
    }

    @Override
    public List<UsuarioEntity> listAll() {
        return null;
    }

    @Override
    public UsuarioEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, UsuarioEntity entity) {

    }
}
