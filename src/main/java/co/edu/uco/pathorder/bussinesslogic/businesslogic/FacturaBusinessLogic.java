package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;

import java.util.List;
import java.util.UUID;

public interface FacturaBusinessLogic {

    void generarFactura(FacturaDomain factura);

    List<FacturaDomain> consultarFactura(FacturaDomain filtro);

    List<FacturaDomain> consultarFacturaCliente(FacturaDomain filtro);

    void anularFactura(UUID id);

}
