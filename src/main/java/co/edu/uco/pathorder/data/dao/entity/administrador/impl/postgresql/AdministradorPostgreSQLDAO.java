package co.edu.uco.pathorder.data.dao.entity.administrador.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.administrador.AdministradorDao;
import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.entity.AdministradorEntity;
import co.edu.uco.pathorder.entity.ClienteEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class AdministradorPostgreSQLDAO implements AdministradorDao {

    private Connection conexion;

    public AdministradorPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }


    @Override
    public void create(AdministradorEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<AdministradorEntity> listByFilter(AdministradorEntity entity) {
        return null;
    }

    @Override
    public List<AdministradorEntity> listAll() {
        return null;
    }

    @Override
    public AdministradorEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, AdministradorEntity entity) {

    }
}
