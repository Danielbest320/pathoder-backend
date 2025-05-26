package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.reservaproducto.dto.ReservaProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.ReservaProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.ReservaProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.ReservaProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.ReservaProductoDTO;

import java.util.List;
import java.util.UUID;

public class ReservaProductoFacadeImpl implements ReservaProductoFacade {

    private final DAOFactory daoFactory;
    private final ReservaProductoBusinessLogic reservaProductoBusinessLogic;

    public ReservaProductoFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        reservaProductoBusinessLogic = new ReservaProductoBusinessLogicImpl(daoFactory);
    }

    @Override
    public void crearReservaProducto(ReservaProductoDTO reservaProducto) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            ReservaProductoDomain domain = ReservaProductoDTOAssembler.getInstance().toDomain(reservaProducto);
            reservaProductoBusinessLogic.crearReservaProducto(domain);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CREAR una reserva de producto.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de crear una reserva de producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void eliminarReservaProducto(UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            reservaProductoBusinessLogic.eliminarReservaProducto(id);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ELIMINAR una reserva de producto.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de eliminar una reserva de producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void modificarReservaProducto(ReservaProductoDTO reservaProducto, UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            ReservaProductoDomain domain = ReservaProductoDTOAssembler.getInstance().toDomain(reservaProducto);
            reservaProductoBusinessLogic.modificarReservaProducto(domain, id);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de MODIFICAR una reserva de un producto.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de modificar una reserva de un producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<ReservaProductoDTO> consultarReservaProducto(ReservaProductoDTO filtro) throws PathOrderException {
        try {
            ReservaProductoDomain domainFilter = ReservaProductoDTOAssembler.getInstance().toDomain(filtro);
            var resultado = reservaProductoBusinessLogic.consultarReservaProducto(domainFilter);
            return ReservaProductoDTOAssembler.getInstance().toDTOs(resultado);
        } catch (PathOrderException e) {
            throw e;
        } catch (Exception e) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR reservas de producto.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar reservas de producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}