package co.edu.uco.pathorder.bussinesslogic.assembler.detallefactura.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.DetalleFacturaDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.DetalleFacturaEntity;

import java.util.ArrayList;
import java.util.List;

public class DetalleFacturaEntityAssembler implements EntityAssembler<DetalleFacturaEntity, DetalleFacturaDomain> {

    private static final DetalleFacturaEntityAssembler INSTANCE = new DetalleFacturaEntityAssembler();

    private DetalleFacturaEntityAssembler() {
    }

    public static DetalleFacturaEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public DetalleFacturaEntity toEntity(DetalleFacturaDomain domain) {
//        return UtilObjeto.getInstance().esNulo(domain)
//                ? DetalleFacturaEntity.obtenerValorDefecto()
//                : new DetalleFacturaEntity(
//                domain.getId(),
//                FacturaEntityAssembler.getInstance().toEntity(domain.getFactura()),
//                ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()),
//                domain.getCantidad(),
//                domain.getPrecio()
//        );
        return null;
    }

    @Override
    public DetalleFacturaDomain toDomain(DetalleFacturaEntity entity) {
//        return UtilObjeto.getInstance().esNulo(entity)
//                ? DetalleFacturaDomain.obtenerValorDefecto()
//                : new DetalleFacturaDomain(
//                entity.getId(),
//                FacturaEntityAssembler.getInstance().toDomain(entity.getFactura()),
//                ProductoEntityAssembler.getInstance().toDomain(entity.getProducto()),
//                entity.getCantidad(),
//                entity.getPrecio()
//        );
        return null;
    }

    @Override
    public List<DetalleFacturaDomain> toDomains(List<DetalleFacturaEntity> entities) {
        var listaResultados = new ArrayList<DetalleFacturaDomain>();
        for (DetalleFacturaEntity entity : entities) {
            listaResultados.add(toDomain(entity));
        }
        return listaResultados;
    }

    @Override
    public List<DetalleFacturaEntity> toEntities(List<DetalleFacturaDomain> domains) {
        var listaResultados = new ArrayList<DetalleFacturaEntity>();
        for (DetalleFacturaDomain domain : domains) {
            listaResultados.add(toEntity(domain));
        }
        return listaResultados;
    }
}