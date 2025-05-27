package co.edu.uco.pathorder.bussinesslogic.assembler.ingredienteProducto.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.producto.entity.ProductoEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.IngredienteProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.IngredienteProductoEntity;

import java.util.ArrayList;
import java.util.List;

public class IngredienteProductoEntityAssembler implements EntityAssembler <IngredienteProductoEntity, IngredienteProductoDomain> {

    private static final IngredienteProductoEntityAssembler INSTANCE = new IngredienteProductoEntityAssembler();

    private IngredienteProductoEntityAssembler() {
        super();
    }

    public static IngredienteProductoEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public IngredienteProductoEntity toEntity(IngredienteProductoDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? IngredienteProductoEntity.obtenerValorDefecto()
                : new IngredienteProductoEntity(
                domain.getId(),
                ProductoEntityAssembler.getInstance().toEntity(domain.getProductoVenta()),
                ProductoEntityAssembler.getInstance().toEntity(domain.getProductoIngrediente()),
                domain.getCantidad()
        );
    }

    @Override
    public IngredienteProductoDomain toDomain(IngredienteProductoEntity entity) {
        var entityNonNull = IngredienteProductoEntity.obtenerValorDefecto(entity);

        return new IngredienteProductoDomain(
                entityNonNull.getId(),
                ProductoEntityAssembler.getInstance().toDomain(entityNonNull.getProductoVenta()),
                ProductoEntityAssembler.getInstance().toDomain(entityNonNull.getProductoIngrediente()),
                entityNonNull.getCantidad()
        );
    }

    @Override
    public List<IngredienteProductoDomain> toDomains(List<IngredienteProductoEntity> entities) {
        var resultados = new ArrayList<IngredienteProductoDomain>();
        if (UtilObjeto.getInstance().esNulo(entities) || entities.isEmpty()) {
            return resultados;
        }
        for (var entity : entities) {
            resultados.add(toDomain(entity));
        }
        return resultados;
    }

    @Override
    public List<IngredienteProductoEntity> toEntities(List<IngredienteProductoDomain> domains) {
        var resultados = new ArrayList<IngredienteProductoEntity>();
        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return resultados;
        }
        for (var domain : domains) {
            resultados.add(toEntity(domain));
        }
        return resultados;
    }
}
