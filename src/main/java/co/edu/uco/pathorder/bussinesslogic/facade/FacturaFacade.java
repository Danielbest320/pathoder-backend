package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.FacturaDTO;

import java.util.List;
import java.util.UUID;

public interface FacturaFacade {

    void generarFactura(FacturaDTO factura);

    List<FacturaDTO> consultarFactura(FacturaDTO filtro);

    List<FacturaDTO> consultarFacturaCliente(FacturaDTO filtro);

    void anularFactura(UUID id);

}
