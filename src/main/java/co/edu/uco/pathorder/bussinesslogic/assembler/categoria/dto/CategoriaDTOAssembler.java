package co.edu.uco.pathorder.bussinesslogic.assembler.categoria.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.CategoriaDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTOAssembler implements DTOAssembler<CategoriaDTO, CategoriaDomain> {

    private static final CategoriaDTOAssembler INSTANCE = new CategoriaDTOAssembler();

    private CategoriaDTOAssembler() {
        super();
    }

    public static CategoriaDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public CategoriaDomain toDomain(final CategoriaDTO dto) {
        if (UtilObjeto.getInstance().esNulo(dto)) {
            return null;
        }
        return new CategoriaDomain(dto.getId(), dto.getNombre());
    }

    @Override
    public CategoriaDTO toDTO(final CategoriaDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? CategoriaDTO.obtenerValorDefecto()
                : new CategoriaDTO(domain.getId(), domain.getNombre());
    }

    @Override
    public List<CategoriaDTO> toDTOs(final List<CategoriaDomain> domainList) {
        if (UtilObjeto.getInstance().esNulo(domainList) || domainList.isEmpty()) {
            return new ArrayList<>();
        }
        List<CategoriaDTO> dtoList = new ArrayList<>();
        for (CategoriaDomain domain : domainList) {
            dtoList.add(toDTO(domain));
        }
        return dtoList;
    }

    @Override
    public List<CategoriaDomain> toDomains(final List<CategoriaDTO> dtoList) {
        if (UtilObjeto.getInstance().esNulo(dtoList) || dtoList.isEmpty()) {
            return new ArrayList<>();
        }
        List<CategoriaDomain> domainList = new ArrayList<>();
        for (CategoriaDTO dto : dtoList) {
            CategoriaDomain domain = toDomain(dto);
            if (domain != null) {
                domainList.add(domain);
            }
        }
        return domainList;
    }
}
