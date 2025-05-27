package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.categoria.dto.CategoriaDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.CategoriaBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.CategoriaFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CategoriaFacadeImpl implements CategoriaFacade {


    private DAOFactory daoFactory;
    private CategoriaBusinessLogic categoriaBusinessLogic;

    public CategoriaFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        categoriaBusinessLogic = new CategoriaBusinessLogicImpl(daoFactory);
    }


    @Override
    public void crearNuevaCategoria(CategoriaDTO categoria) throws PathOrderException{
        try {
            daoFactory.iniciartransaccion();

            var categoriaDomain = CategoriaDTOAssembler.getInstance().toDomain(categoria);
            categoriaBusinessLogic.crearNuevaCategoria(categoriaDomain);

            daoFactory.confirmartransaccion();

        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva categoría...";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar la nueva categoría. Para más detalles revise el log de errores...";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void modificarCategoriaExistente(UUID id, CategoriaDTO categoria)throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            var categoriaDomain = CategoriaDTOAssembler.getInstance().toDomain(categoria);
            categoriaBusinessLogic.modificarCategoriaExistente(id, categoriaDomain);

            daoFactory.confirmartransaccion();

        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de modificar la información de una categoría...";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de modificar la categoría. Para más detalles revise el log de errores...";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }

    }

    @Override
    public void eliminarUnaCategoria(UUID id) throws PathOrderException{
        try {
            daoFactory.iniciartransaccion();

            categoriaBusinessLogic.eliminarUnaCategoria(id);

            daoFactory.confirmartransaccion();

        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de eliminar la categoría...";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de eliminar la categoría. Para más detalles revise el log de errores...";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();

        }

    }

    @Override
    public List<CategoriaDTO> consultarCategoriaDisponibles(CategoriaDTO filtro) throws PathOrderException {
        try {
            //Para administrador
            daoFactory.iniciartransaccion();
            var filtroDomain = CategoriaDTOAssembler.getInstance().toDomain(filtro);

            var dominios  = categoriaBusinessLogic.consultarCategoriaDisponibles(filtroDomain);

            var dominiosResultado = CategoriaDTOAssembler.getInstance().toDTOs(dominios);
            daoFactory.confirmartransaccion();

            return dominiosResultado;

        } catch (final PathOrderException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar las categorías disponibles...";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar las categorías disponibles. Para más detalles revise el log de errores...";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<CategoriaDTO> consultarCategoriaExistentes(CategoriaDTO filtro) throws PathOrderException {
        try {
            //Para cliente
            var filtroDomain = CategoriaDTOAssembler.getInstance().toDomain(filtro);
            List<CategoriaDomain> resultado = categoriaBusinessLogic.consultarCategoriaExistentes(filtroDomain);
            return CategoriaDTOAssembler.getInstance().toDTOs(resultado);
        } catch (final PathOrderException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar las categorías existentes...";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar las categorías existentes. Para más detalles revise el log de errores...";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
