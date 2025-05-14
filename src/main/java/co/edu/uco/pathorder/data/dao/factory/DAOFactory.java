package co.edu.uco.pathorder.data.dao.factory;

import co.edu.uco.pathorder.data.dao.entity.administrador.AdministradorDao;
import co.edu.uco.pathorder.data.dao.entity.administrador.impl.postgresql.AdministradorPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.data.dao.entity.estado.EstadoDao;
import co.edu.uco.pathorder.data.dao.entity.categoria.CategoriaDao;
import co.edu.uco.pathorder.data.dao.entity.historialPrecio.HistorialPrecioDao;
import co.edu.uco.pathorder.data.dao.entity.horarioLocal.HorarioLocalDao;
import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.IngredienteProductoDao;
import co.edu.uco.pathorder.data.dao.entity.inventario.InventarioDao;
import co.edu.uco.pathorder.data.dao.entity.producto.ProductoDao;
import co.edu.uco.pathorder.data.dao.entity.tipoProducto.TipoProductoDao;
import co.edu.uco.pathorder.data.dao.entity.usuario.UsuarioDao;
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


    public abstract TipoProductoDao getTipoProductoDAO();

    public abstract ProductoDao getProductoDAO();





    public abstract UsuarioDao getUsuarioDAO();
    public abstract EstadoDao getEstadoDAO();
    public abstract ClienteDao getClienteDAO();
    public abstract AdministradorDao getAdministradorDAO();

    public abstract CategoriaDao getCategoriaDAO();

    public abstract HistorialPrecioDao getHistorialPrecioDAO();

    public abstract HorarioLocalDao getHorarioLocalDAO();

    public abstract IngredienteProductoDao getIngredienteProductoDAO();

    public abstract InventarioDao getInventarioDAO();
}
