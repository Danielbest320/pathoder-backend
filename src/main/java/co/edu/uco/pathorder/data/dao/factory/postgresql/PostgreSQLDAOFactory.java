package co.edu.uco.pathorder.data.dao.factory.postgresql;

import co.edu.uco.pathorder.data.dao.entity.administrador.AdministradorDao;
import co.edu.uco.pathorder.data.dao.entity.administrador.impl.postgresql.AdministradorPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.categoria.impl.postgresql.CategoriaPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.data.dao.entity.cliente.impl.postgresql.ClientePostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.estado.EstadoDao;
import co.edu.uco.pathorder.data.dao.entity.categoria.CategoriaDao;
import co.edu.uco.pathorder.data.dao.entity.estado.impl.postgreSQLDAO.EstadoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.historialPrecio.HistorialPrecioDao;
import co.edu.uco.pathorder.data.dao.entity.historialPrecio.impl.postgresql.HistorialPrecioPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.horarioLocal.HorarioLocalDao;
import co.edu.uco.pathorder.data.dao.entity.horarioLocal.impl.postgresql.HorarioLocalPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.IngredienteProductoDao;
import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.impl.postgresql.IngredienteProductoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.inventario.InventarioDao;
import co.edu.uco.pathorder.data.dao.entity.inventario.impl.postgresql.InventarioPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.producto.ProductoDao;
import co.edu.uco.pathorder.data.dao.entity.producto.impl.postgresql.ProductoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.reserva.ReservaDao;
import co.edu.uco.pathorder.data.dao.entity.reserva.impl.postgresql.ReservaPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.tipoProducto.TipoProductoDao;
import co.edu.uco.pathorder.data.dao.entity.tipoProducto.impl.postgresql.TipoProductoPostgreSQLDAO;
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
    public TipoProductoDao getTipoProductoDAO() {
        return new TipoProductoPostgreSQLDAO(conexion);
    }

    @Override
    public ProductoDao getProductoDAO() {
        return new ProductoPostgreSQLDAO(conexion);
    }

    @Override
    public ReservaDao getReservaDAO() {
        return new ReservaPostgreSQLDAO(conexion);
    }

    @Override
    public AdministradorDao getAdministradorDAO() {
        return new AdministradorPostgreSQLDAO(conexion);
    }

    @Override
    public CategoriaDao getCategoriaDAO() {
        return new CategoriaPostgreSQLDAO(conexion);
    }

    @Override
    public HistorialPrecioDao getHistorialPrecioDAO() {
        return new HistorialPrecioPostgreSQLDAO(conexion);
    }

    @Override
    public HorarioLocalDao getHorarioLocalDAO() {
        return new HorarioLocalPostgreSQLDAO(conexion);
    }

    @Override
    public IngredienteProductoDao getIngredienteProductoDAO() {
        return new IngredienteProductoPostgreSQLDAO(conexion);
    }

    @Override
    public InventarioDao getInventarioDAO() {
        return new InventarioPostgreSQLDAO(conexion) {
        };
    }

    @Override
    public ClienteDao getClienteDAO() {
        return new ClientePostgreSQLDAO(conexion);
    }

    @Override
    public EstadoDao getEstadoDAO() {
        return new EstadoPostgreSQLDAO(conexion);
    }

    @Override
    public UsuarioDao getUsuarioDAO() {
        return new UsuarioPostgreSQLDAO(conexion);
    }

}
