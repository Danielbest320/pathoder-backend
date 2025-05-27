package co.edu.uco.pathorder.bussinesslogic.assembler.tiponotificacion.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;

import java.util.ArrayList;
import java.util.List;

public class TipoNotificacionEntityAssembler implements EntityAssembler<TipoNotificacionEntity, TipoNotificacionDomain> {

    private static final TipoNotificacionEntityAssembler INSTANCE = new TipoNotificacionEntityAssembler();

    private TipoNotificacionEntityAssembler() {
    }

    public static TipoNotificacionEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public TipoNotificacionEntity toEntity(TipoNotificacionDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? TipoNotificacionEntity.obtenerValorDefecto()
                : new TipoNotificacionEntity(
                domain.getId(),
                domain.getNombre(),
                domain.getMensaje(),
                domain.getDescripcion()
        );

    }

    @Override
    public TipoNotificacionDomain toDomain(TipoNotificacionEntity entity) {

        var tipoNotificacionEntity = TipoNotificacionEntity.obtenerValorDefecto(entity);

        return  new TipoNotificacionDomain(
                tipoNotificacionEntity.getId(),
                tipoNotificacionEntity.getNombre(),
                tipoNotificacionEntity.getMensaje(),
                tipoNotificacionEntity.getDescripcion()
        );

    }

    @Override
    public List<TipoNotificacionDomain> toDomains(List<TipoNotificacionEntity> entities) {
        var listaResultados = new ArrayList<TipoNotificacionDomain>();
        for (TipoNotificacionEntity entity : entities) {
            listaResultados.add(toDomain(entity));
        }
        return listaResultados;
    }

    @Override
    public List<TipoNotificacionEntity> toEntities(List<TipoNotificacionDomain> domains) {
        var listaResultados = new ArrayList<TipoNotificacionEntity>();
        for (TipoNotificacionDomain domain : domains) {
            listaResultados.add(toEntity(domain));
        }
        return listaResultados;
    }
}