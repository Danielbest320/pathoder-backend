package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.ProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.ProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.ProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductoFacadeImpl implements ProductoFacade {

    private final DAOFactory daoFactory;
    private final ProductoBusinessLogic productoBusinessLogic;

    public ProductoFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        productoBusinessLogic = new ProductoBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarProducto(ProductoDTO producto) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();
            ProductoDomain domain = ProductoDTOAssembler.getInstance().toDomain(producto);
            productoBusinessLogic.registrarProducto(domain);
            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Ocurrió un problema al registrar el producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar el producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void modificarProducto(UUID id, ProductoDTO producto) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();
            ProductoDomain domain = ProductoDTOAssembler.getInstance().toDomain(producto);
            productoBusinessLogic.modificarProducto(id, domain);
            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Ocurrió un problema al modificar el producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al modificar el producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void eliminarProducto(UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();
            productoBusinessLogic.eliminarProducto(id);
            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Ocurrió un problema al eliminar el producto.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar el producto.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<ProductoDTO> consultarProducto(ProductoDTO filtro) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();
            ProductoDomain domain = ProductoDTOAssembler.getInstance().toDomain(filtro);
            var resultado = productoBusinessLogic.consultarProducto(domain);
            daoFactory.confirmartransaccion();
            return ProductoDTOAssembler.getInstance().toDTOs(resultado);
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Ocurrió un problema al consultar productos.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar productos.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<ProductoDTO> consultarProductoDisponible(ProductoDTO filtro) throws PathOrderException {
        try {
            ProductoDomain domain = ProductoDTOAssembler.getInstance().toDomain(filtro);
            var resultado = productoBusinessLogic.consultarProductoDisponible(domain);
            return ProductoDTOAssembler.getInstance().toDTOs(resultado);
        } catch (final PathOrderException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Ocurrió un problema al consultar productos disponibles.";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar productos disponibles.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
