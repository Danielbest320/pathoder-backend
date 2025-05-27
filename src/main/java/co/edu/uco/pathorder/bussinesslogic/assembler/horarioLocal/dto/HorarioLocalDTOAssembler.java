package co.edu.uco.pathorder.bussinesslogic.assembler.horarioLocal.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HorarioLocalDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.HorarioLocalDTO;

import java.util.ArrayList;
import java.util.List;

public class HorarioLocalDTOAssembler implements DTOAssembler<HorarioLocalDTO, HorarioLocalDomain> {

    private static final HorarioLocalDTOAssembler INSTANCE = new HorarioLocalDTOAssembler();

    private HorarioLocalDTOAssembler() {
        super();
    }

    public static HorarioLocalDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public HorarioLocalDomain toDomain(final HorarioLocalDTO dto) {
        if (UtilObjeto.getInstance().esNulo(dto)) {
            return null;
        }

        return new HorarioLocalDomain(
                dto.getId(),
                dto.getEstadoLocal(),
                dto.getHoraDesde(),
                dto.getHoraHasta()
        );
    }

    @Override
    public HorarioLocalDTO toDTO(final HorarioLocalDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? HorarioLocalDTO.obtenerValorDefecto()
                : new HorarioLocalDTO(
                domain.getId(),
                domain.getEstadoLocal(),
                domain.getHoraDesde(),
                domain.getHoraHasta()
        );
    }

    @Override
    public List<HorarioLocalDTO> toDTOs(final List<HorarioLocalDomain> domains) {
        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return new ArrayList<>();
        }

        List<HorarioLocalDTO> dtos = new ArrayList<>();
        for (HorarioLocalDomain domain : domains) {
            dtos.add(toDTO(domain));
        }

        return dtos;
    }

    @Override
    public List<HorarioLocalDomain> toDomains(final List<HorarioLocalDTO> dtos) {
        if (UtilObjeto.getInstance().esNulo(dtos) || dtos.isEmpty()) {
            return new ArrayList<>();
        }

        List<HorarioLocalDomain> domains = new ArrayList<>();
        for (HorarioLocalDTO dto : dtos) {
            HorarioLocalDomain domain = toDomain(dto);
            if (domain != null) {
                domains.add(domain);
            }
        }

        return domains;
    }

}

