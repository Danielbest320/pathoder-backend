package co.edu.uco.pathorder.data.dao.entity.reservaproducto.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.reservaproducto.ReservaProductoDao;
import co.edu.uco.pathorder.entity.UsuarioEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class ReservaProductoPostgreSQLDAO implements ReservaProductoDao {

    private Connection conexion;

    public ReservaProductoPostgreSQLDAO(Connection conexion) {this.conexion = conexion;}

    @Override
    public void create(UsuarioEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<UsuarioEntity> listByFilter(UsuarioEntity entity) {
        return List.of();
    }

    @Override
    public List<UsuarioEntity> listAll() {
        return List.of();
    }

    @Override
    public UsuarioEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, UsuarioEntity entity) {

    }
}
