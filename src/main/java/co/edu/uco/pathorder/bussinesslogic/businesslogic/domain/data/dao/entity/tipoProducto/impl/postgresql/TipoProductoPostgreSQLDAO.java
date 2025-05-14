package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.data.dao.entity.tipoProducto.impl.postgresql;

import co.edu.uco.pathorder.data.dao.entity.tipoProducto.TipoProductoDao;
import co.edu.uco.pathorder.entity.TipoProductoEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class TipoProductoPostgreSQLDAO implements TipoProductoDao {

    private Connection conexion;

    public TipoProductoPostgreSQLDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public void create(TipoProductoEntity entity) {

    }

    @Override
    public List<TipoProductoEntity> listByFilter(TipoProductoEntity entity) {
        return List.of();
    }

    @Override
    public List<TipoProductoEntity> listAll() {
        return List.of();
    }

    @Override
    public TipoProductoEntity listById(UUID uuid) {
        return null;
    }
}
