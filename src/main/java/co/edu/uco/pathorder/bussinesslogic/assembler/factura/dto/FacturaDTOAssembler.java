package co.edu.uco.pathorder.bussinesslogic.assembler.factura.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.FacturaDTO;

import java.util.ArrayList;
import java.util.List;

public class FacturaDTOAssembler implements DTOAssembler<FacturaDTO, FacturaDomain> {

    private static final FacturaDTOAssembler INSTANCE = new FacturaDTOAssembler();

    private FacturaDTOAssembler() {
    }

    public static FacturaDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public FacturaDomain toDomain(FacturaDTO dto) {
//        return UtilObjeto.getInstance().esNulo(dto)
//                ? FacturaDomain.obtenerValorDefecto()
//                : new FacturaDomain(
//                dto.getId(),
//                AdministradorDTOAssembler.getInstance().toDomain(dto.getAdministrador()),
//                dto.getFechaHora(),
//                dto.getTotal()
//        );
        return null;
    }

    @Override
    public FacturaDTO toDTO(FacturaDomain domain) {
//        return UtilObjeto.getInstance().esNulo(domain)
//                ? FacturaDTO.obtenerValorDefecto()
//                : new FacturaDTO(
//                domain.getId(),
//                AdministradorDTOAssembler.getInstance().toDTO(domain.getAdministrador()),
//                domain.getFechaHora(),
//                domain.getTotal()
//        );
        return null;
    }

    @Override
    public List<FacturaDTO> toDTOs(List<FacturaDomain> domains) {
        var listaResultados = new ArrayList<FacturaDTO>();
        for (FacturaDomain domain : domains) {
            listaResultados.add(toDTO(domain));
        }
        return listaResultados;
    }

    @Override
    public List<FacturaDomain> toDomains(List<FacturaDTO> dtos) {
        var listaResultados = new ArrayList<FacturaDomain>();
        for (FacturaDTO dto : dtos) {
            listaResultados.add(toDomain(dto));
        }
        return listaResultados;
    }
}