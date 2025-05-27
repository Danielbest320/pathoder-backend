package co.edu.uco.pathorder.bussinesslogic.assembler.producto.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.categoria.dto.CategoriaDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.tipoProducto.dto.TipoProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.ProductoDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductoDTOAssembler implements DTOAssembler<ProductoDTO, ProductoDomain> {

    private static final ProductoDTOAssembler INSTANCE = new ProductoDTOAssembler();

    private ProductoDTOAssembler() {
        super();
    }

    public static ProductoDTOAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public ProductoDomain toDomain(final ProductoDTO dto) {
        if (UtilObjeto.getInstance().esNulo(dto)) {
            return null;
        }

        return new ProductoDomain(
                dto.getId(),
                dto.getNombre(),
                TipoProductoDTOAssembler.getInstance().toDomain(dto.getTipoProducto()),
                dto.getDescripcion(),
                dto.getPrecio(),
                CategoriaDTOAssembler.getInstance().toDomain(dto.getCategoria())
        );
    }

    @Override
    public ProductoDTO toDTO(final ProductoDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? ProductoDTO.obtenerValorDefecto()
                : new ProductoDTO(
                domain.getId(),
                domain.getNombre(),
                TipoProductoDTOAssembler.getInstance().toDTO(domain.getTipoProducto()),
                domain.getDescripcion(),
                domain.getPrecio(),
                CategoriaDTOAssembler.getInstance().toDTO(domain.getCategoria())
        );
    }

    @Override
    public List<ProductoDTO> toDTOs(final List<ProductoDomain> domainList) {
        if (UtilObjeto.getInstance().esNulo(domainList) || domainList.isEmpty()) {
            return new ArrayList<>();
        }

        List<ProductoDTO> dtoList = new ArrayList<>();
        for (ProductoDomain domain : domainList) {
            dtoList.add(toDTO(domain));
        }

        return dtoList;
    }

    @Override
    public List<ProductoDomain> toDomains(final List<ProductoDTO> dtoList) {
        if (UtilObjeto.getInstance().esNulo(dtoList) || dtoList.isEmpty()) {
            return new ArrayList<>();
        }

        List<ProductoDomain> domainList = new ArrayList<>();
        for (ProductoDTO dto : dtoList) {
            ProductoDomain domain = toDomain(dto);
            if (domain != null) {
                domainList.add(domain);
            }
        }

        return domainList;
    }
}
