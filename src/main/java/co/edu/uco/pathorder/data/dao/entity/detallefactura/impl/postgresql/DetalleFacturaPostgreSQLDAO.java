package co.edu.uco.pathorder.data.dao.entity.detallefactura.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.detallefactura.DetalleFacturaDao;
import co.edu.uco.pathorder.entity.UsuarioEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class DetalleFacturaPostgreSQLDAO implements DetalleFacturaDao {

    private Connection connection;

    public DetalleFacturaPostgreSQLDAO(Connection connection){
        this.connection = connection;
    }

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
