package co.edu.uco.pathorder.bussinesslogic.assembler.horarioLocal.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HorarioLocalDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.HorarioLocalEntity;

import java.util.ArrayList;
import java.util.List;

public class HorarioLocalEntityAssembler implements EntityAssembler <HorarioLocalEntity, HorarioLocalDomain> {

    private static final HorarioLocalEntityAssembler INSTANCE = new HorarioLocalEntityAssembler();

    private HorarioLocalEntityAssembler() {
        super();
    }

    public static HorarioLocalEntityAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public HorarioLocalEntity toEntity(HorarioLocalDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? HorarioLocalEntity.obtenerValorDefecto()
                : new HorarioLocalEntity(
                domain.getId(),
                domain.getEstadoLocal(),
                domain.getHoraDesde(),
                domain.getHoraHasta()
        );
    }

    @Override
    public HorarioLocalDomain toDomain(HorarioLocalEntity entity) {
        var entityNonNull = HorarioLocalEntity.obtenerValorDefecto(entity);

        return new HorarioLocalDomain(
                entityNonNull.getId(),
                entityNonNull.getEstadoLocal(),
                entityNonNull.getHoraDesde(),
                entityNonNull.getHoraHasta()
        );
    }

    @Override
    public List<HorarioLocalDomain> toDomains(List<HorarioLocalEntity> entities) {
        var resultados = new ArrayList<HorarioLocalDomain>();

        if (UtilObjeto.getInstance().esNulo(entities) || entities.isEmpty()) {
            return resultados;
        }

        for (HorarioLocalEntity entity : entities) {
            resultados.add(toDomain(entity));
        }

        return resultados;
    }

    @Override
    public List<HorarioLocalEntity> toEntities(List<HorarioLocalDomain> domains) {
        var resultados = new ArrayList<HorarioLocalEntity>();

        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return resultados;
        }

        for (HorarioLocalDomain domain : domains) {
            resultados.add(toEntity(domain));
        }

        return resultados;
    }
}
