package co.edu.uco.pathorder.data.dao.entity.administrador.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.entity.ClienteEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class AdministradorPostgreSQLDAO implements ClienteDao {

    private Connection conexion;

    public AdministradorPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }



    @Override
    public void create(ClienteEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<ClienteEntity> listByFilter(ClienteEntity entity) {
        return List.of();
    }

    @Override
    public List<ClienteEntity> listAll() {
        return List.of();
    }

    @Override
    public ClienteEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, ClienteEntity entity) {

    }
}
