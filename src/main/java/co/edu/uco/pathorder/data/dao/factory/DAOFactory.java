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




    // --------------<<<<<<<<<<<<<<<<<<  Descomentar y completar cuando se implemente el DAO correspondiente ------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // public abstract AdministradorDao getAdministradorDAO();
    // public abstract CategoriaDao getCategoriaDAO();
    // public abstract ClienteDao getClienteDAO();
    // public abstract DetalleFacturaDao getDetalleFacturaDAO();
    // public abstract EstadoDao getEstadoDAO();
    // public abstract FacturaDao getFacturaDAO();
    // public abstract HistorialPrecioDao getHistorialPrecioDAO();
    // public abstract HorarioLocalDao getHorarioLocalDAO();
    // public abstract IngredienteProductoDao getIngredienteProductoDAO();
    // public abstract InventarioDao getInventarioDAO();
    // public abstract NotificacionDao getNotificacionDAO();
    // public abstract ProductoDao getProductoDAO();
    // public abstract ReservaDao getReservaDAO();
    // public abstract ReservaProductoDao getReservaProductoDAO();
    // public abstract TipoNotificacionDao getTipoNotificacionDAO();
    // public abstract TipoProductoDao getTipoProductoDAO();

    public abstract UsuarioDao getUsuarioDAO();




}
