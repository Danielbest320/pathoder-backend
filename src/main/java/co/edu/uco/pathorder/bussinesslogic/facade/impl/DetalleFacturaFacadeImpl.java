package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.detallefactura.dto.DetalleFacturaDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.DetalleFacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.DetalleFacturaDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.DetalleFacturaBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.DetalleFacturaFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.DetalleFacturaDTO;

import java.util.List;
import java.util.UUID;

public class DetalleFacturaFacadeImpl implements DetalleFacturaFacade {

    private final DAOFactory daoFactory;
    private final DetalleFacturaBusinessLogic detalleFacturaBusinessLogic;

    public DetalleFacturaFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        detalleFacturaBusinessLogic = new DetalleFacturaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void crearDetalleFactura(DetalleFacturaDTO detalleFactura) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            DetalleFacturaDomain domain = DetalleFacturaDTOAssembler.getInstance().toDomain(detalleFactura);
            detalleFacturaBusinessLogic.crearDetalleFactura(domain);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CREAR un detalle de factura.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de crear un detalle de factura.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void modificarDetalleFactura(DetalleFacturaDTO detalleFactura, UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            DetalleFacturaDomain domain = DetalleFacturaDTOAssembler.getInstance().toDomain(detalleFactura);
            detalleFacturaBusinessLogic.modificarDetalleFactura(domain, id);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de MODIFICAR un detalle de factura.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de modificar un detalle de factura.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void eliminarDetalleFactura(UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            detalleFacturaBusinessLogic.eliminarDetalleFactura(id);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ELIMINAR un detalle de factura.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de eliminar un detalle de factura.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<DetalleFacturaDTO> consultarDetalleFactura(DetalleFacturaDTO filtro) throws PathOrderException {
        try {
            DetalleFacturaDomain domainFilter = DetalleFacturaDTOAssembler.getInstance().toDomain(filtro);
            var detalleFacturaDomainResultado = detalleFacturaBusinessLogic.consultarDetalleFactura(domainFilter);
            return DetalleFacturaDTOAssembler.getInstance().toDTOs(detalleFacturaDomainResultado);
        } catch (PathOrderException e) {
            throw e;
        } catch (Exception e) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR detalles de factura con filtro.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar detalles de factura.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}