package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.ingredienteProducto.dto.IngredienteProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.IngredienteProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.IngredienteProductoDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.IngredienteProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.IngredienteProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.IngredienteProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IngredienteProductoFacadeImpl implements IngredienteProductoFacade {

    private DAOFactory daoFactory;
    private IngredienteProductoBusinessLogic ingredienteProductoBusinessLogic;


    public IngredienteProductoFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        ingredienteProductoBusinessLogic = new IngredienteProductoBusinessLogicImpl(daoFactory);

    }

    @Override
    public void asignarIngredienteProducto(IngredienteProductoDTO ingredienteProducto) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            IngredienteProductoDomain domain = IngredienteProductoDTOAssembler.getInstance().toDomain(ingredienteProducto);
            ingredienteProductoBusinessLogic.asignarIngredienteProducto(domain);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un problema inesperado al asignar el ingrediente al producto.";
            var mensajeTecnico = "Excepción no controlada al asignar ingrediente-producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void modificarCantidadIngrediente(IngredienteProductoDTO ingredienteProducto, UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            IngredienteProductoDomain domain = IngredienteProductoDTOAssembler.getInstance().toDomain(ingredienteProducto);
            ingredienteProductoBusinessLogic.modificarCantidadIngrediente(domain, id);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un problema inesperado al modificar la cantidad del ingrediente.";
            var mensajeTecnico = "Excepción no controlada al modificar cantidad de ingrediente-producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void eliminarIngredienteProducto(UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            ingredienteProductoBusinessLogic.eliminarIngredienteProducto(id);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un problema inesperado al eliminar el ingrediente del producto.";
            var mensajeTecnico = "Excepción no controlada al eliminar ingrediente-producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<IngredienteProductoDTO> consultarIngredientesProductos(IngredienteProductoDTO filtro) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            IngredienteProductoDomain domain = IngredienteProductoDTOAssembler.getInstance().toDomain(filtro);
            List<IngredienteProductoDomain> resultado = ingredienteProductoBusinessLogic.consultarIngredientesProductos(domain);

            daoFactory.confirmartransaccion();
            return IngredienteProductoDTOAssembler.getInstance().toDTOs(resultado);
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un problema inesperado al consultar los ingredientes del producto.";
            var mensajeTecnico = "Excepción no controlada al consultar ingrediente-producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
