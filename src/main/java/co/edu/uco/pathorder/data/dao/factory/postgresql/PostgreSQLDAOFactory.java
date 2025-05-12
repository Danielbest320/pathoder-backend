package co.edu.uco.pathorder.data.dao.factory.postgresql;

import co.edu.uco.pathorder.data.dao.entity.usuario.UsuarioDao;
import co.edu.uco.pathorder.data.dao.entity.usuario.impl.azuresql.UsuarioPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;

import java.sql.Connection;

public class PostgreSQLDAOFactory extends DAOFactory {

    private Connection conexion;

    public PostgreSQLDAOFactory() {
        conexion = null;
    }



    @Override
    public void abrirConexion() {
        conexion =null;

    }

    @Override
    public void iniciartransaccion() {

    }

    @Override
    public void confirmartransaccion() {

    }

    @Override
    public void cancelartransaccion() {

    }

    @Override
    public void cerrarConexion() {

    }

    @Override
    public UsuarioDao getUsuarioDAO() {
        return new UsuarioPostgreSQLDAO(conexion);
    }

}
