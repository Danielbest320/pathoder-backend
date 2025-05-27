package co.edu.uco.pathorder.bussinesslogic.assembler.ingredienteProducto.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.IngredienteProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.IngredienteProductoDTO;

import java.util.ArrayList;
import java.util.List;

public class IngredienteProductoDTOAssembler implements DTOAssembler <IngredienteProductoDTO, IngredienteProductoDomain> {

    private static final IngredienteProductoDTOAssembler INSTANCE = new IngredienteProductoDTOAssembler();

    private IngredienteProductoDTOAssembler() {
        super();
    }

    public static IngredienteProductoDTOAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public IngredienteProductoDomain toDomain(final IngredienteProductoDTO dto) {
        if (UtilObjeto.getInstance().esNulo(dto)) {
            return null;
        }

        return new IngredienteProductoDomain(
                dto.getId(),
                ProductoDTOAssembler.getInstance().toDomain(dto.getProductoVenta()),
                ProductoDTOAssembler.getInstance().toDomain(dto.getProductoIngrediente()),
                dto.getCantidad()
        );
    }

    @Override
    public IngredienteProductoDTO toDTO(final IngredienteProductoDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? IngredienteProductoDTO.obtenerValorDefecto()
                : new IngredienteProductoDTO(
                domain.getId(),
                ProductoDTOAssembler.getInstance().toDTO(domain.getProductoVenta()),
                ProductoDTOAssembler.getInstance().toDTO(domain.getProductoIngrediente()),
                domain.getCantidad()
        );
    }

    @Override
    public List<IngredienteProductoDTO> toDTOs(final List<IngredienteProductoDomain> domains) {
        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return new ArrayList<>();
        }

        List<IngredienteProductoDTO> dtos = new ArrayList<>();
        for (IngredienteProductoDomain domain : domains) {
            dtos.add(toDTO(domain));
        }

        return dtos;
    }

    @Override
    public List<IngredienteProductoDomain> toDomains(final List<IngredienteProductoDTO> dtos) {
        if (UtilObjeto.getInstance().esNulo(dtos) || dtos.isEmpty()) {
            return new ArrayList<>();
        }

        List<IngredienteProductoDomain> domains = new ArrayList<>();
        for (IngredienteProductoDTO dto : dtos) {
            IngredienteProductoDomain domain = toDomain(dto);
            if (domain != null) {
                domains.add(domain);
            }
        }

        return domains;
    }
}
