package co.edu.uco.pathorder.bussinesslogic.assembler.factura.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.FacturaDomain;
import co.edu.uco.pathorder.entity.FacturaEntity;

import java.util.ArrayList;
import java.util.List;

public class FacturaEntityAssembler implements EntityAssembler<FacturaEntity, FacturaDomain> {

    private static final FacturaEntityAssembler INSTANCE = new FacturaEntityAssembler();

    private FacturaEntityAssembler() {
    }

    public static FacturaEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public FacturaEntity toEntity(FacturaDomain domain) {
//        return UtilObjeto.getInstance().esNulo(domain)
//                ? FacturaEntity.obtenerValorDefecto()
//                : new FacturaEntity(
//                domain.getId(),
//                AdministradorEntityAssembler.getInstance().toEntity(domain.getAdministrador()),
//                domain.getFechaHora(),
//                domain.getTotal()
//        );
        return null;
    }

    @Override
    public FacturaDomain toDomain(FacturaEntity entity) {
//        return UtilObjeto.getInstance().esNulo(entity)
//                ? FacturaDomain.obtenerValorDefecto()
//                : new FacturaDomain(
//                entity.getId(),
//                AdministradorEntityAssembler.getInstance().toDomain(entity.getAdministrador()),
//                entity.getFechaHora(),
//                entity.getTotal()
//        );
        return null;
    }

    @Override
    public List<FacturaDomain> toDomains(List<FacturaEntity> entities) {
        var listaResultados = new ArrayList<FacturaDomain>();
        for (FacturaEntity entity : entities) {
            listaResultados.add(toDomain(entity));
        }
        return listaResultados;
    }

    @Override
    public List<FacturaEntity> toEntities(List<FacturaDomain> domains) {
        var listaResultados = new ArrayList<FacturaEntity>();
        for (FacturaDomain domain : domains) {
            listaResultados.add(toEntity(domain));
        }
        return listaResultados;
    }
}