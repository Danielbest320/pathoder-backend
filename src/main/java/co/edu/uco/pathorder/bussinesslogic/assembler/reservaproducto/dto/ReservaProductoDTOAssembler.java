package co.edu.uco.pathorder.bussinesslogic.assembler.reservaproducto.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.ReservaProductoDTO;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;

import java.util.ArrayList;
import java.util.List;

public class ReservaProductoDTOAssembler implements DTOAssembler<ReservaProductoDTO, ReservaProductoDomain> {

    private static final ReservaProductoDTOAssembler INSTANCE = new ReservaProductoDTOAssembler();

    private ReservaProductoDTOAssembler() {
    }

    public static ReservaProductoDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public ReservaProductoDomain toDomain(ReservaProductoDTO dto) {
        return null;
    }

    @Override
    public ReservaProductoDTO toDTO(ReservaProductoDomain domain) {
        return null;
    }

    @Override
    public List<ReservaProductoDTO> toDTOs(List<ReservaProductoDomain> domains) {
        var listaResultados = new ArrayList<ReservaProductoDTO>();

        for (ReservaProductoDomain domain  : domains) {
            listaResultados.add(toDTO(domain));
        }

        return listaResultados;
    }

    @Override
    public List<ReservaProductoDomain> toDomains(List<ReservaProductoDTO> dtos) {
        var listaResultados = new ArrayList<ReservaProductoDomain>();

        for (ReservaProductoDTO dto : dtos) {
            listaResultados.add(toDomain(dto));
        }

        return listaResultados;
    }
}
