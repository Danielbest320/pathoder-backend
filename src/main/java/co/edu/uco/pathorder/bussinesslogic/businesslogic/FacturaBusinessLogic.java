package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface FacturaBusinessLogic {

    void generarFactura(FacturaDomain factura) throws PathOrderException;

    List<FacturaDomain> consultarFactura(FacturaDomain filtro) throws PathOrderException;

    List<FacturaDomain> consultarFacturaCliente(FacturaDomain filtro) throws PathOrderException;

    void anularFactura(UUID id) throws PathOrderException;

}
