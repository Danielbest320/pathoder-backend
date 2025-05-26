package co.edu.uco.pathorder.bussinesslogic.assembler.notificacion.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.NotificacionDTO;

import java.util.ArrayList;
import java.util.List;

public class NotificacionDTOAssembler implements DTOAssembler<NotificacionDTO, NotificacionDomain> {

    private static final NotificacionDTOAssembler INSTANCE = new NotificacionDTOAssembler();

    private NotificacionDTOAssembler() {
    }

    public static NotificacionDTOAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public NotificacionDomain toDomain(NotificacionDTO dto) {
//        return UtilObjeto.getInstance().esNulo(dto)
//                ? NotificacionDomain.obtenerValorDefecto()
//                : new NotificacionDomain(
//                dto.getId(),
//                ClienteDTOAssembler.getInstance().toDomain(dto.getCliente()),
//                dto.getMensaje(),
//                dto.getFechaHora(),
//                dto.getEstado()
//        );
        return null;
    }

    @Override
    public NotificacionDTO toDTO(NotificacionDomain domain) {
//        return UtilObjeto.getInstance().esNulo(domain)
//                ? NotificacionDTO.obtenerValorDefecto()
//                : new NotificacionDTO(
//                domain.getId(),
//                ClienteDTOAssembler.getInstance().toDTO(domain.getCliente()),
//                domain.getMensaje(),
//                domain.getFechaHora(),
//                domain.getEstado()
//        );
        return null;
    }

    @Override
    public List<NotificacionDTO> toDTOs(List<NotificacionDomain> domains) {
        var listaResultados = new ArrayList<NotificacionDTO>();
        for (NotificacionDomain domain : domains) {
            listaResultados.add(toDTO(domain));
        }
        return listaResultados;
    }

    @Override
    public List<NotificacionDomain> toDomains(List<NotificacionDTO> dtos) {
        var listaResultados = new ArrayList<NotificacionDomain>();
        for (NotificacionDTO dto : dtos) {
            listaResultados.add(toDomain(dto));
        }
        return listaResultados;
    }
}