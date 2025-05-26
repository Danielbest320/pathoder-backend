package co.edu.uco.pathorder.bussinesslogic.assembler.notificacion.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.NotificacionDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.NotificacionEntity;

import java.util.ArrayList;
import java.util.List;

public class NotificacionEntityAssembler implements EntityAssembler<NotificacionEntity, NotificacionDomain> {

    private static final NotificacionEntityAssembler INSTANCE = new NotificacionEntityAssembler();

    private NotificacionEntityAssembler() {
    }

    public static NotificacionEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public NotificacionEntity toEntity(NotificacionDomain domain) {
//        return UtilObjeto.getInstance().esNulo(domain)
//                ? NotificacionEntity.obtenerValorDefecto()
//                : new NotificacionEntity(
//                domain.getId(),
//                ClienteEntityAssembler.getInstance().toEntity(domain.getCliente()),
//                domain.getMensaje(),
//                domain.getFechaHora(),
//                domain.getEstado()
//        );
        return null;
    }

    @Override
    public NotificacionDomain toDomain(NotificacionEntity entity) {
//        return UtilObjeto.getInstance().esNulo(entity)
//                ? NotificacionDomain.obtenerValorDefecto()
//                : new NotificacionDomain(
//                entity.getId(),
//                ClienteEntityAssembler.getInstance().toDomain(entity.getCliente()),
//                entity.getMensaje(),
//                entity.getFechaHora(),
//                entity.getEstado()
//        );
        return null;
    }

    @Override
    public List<NotificacionDomain> toDomains(List<NotificacionEntity> entities) {
        var listaResultados = new ArrayList<NotificacionDomain>();
        for (NotificacionEntity entity : entities) {
            listaResultados.add(toDomain(entity));
        }
        return listaResultados;
    }

    @Override
    public List<NotificacionEntity> toEntities(List<NotificacionDomain> domains) {
        var listaResultados = new ArrayList<NotificacionEntity>();
        for (NotificacionDomain domain : domains) {
            listaResultados.add(toEntity(domain));
        }
        return listaResultados;
    }
}