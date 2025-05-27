package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.inventario.dto.InventarioDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.InventarioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.InventarioDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.InventarioBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.InventarioFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.InventarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InventarioFacadeImpl implements InventarioFacade {

    private final DAOFactory daoFactory;
    private final InventarioBusinessLogic inventarioBusinessLogic;

    public InventarioFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        inventarioBusinessLogic = new InventarioBusinessLogicImpl(daoFactory);
    }

    @Override
    public void crearInventario(InventarioDTO inventario) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            InventarioDomain domain = InventarioDTOAssembler.getInstance().toDomain(inventario);
            inventarioBusinessLogic.crearInventario(domain);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Error inesperado al crear el inventario.";
            var mensajeTecnico = "Excepción no controlada al crear inventario.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void actualizarInventario(InventarioDTO inventario, UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            InventarioDomain domain = InventarioDTOAssembler.getInstance().toDomain(inventario);
            inventarioBusinessLogic.actualizarInventario(domain, id);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Error inesperado al actualizar el inventario.";
            var mensajeTecnico = "Excepción no controlada al actualizar inventario.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void actualizarInventarioMomentoReserva(InventarioDTO inventario, UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            InventarioDomain domain = InventarioDTOAssembler.getInstance().toDomain(inventario);
            inventarioBusinessLogic.actualizarInventarioMomentoReserva(domain, id);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Error inesperado al actualizar el inventario en el momento de la reserva.";
            var mensajeTecnico = "Excepción no controlada en actualizarInventarioMomentoReserva.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void eliminarInventario(UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            inventarioBusinessLogic.eliminarInventario(id);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Error inesperado al eliminar el inventario.";
            var mensajeTecnico = "Excepción no controlada al eliminar inventario.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<InventarioDTO> consultarInventario(InventarioDTO filtro) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            InventarioDomain domain = InventarioDTOAssembler.getInstance().toDomain(filtro);
            List<InventarioDomain> resultado = inventarioBusinessLogic.consultarInventario(domain);

            daoFactory.confirmartransaccion();
            return InventarioDTOAssembler.getInstance().toDTOs(resultado);
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Error inesperado al consultar inventarios.";
            var mensajeTecnico = "Excepción no controlada al consultar inventarios.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
