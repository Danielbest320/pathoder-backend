package co.edu.uco.pathorder.bussinesslogic.assembler.tiponotificacion.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.TipoNotificacionDTO;

import java.util.ArrayList;
import java.util.List;

public class TipoNotificacionDTOAssembler implements DTOAssembler<TipoNotificacionDTO, TipoNotificacionDomain> {

    private static final TipoNotificacionDTOAssembler INSTANCE = new TipoNotificacionDTOAssembler();

    private TipoNotificacionDTOAssembler() {
    }

    public static TipoNotificacionDTOAssembler getINSTANCE() {
        return INSTANCE;
    }

    public static TipoNotificacionDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoNotificacionDomain toDomain(TipoNotificacionDTO dto) {
        var tipoNotificacionDTO = TipoNotificacionDTO.obtenerValorDefecto(dto);

        return  new TipoNotificacionDomain(
                tipoNotificacionDTO.getId(),
                tipoNotificacionDTO.getNombre(),
                tipoNotificacionDTO.getMensaje(),
                tipoNotificacionDTO.getDescripcion()
        );
    }

    @Override
    public TipoNotificacionDTO toDTO(TipoNotificacionDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? TipoNotificacionDTO.obtenerValorDefecto()
                : new TipoNotificacionDTO(
                domain.getId(),
                domain.getNombre(),
                domain.getMensaje(),
                domain.getDescripcion()
        );
    }

    @Override
    public List<TipoNotificacionDTO> toDTOs(List<TipoNotificacionDomain> domains) {
        var listaResultados = new ArrayList<TipoNotificacionDTO>();
        for (TipoNotificacionDomain domain : domains) {
            listaResultados.add(toDTO(domain));
        }
        return listaResultados;
    }

    @Override
    public List<TipoNotificacionDomain> toDomains(List<TipoNotificacionDTO> dtos) {
        var listaResultados = new ArrayList<TipoNotificacionDomain>();
        for (TipoNotificacionDTO dto : dtos) {
            listaResultados.add(toDomain(dto));
        }
        return listaResultados;
    }
}