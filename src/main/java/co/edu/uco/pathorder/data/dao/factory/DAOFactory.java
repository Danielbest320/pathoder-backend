package co.edu.uco.pathorder.data.dao.factory;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.entity.administrador.AdministradorDao;
import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.data.dao.entity.detallefactura.DetalleFacturaDao;
import co.edu.uco.pathorder.data.dao.entity.estado.EstadoDao;
import co.edu.uco.pathorder.data.dao.entity.categoria.CategoriaDao;
import co.edu.uco.pathorder.data.dao.entity.factura.FacturaDao;
import co.edu.uco.pathorder.data.dao.entity.historialPrecio.HistorialPrecioDao;
import co.edu.uco.pathorder.data.dao.entity.horarioLocal.HorarioLocalDao;
import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.IngredienteProductoDao;
import co.edu.uco.pathorder.data.dao.entity.inventario.InventarioDao;
import co.edu.uco.pathorder.data.dao.entity.notificacion.NotificacionDao;
import co.edu.uco.pathorder.data.dao.entity.producto.ProductoDao;
import co.edu.uco.pathorder.data.dao.entity.reserva.ReservaDao;
import co.edu.uco.pathorder.data.dao.entity.reservaproducto.ReservaProductoDao;
import co.edu.uco.pathorder.data.dao.entity.tipoProducto.TipoProductoDao;
import co.edu.uco.pathorder.data.dao.entity.tiponotificacion.TipoNotificacionDao;
import co.edu.uco.pathorder.data.dao.entity.usuario.UsuarioDao;
import co.edu.uco.pathorder.data.dao.factory.postgresql.PostgreSQLDAOFactory;

public abstract class  DAOFactory{


    public static DAOFactory getFactory(Factory factory) throws PathOrderException {

        switch (factory){
            case POSTGRES_SQL: {
                return new PostgreSQLDAOFactory();
            }
            default:
                var mensajeUsuario = "Se ha presentado un problema tratando de obtener la infomacion de la fuente de datos ";
                var mensajeTecnico = "se solicito la factoria"+ factory+"pero esta no esta implementada";
                throw DataPathOrderException.reportar(mensajeUsuario,mensajeTecnico);
        }
    }




    public abstract void abrirConexion() throws PathOrderException;

    public abstract void iniciartransaccion()  throws PathOrderException;

    public abstract void confirmartransaccion() throws PathOrderException;

    public abstract void cancelartransaccion() throws PathOrderException;

    public abstract void cerrarConexion() throws PathOrderException;




    // --------------<<<<<<<<<<<<<<<<<<  Descomentar y completar cuando se implemente el DAO correspondiente ------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // public abstract AdministradorDao getAdministradorDAO();
    // public abstract CategoriaDao getCategoriaDAO();
    // public abstract ClienteDao getClienteDAO();
    //
    // public abstract EstadoDao getEstadoDAO();
    //
    // public abstract HistorialPrecioDao getHistorialPrecioDAO();
    // public abstract HorarioLocalDao getHorarioLocalDAO();
    // public abstract IngredienteProductoDao getIngredienteProductoDAO();
    // public abstract InventarioDao getInventarioDAO();
    //
    // public abstract ProductoDao getProductoDAO();
    // public abstract ReservaDao getReservaDAO();
    //
    //


    public abstract TipoProductoDao getTipoProductoDAO() throws PathOrderException;

    public abstract ProductoDao getProductoDAO() throws PathOrderException;

    public abstract ReservaDao getReservaDAO() throws PathOrderException;




    public abstract ReservaProductoDao getReservaProductoDAO() throws PathOrderException;

    public abstract NotificacionDao getNotificacionDAO() throws PathOrderException;

    public abstract TipoNotificacionDao getTipoNotificacionDAO() throws PathOrderException;

    public abstract FacturaDao getFacturaDAO() throws PathOrderException;

    public abstract DetalleFacturaDao getDetalleFacturaDAO() throws PathOrderException;

    public abstract UsuarioDao getUsuarioDAO() throws PathOrderException;
    public abstract EstadoDao getEstadoDAO() throws PathOrderException;
    public abstract ClienteDao getClienteDAO() throws PathOrderException;
    public abstract AdministradorDao getAdministradorDAO() throws PathOrderException;

    public abstract CategoriaDao getCategoriaDAO() throws PathOrderException;

    public abstract HistorialPrecioDao getHistorialPrecioDAO() throws PathOrderException;

    public abstract HorarioLocalDao getHorarioLocalDAO() throws PathOrderException;

    public abstract IngredienteProductoDao getIngredienteProductoDAO() throws PathOrderException;

    public abstract InventarioDao getInventarioDAO() throws PathOrderException;
}
