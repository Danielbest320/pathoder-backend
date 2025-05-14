package co.edu.uco.pathorder.data.dao.factory.postgresql;

import co.edu.uco.pathorder.data.dao.entity.administrador.AdministradorDao;
import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.data.dao.entity.cliente.impl.postgresql.ClientePostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.estado.EstadoDao;
import co.edu.uco.pathorder.data.dao.entity.usuario.UsuarioDao;
import co.edu.uco.pathorder.data.dao.entity.usuario.impl.postgresql.UsuarioPostgreSQLDAO;
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
    public AdministradorDao getAdministradorDAO() {
        return null;
    }

    @Override
    public ClienteDao getClienteDAO() {
        return new ClientePostgreSQLDAO(conexion);
    }

    @Override
    public EstadoDao getEstadoDAO() {
        return null;
    }

    @Override
    public UsuarioDao getUsuarioDAO() {
        return new UsuarioPostgreSQLDAO(conexion);
    }

}
