package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.factura.entity.FacturaEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.FacturaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.FacturaEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class FacturaBusinessLogicImpl implements FacturaBusinessLogic {

    private DAOFactory factory;

    public FacturaBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void generarFactura(FacturaDomain factura) throws PathOrderException {


        validarIntegridadInformacionFactura(factura);

        var id = generarIdFactura();
        factura.setId(id);

        FacturaDomain facturaFinal = new FacturaDomain(
                factura.getId(),
                factura.getAdministrador(),
                factura.getFechaHora(),
                factura.getTotal()
        );

        FacturaEntity facturaEntity = FacturaEntityAssembler.getInstance().toEntity(facturaFinal);
        factory.getFacturaDAO().create(facturaEntity);
    }


    @Override
    public List<FacturaDomain> consultarFactura(FacturaDomain filtro) throws PathOrderException {
        FacturaEntity facturaEntity = FacturaEntityAssembler.getInstance().toEntity(filtro);
        List<FacturaEntity> facturaEntities = factory.getFacturaDAO().listByFilter(facturaEntity);
        return FacturaEntityAssembler.getInstance().toDomains(facturaEntities);
    }

    @Override
    public List<FacturaDomain> consultarFacturaCliente(FacturaDomain filtro) throws PathOrderException {
        FacturaEntity facturaEntity = FacturaEntityAssembler.getInstance().toEntity(filtro);
        List<FacturaEntity> facturaEntities = factory.getFacturaDAO().listByFilter(facturaEntity);
        return FacturaEntityAssembler.getInstance().toDomains(facturaEntities);
    }

    @Override
    public void anularFactura(UUID id) throws PathOrderException {
        factory.getFacturaDAO().delete(id);
    }

    private UUID generarIdFactura() throws PathOrderException {
        UUID id;
        var existeId = false;
        do {
            id = UtilUUID.generarNuevoUUID();
            var factura = factory.getFacturaDAO().listById(id);
            existeId = !UtilUUID.esValorDefecto(factura.getId());
        }while (existeId);

        return id;

    };

    private void validarInformacionAdministrador(AdministradorDomain admin) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(admin)) {
            throw BusinessLogicPathOrderException.reportar("El administrador es obligatorio");
        }
    }

    private void validarFechaHora(LocalDateTime fechaHora) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(fechaHora)) {
            throw BusinessLogicPathOrderException.reportar("La fecha y hora son obligatorias");
        }
    }

    private void validarTotal(int total) throws PathOrderException {
        int longitud = String.valueOf(total).length();
        if (!(longitud >= 3 && longitud <= 8)) {
            throw BusinessLogicPathOrderException.reportar("El total debe tener entre 3 y 8 dígitos");
        }

        if (!(total >= 100 && total <= 20000000)) {
            throw BusinessLogicPathOrderException.reportar("El total debe estar entre 100 y 20,000,000");
        }

    }

    private void validarIntegridadInformacionFactura(FacturaDomain factura) throws PathOrderException {
        validarInformacionAdministrador(factura.getAdministrador());
        validarFechaHora(factura.getFechaHora());
        validarTotal(factura.getTotal());
    }


}