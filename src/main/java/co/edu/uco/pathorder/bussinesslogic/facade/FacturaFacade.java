package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.FacturaDTO;

import java.util.List;
import java.util.UUID;

public interface FacturaFacade {

    void generarFactura(FacturaDTO factura) throws PathOrderException;

    List<FacturaDTO> consultarFactura(FacturaDTO filtro) throws PathOrderException;

    List<FacturaDTO> consultarFacturaCliente(FacturaDTO filtro) throws PathOrderException;

    void anularFactura(UUID id) throws PathOrderException;

}
