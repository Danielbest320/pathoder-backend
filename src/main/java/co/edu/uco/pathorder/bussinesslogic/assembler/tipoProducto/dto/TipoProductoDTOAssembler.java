package co.edu.uco.pathorder.bussinesslogic.assembler.tipoProducto.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.TipoProductoDTO;

import java.util.ArrayList;
import java.util.List;

public class TipoProductoDTOAssembler implements DTOAssembler<TipoProductoDTO, TipoProductoDomain> {

    private static final TipoProductoDTOAssembler INSTANCE = new TipoProductoDTOAssembler();

    private TipoProductoDTOAssembler() {
        super();
    }

    public static TipoProductoDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoProductoDomain toDomain(final TipoProductoDTO dto) {
        if (UtilObjeto.getInstance().esNulo(dto)) {
            return null;
        }
        return new TipoProductoDomain(dto.getId(), dto.getNombre());
    }

    @Override
    public TipoProductoDTO toDTO(final TipoProductoDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? TipoProductoDTO.obtenerValorDefecto()
                : new TipoProductoDTO(domain.getId(), domain.getNombre());
    }

    @Override
    public List<TipoProductoDTO> toDTOs(final List<TipoProductoDomain> domainList) {
        if (UtilObjeto.getInstance().esNulo(domainList) || domainList.isEmpty()) {
            return new ArrayList<>();
        }
        List<TipoProductoDTO> dtoList = new ArrayList<>();
        for (TipoProductoDomain domain : domainList) {
            dtoList.add(toDTO(domain));
        }
        return dtoList;
    }

    @Override
    public List<TipoProductoDomain> toDomains(final List<TipoProductoDTO> dtoList) {
        if (UtilObjeto.getInstance().esNulo(dtoList) || dtoList.isEmpty()) {
            return new ArrayList<>();
        }
        List<TipoProductoDomain> domainList = new ArrayList<>();
        for (TipoProductoDTO dto : dtoList) {
            TipoProductoDomain domain = toDomain(dto);
            if (domain != null) {
                domainList.add(domain);
            }
        }
        return domainList;
    }
}
