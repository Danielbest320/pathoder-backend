package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.historialPrecio.dto.HistorialPrecioDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.HistorialPrecioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HistorialPrecioDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.HistorialPrecioBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.HistorialPrecioFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.HistorialPrecioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialPrecioFacadeImpl implements HistorialPrecioFacade {

    private final DAOFactory daoFactory;
    private final HistorialPrecioBusinessLogic historialPrecioBusinessLogic;

    public HistorialPrecioFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        historialPrecioBusinessLogic = new HistorialPrecioBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoPrecioHistorial(HistorialPrecioDTO historialPrecio) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            HistorialPrecioDomain domain = HistorialPrecioDTOAssembler.getInstance().toDomain(historialPrecio);
            historialPrecioBusinessLogic.registrarNuevoPrecioHistorial(domain);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un error inesperado al registrar el nuevo historial de precio.";
            var mensajeTecnico = "Excepción no controlada al intentar registrar historial de precio.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<HistorialPrecioDTO> consultarHistorialPrecioProducto(HistorialPrecioDTO filtro) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            HistorialPrecioDomain domain = HistorialPrecioDTOAssembler.getInstance().toDomain(filtro);
            var resultado = historialPrecioBusinessLogic.consultarHistorialPrecioProducto(domain);

            daoFactory.confirmartransaccion();
            return HistorialPrecioDTOAssembler.getInstance().toDTOs(resultado);
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un error inesperado al consultar el historial de precios.";
            var mensajeTecnico = "Excepción no controlada al intentar consultar historial de precio.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
