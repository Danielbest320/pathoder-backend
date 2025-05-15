package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import java.util.UUID;

public interface FacturaBusinessLogic {

    void generarFactura(FacturaDomain factura);

    void consultarFactura(FacturaDomain filtro);

    List<FacturaDomain> consultarFacturaCliente(FacturaDomain filtro);

    void anularFactura(UUID id);

}
