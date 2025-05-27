package co.edu.uco.pathorder.bussinesslogic.assembler.reservaproducto.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;

import java.util.ArrayList;
import java.util.List;

public class ReservaProductoEntityAssembler implements EntityAssembler<ReservaProductoEntity, ReservaProductoDomain> {

    private static final ReservaProductoEntityAssembler INSTANCE = new ReservaProductoEntityAssembler();

    private ReservaProductoEntityAssembler(){

    }

    public static ReservaProductoEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public ReservaProductoEntity toEntity(ReservaProductoDomain domain) {
//        return UtilObjeto.getInstance().esNulo(domain)
//                ? ReservaProductoEntity.obtenerValorDefecto()
//                : new ReservaProductoEntity(domain.getId(),
//                ReservaEntityAssembler.getInstance().toEntity(domain.getReserva()),
//                ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()),
//                domain.getCantidad());
        return null;
    }

    @Override
    public ReservaProductoDomain toDomain(ReservaProductoEntity entity) {
//        var reservaProductoEntity = ReservaProductoEntity.obtenerValorDefecto(entity);
//
//        return  new ReservaProductoDomain(reservaProductoEntity.getId(),
//                ResevaEntityAssembler.getInstance().toDomain(reservaProductoEntity.getReserva()),
//                ProductoEntityAssembler.getInstance().toDomain(reservaProductoEntity.getProducto()),
//                reservaProductoEntity.getCantidad());
        return null;
    }

    @Override
    public List<ReservaProductoDomain> toDomains(List<ReservaProductoEntity> entities) {
        var listaResultados = new ArrayList<ReservaProductoDomain>();

        for (ReservaProductoEntity entity : entities) {
            listaResultados.add(toDomain(entity));
        }

        return listaResultados;
    }

    @Override
    public List<ReservaProductoEntity> toEntities(List<ReservaProductoDomain> domains) {
        var listaResultados = new ArrayList<ReservaProductoEntity>();

        for (ReservaProductoDomain domain : domains) {
            listaResultados.add(toEntity(domain));
        }

        return listaResultados;
    }
}
