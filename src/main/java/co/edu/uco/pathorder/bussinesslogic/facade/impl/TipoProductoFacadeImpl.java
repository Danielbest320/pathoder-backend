package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.tipoProducto.dto.TipoProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoProductoDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.TipoProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.TipoProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.TipoProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TipoProductoFacadeImpl implements TipoProductoFacade {

    private DAOFactory daoFactory;
    private TipoProductoBusinessLogic tipoProductoBusinessLogic;


    public TipoProductoFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        tipoProductoBusinessLogic = new TipoProductoBusinessLogicImpl(daoFactory);

    }

    @Override
        public void crearTipoProductoPredeterminado(TipoProductoDTO tipoProducto) throws PathOrderException{
        try {
            daoFactory.iniciartransaccion();

            var tipoProductoDomain = TipoProductoDTOAssembler.getInstance().toDomain(tipoProducto);
            tipoProductoBusinessLogic.crearTipoProductoPredeterminado(tipoProductoDomain);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo tipo de producto...";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de registrar el nuevo tipo de producto. Para más detalles revise el log de errores...";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }

    }

    @Override
    public List<TipoProductoDTO> consultarTipoProductos(TipoProductoDTO filtro) throws PathOrderException{
        try {

            var filtroDomain = TipoProductoDTOAssembler.getInstance().toDomain(filtro);
            List<TipoProductoDomain> resultado = tipoProductoBusinessLogic.consultarTipoProductos(filtroDomain);
            return TipoProductoDTOAssembler.getInstance().toDTOs(resultado);

        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar los tipos de productos...";
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo Exception tratando de consultar los tipos de productos. Para más detalles revise el log de errores...";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
