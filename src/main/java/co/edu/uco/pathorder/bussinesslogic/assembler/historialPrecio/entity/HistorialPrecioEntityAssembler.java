package co.edu.uco.pathorder.bussinesslogic.assembler.historialPrecio.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.producto.entity.ProductoEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HistorialPrecioDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.HistorialPrecioEntity;

import java.util.ArrayList;
import java.util.List;

public class HistorialPrecioEntityAssembler implements EntityAssembler <HistorialPrecioEntity, HistorialPrecioDomain> {

    private static final HistorialPrecioEntityAssembler INSTANCE = new HistorialPrecioEntityAssembler();

    private HistorialPrecioEntityAssembler() {
        super();
    }

    public static HistorialPrecioEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public HistorialPrecioEntity toEntity(HistorialPrecioDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? HistorialPrecioEntity.obtenerValorDefecto()
                : new HistorialPrecioEntity(
                domain.getId(),
                ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()),
                domain.getPrecio(),
                domain.getFechaDesde(),
                domain.getFechaHasta()
        );
    }

    @Override
    public HistorialPrecioDomain toDomain(HistorialPrecioEntity entity) {
        var historialEntity = HistorialPrecioEntity.obtenerValorDefecto(entity);

        return new HistorialPrecioDomain(
                historialEntity.getId(),
                ProductoEntityAssembler.getInstance().toDomain(historialEntity.getProducto()),
                historialEntity.getPrecio(),
                historialEntity.getFechaDesde(),
                historialEntity.getFechaHasta()
        );
    }

    @Override
    public List<HistorialPrecioDomain> toDomains(List<HistorialPrecioEntity> entities) {
        var resultados = new ArrayList<HistorialPrecioDomain>();

        for (HistorialPrecioEntity entity : entities) {
            resultados.add(toDomain(entity));
        }

        return resultados;
    }

    @Override
    public List<HistorialPrecioEntity> toEntities(List<HistorialPrecioDomain> domains) {
        var resultados = new ArrayList<HistorialPrecioEntity>();

        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return resultados;
        }

        for (HistorialPrecioDomain domain : domains) {
            resultados.add(toEntity(domain));
        }

        return resultados;
    }
}
