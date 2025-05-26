package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.factura.dto.FacturaDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.FacturaBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.FacturaFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.FacturaDTO;

import java.util.List;
import java.util.UUID;

public class FacturaFacadeImpl implements FacturaFacade {

    private final DAOFactory daoFactory;
    private final FacturaBusinessLogic facturaBusinessLogic;

    public FacturaFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        facturaBusinessLogic = new FacturaBusinessLogicImpl(daoFactory);
    }

    @Override
    public void generarFactura(FacturaDTO factura) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            FacturaDomain domain = FacturaDTOAssembler.getInstance().toDomain(factura);
            facturaBusinessLogic.generarFactura(domain);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de GENERAR una factura.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de generar una factura.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<FacturaDTO> consultarFactura(FacturaDTO filtro) throws PathOrderException {
        try {
            FacturaDomain domainFilter = FacturaDTOAssembler.getInstance().toDomain(filtro);
            var facturaDomainResultado = facturaBusinessLogic.consultarFactura(domainFilter);
            return FacturaDTOAssembler.getInstance().toDTOs(facturaDomainResultado);
        } catch (PathOrderException e) {
            throw e;
        } catch (Exception e) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR facturas.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar facturas.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<FacturaDTO> consultarFacturaCliente(FacturaDTO filtro) throws PathOrderException {
        try {
            FacturaDomain domainFilter = FacturaDTOAssembler.getInstance().toDomain(filtro);
            var facturaDomainResultado = facturaBusinessLogic.consultarFacturaCliente(domainFilter);
            return FacturaDTOAssembler.getInstance().toDTOs(facturaDomainResultado);
        } catch (PathOrderException e) {
            throw e;
        } catch (Exception e) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de CONSULTAR facturas de cliente.";
            var mensajeUsuario = "Se ha producido un problema inesperado al consultar facturas de cliente.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void anularFactura(UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            facturaBusinessLogic.anularFactura(id);

            daoFactory.confirmartransaccion();
        } catch (PathOrderException e) {
            daoFactory.cancelartransaccion();
            throw e;
        } catch (Exception e) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ANULAR una factura.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de anular una factura.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, e);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}