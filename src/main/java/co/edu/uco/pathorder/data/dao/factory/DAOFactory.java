package co.edu.uco.pathorder.data.dao.factory;

import co.edu.uco.pathorder.data.dao.entity.usuario.UsuarioDao;
import co.edu.uco.pathorder.data.dao.entity.usuario.impl.azuresql.UsuarioPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.factory.postgresql.PostgreSQLDAOFactory;

public abstract class  DAOFactory{


    public static DAOFactory getFactory(Factory factory){

        switch (factory){
            case POSTGRES_SQL: {
                return new PostgreSQLDAOFactory();
            }
            default:
                throw new IllegalArgumentException("Unknown factory" + factory);
        }
    }




    public abstract void abrirConexion();

    public abstract void iniciartransaccion();

    public abstract void confirmartransaccion();

    public abstract void cancelartransaccion();

    public abstract void cerrarConexion();


    public abstract UsuarioDao getUsuarioDAO();




}
