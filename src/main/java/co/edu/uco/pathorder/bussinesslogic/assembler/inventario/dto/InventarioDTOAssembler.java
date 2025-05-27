package co.edu.uco.pathorder.bussinesslogic.assembler.inventario.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.InventarioDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.InventarioDTO;

import java.util.ArrayList;
import java.util.List;

public class InventarioDTOAssembler implements DTOAssembler<InventarioDTO, InventarioDomain> {

    private static final InventarioDTOAssembler INSTANCE = new InventarioDTOAssembler();

    private InventarioDTOAssembler() {
        super();
    }

    public static InventarioDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public InventarioDomain toDomain(final InventarioDTO dto) {
        if (UtilObjeto.getInstance().esNulo(dto)) {
            return null;
        }

        return new InventarioDomain(
                dto.getId(),
                ProductoDTOAssembler.getInstance().toDomain(dto.getProducto()),
                dto.getDisponibilidad()
        );
    }

    @Override
    public InventarioDTO toDTO(final InventarioDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? InventarioDTO.obtenerValorDefecto()
                : new InventarioDTO(
                domain.getId(),
                ProductoDTOAssembler.getInstance().toDTO(domain.getProducto()),
                domain.getDisponibilidad()
        );
    }

    @Override
    public List<InventarioDTO> toDTOs(final List<InventarioDomain> domains) {
        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return new ArrayList<>();
        }

        List<InventarioDTO> dtos = new ArrayList<>();
        for (InventarioDomain domain : domains) {
            dtos.add(toDTO(domain));
        }

        return dtos;
    }

    @Override
    public List<InventarioDomain> toDomains(final List<InventarioDTO> dtos) {
        if (UtilObjeto.getInstance().esNulo(dtos) || dtos.isEmpty()) {
            return new ArrayList<>();
        }

        List<InventarioDomain> domains = new ArrayList<>();
        for (InventarioDTO dto : dtos) {
            InventarioDomain domain = toDomain(dto);
            if (domain != null) {
                domains.add(domain);
            }
        }

        return domains;
    }

}
