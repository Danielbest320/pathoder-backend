package co.edu.uco.pathorder.data.dao.factory.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.entity.administrador.AdministradorDao;
import co.edu.uco.pathorder.data.dao.entity.administrador.impl.postgresql.AdministradorPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.categoria.impl.postgresql.CategoriaPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.data.dao.entity.cliente.impl.postgresql.ClientePostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.detallefactura.DetalleFacturaDao;
import co.edu.uco.pathorder.data.dao.entity.detallefactura.impl.postgresql.DetalleFacturaPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.estado.EstadoDao;
import co.edu.uco.pathorder.data.dao.entity.categoria.CategoriaDao;
import co.edu.uco.pathorder.data.dao.entity.estado.impl.postgreSQLDAO.EstadoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.factura.FacturaDao;
import co.edu.uco.pathorder.data.dao.entity.factura.impl.postgresql.FacturaPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.historialPrecio.HistorialPrecioDao;
import co.edu.uco.pathorder.data.dao.entity.historialPrecio.impl.postgresql.HistorialPrecioPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.horarioLocal.HorarioLocalDao;
import co.edu.uco.pathorder.data.dao.entity.horarioLocal.impl.postgresql.HorarioLocalPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.IngredienteProductoDao;
import co.edu.uco.pathorder.data.dao.entity.ingredienteProducto.impl.postgresql.IngredienteProductoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.inventario.InventarioDao;
import co.edu.uco.pathorder.data.dao.entity.inventario.impl.postgresql.InventarioPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.notificacion.NotificacionDao;
import co.edu.uco.pathorder.data.dao.entity.notificacion.impl.postgresql.NotificacionPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.notificacion.impl.postgresql.NotificacionPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.producto.ProductoDao;
import co.edu.uco.pathorder.data.dao.entity.producto.impl.postgresql.ProductoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.reserva.ReservaDao;
import co.edu.uco.pathorder.data.dao.entity.reserva.impl.postgresql.ReservaPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.reservaproducto.ReservaProductoDao;
import co.edu.uco.pathorder.data.dao.entity.reservaproducto.impl.postgresql.ReservaProductoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.tipoProducto.TipoProductoDao;
import co.edu.uco.pathorder.data.dao.entity.tipoProducto.impl.postgresql.TipoProductoPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.tiponotificacion.TipoNotificacionDao;
import co.edu.uco.pathorder.data.dao.entity.tiponotificacion.impl.postgresql.TipoNotificacionPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.entity.usuario.UsuarioDao;
import co.edu.uco.pathorder.data.dao.entity.usuario.impl.postgresql.UsuarioPostgreSQLDAO;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLDAOFactory extends DAOFactory {

    private Connection conexion;
    private boolean transaccionEstaIniciada = false;
    private boolean connexionEstaAbierta = false;

    public PostgreSQLDAOFactory() throws PathOrderException {
        transaccionEstaIniciada = false;
        connexionEstaAbierta = false;
        abrirConexion();
    }



    @Override
    public void abrirConexion() throws PathOrderException {
        var baseDatos = "pathorder_db";
        var servidor = "localhost:5432";

        try {
            conexion=DriverManager.getConnection("jdbc:postgresql://" + servidor + "/" + baseDatos);
            connexionEstaAbierta = true;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de obtener la conexión con la base de datos "
                    + baseDatos + " en el servidor " + servidor + ", para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de obtener la conexión con la fuente de datos";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de obtener la conexión con la base de datos "
                    + baseDatos + " en el servidor " + servidor + ", para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de obtener la conexión con la fuente de datos";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void iniciartransaccion() throws PathOrderException {
        try {
            asegurarConexionAbierta();
            conexion.setAutoCommit(false);
            transaccionEstaIniciada =true;

        } catch (PathOrderException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de iniciar la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de iniciar la transacción con la fuente de datos";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de iniciar la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de iniciar la transacción con la fuente de datos";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void confirmartransaccion() throws PathOrderException {
        try {

            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.commit();
            conexion.setAutoCommit(true);
            transaccionEstaIniciada = false;

        } catch (PathOrderException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de CONFIRMAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de confirmar la transacción con la fuente de datos";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONFIRMAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de confirmar la transacción con la fuente de datos";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void cancelartransaccion() throws PathOrderException {
        try {
            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.rollback();
            conexion.setAutoCommit(true);
            transaccionEstaIniciada = false;

        } catch (PathOrderException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de CANCELAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de cancelar la transacción con la fuente de datos para revertir la operación realizada";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CANCELAR la transacción sobre la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de cancelar la transacción con la fuente de datos para revertir la operación realizada";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void cerrarConexion() throws PathOrderException {
        try {
            asegurarConexionAbierta();
            conexion.close();
            connexionEstaAbierta = false;

        } catch (PathOrderException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException tratando de CERRAR la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema tratando de cerrar la conexión con la fuente de datos luego de realizar la operación";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CERRAR la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de cerrar la conexión con la fuente de datos luego de realizar la operación";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    private void asegurarTransaccionIniciada() throws PathOrderException {
        if (!transaccionEstaIniciada) {
            var mensajeTecnico = "Se presentó una excepción tratando de gestionar(COMMIT,ROLLBACK) la conexión con la base de datos, para más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de gestionar la conexión con la fuente de datos luego de realizar la operación";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico);
        }
    }

    private void asegurarConexionAbierta() throws PathOrderException {
        if (!connexionEstaAbierta) {
            var mensajeTecnico = "Se intentó llevar a cabo una operación que requería una conexión abierta, pero al momento de validarla esta cerrada";
            var mensajeUsuario = "Se presentó una excepción tratando de llevar a cabo operación deseada con la conexión cerrada";

            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico);
        }
    }


    @Override
    public TipoProductoDao getTipoProductoDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new TipoProductoPostgreSQLDAO(conexion);
    }

    @Override
    public ProductoDao getProductoDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new ProductoPostgreSQLDAO(conexion);
    }

    @Override
    public ReservaDao getReservaDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new ReservaPostgreSQLDAO(conexion);
    }

    @Override
    public ReservaProductoDao getReservaProductoDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new ReservaProductoPostgreSQLDAO(conexion);
    }

    @Override
    public NotificacionDao getNotificacionDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new NotificacionPostgreSQLDAO(conexion);
    }

    @Override
    public TipoNotificacionDao getTipoNotificacionDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new TipoNotificacionPostgreSQLDAO(conexion);
    }

    @Override
    public FacturaDao getFacturaDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new FacturaPostgreSQLDAO(conexion);
    }

    @Override
    public DetalleFacturaDao getDetalleFacturaDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new DetalleFacturaPostgreSQLDAO(conexion);
    }

    @Override
    public AdministradorDao getAdministradorDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new AdministradorPostgreSQLDAO(conexion);
    }

    @Override
    public CategoriaDao getCategoriaDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new CategoriaPostgreSQLDAO(conexion);
    }

    @Override
    public HistorialPrecioDao getHistorialPrecioDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new HistorialPrecioPostgreSQLDAO(conexion);
    }

    @Override
    public HorarioLocalDao getHorarioLocalDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new HorarioLocalPostgreSQLDAO(conexion);
    }

    @Override
    public IngredienteProductoDao getIngredienteProductoDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new IngredienteProductoPostgreSQLDAO(conexion);
    }

    @Override
    public InventarioDao getInventarioDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new InventarioPostgreSQLDAO(conexion) {
        };
    }

    @Override
    public ClienteDao getClienteDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new ClientePostgreSQLDAO(conexion);
    }

    @Override
    public EstadoDao getEstadoDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new EstadoPostgreSQLDAO(conexion);
    }

    @Override
    public UsuarioDao getUsuarioDAO() throws PathOrderException {
        asegurarConexionAbierta();
        return new UsuarioPostgreSQLDAO(conexion);
    }

}

