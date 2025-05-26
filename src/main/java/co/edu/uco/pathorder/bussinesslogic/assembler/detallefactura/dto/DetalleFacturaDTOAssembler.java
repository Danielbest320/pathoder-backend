package co.edu.uco.pathorder.bussinesslogic.assembler.detallefactura.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.DetalleFacturaDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.DetalleFacturaDTO;

import java.util.ArrayList;
import java.util.List;

public class DetalleFacturaDTOAssembler implements DTOAssembler<DetalleFacturaDTO, DetalleFacturaDomain> {

    private static final DetalleFacturaDTOAssembler INSTANCE = new DetalleFacturaDTOAssembler();

    private DetalleFacturaDTOAssembler() {
    }

    public static DetalleFacturaDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public DetalleFacturaDomain toDomain(DetalleFacturaDTO dto) {
//        return UtilObjeto.getInstance().esNulo(dto)
//                ? DetalleFacturaDomain.obtenerValorDefecto()
//                : new DetalleFacturaDomain(
//                dto.getId(),
//                FacturaDTOAssembler.getInstance().toDomain(dto.getFactura()),
//                ProductoDTOAssembler.getInstance().toDomain(dto.getProducto()),
//                dto.getCantidad(),
//                dto.getPrecio()
//        );
        return null;
    }

    @Override
    public DetalleFacturaDTO toDTO(DetalleFacturaDomain domain) {
//        return UtilObjeto.getInstance().esNulo(domain)
//                ? DetalleFacturaDTO.obtenerValorDefecto()
//                : new DetalleFacturaDTO(
//                domain.getId(),
//                FacturaDTOAssembler.getInstance().toDTO(domain.getFactura()),
//                ProductoDTOAssembler.getInstance().toDTO(domain.getProducto()),
//                domain.getCantidad(),
//                domain.getPrecio()
//        );
        return null;
    }

    @Override
    public List<DetalleFacturaDTO> toDTOs(List<DetalleFacturaDomain> domains) {
        var listaResultados = new ArrayList<DetalleFacturaDTO>();
        for (DetalleFacturaDomain domain : domains) {
            listaResultados.add(toDTO(domain));
        }
        return listaResultados;
    }

    @Override
    public List<DetalleFacturaDomain> toDomains(List<DetalleFacturaDTO> dtos) {
        var listaResultados = new ArrayList<DetalleFacturaDomain>();
        for (DetalleFacturaDTO dto : dtos) {
            listaResultados.add(toDomain(dto));
        }
        return listaResultados;
    }
}