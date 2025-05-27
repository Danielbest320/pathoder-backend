package co.edu.uco.pathorder.bussinesslogic.assembler.inventario.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.producto.entity.ProductoEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.InventarioDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.InventarioEntity;

import java.util.ArrayList;
import java.util.List;

public class InventarioEntityAssembler implements EntityAssembler<InventarioEntity, InventarioDomain> {

    private static final InventarioEntityAssembler INSTANCE = new InventarioEntityAssembler();

    private InventarioEntityAssembler() {
        super();
    }

    public static InventarioEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public InventarioEntity toEntity(InventarioDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? InventarioEntity.obtenerValorDefecto()
                : new InventarioEntity(
                domain.getId(),
                ProductoEntityAssembler.getInstance().toEntity(domain.getProducto()),
                domain.getDisponibilidad()
        );
    }

    @Override
    public InventarioDomain toDomain(InventarioEntity entity) {
        var inventarioEntity = InventarioEntity.obtenerValorDefecto(entity);

        return new InventarioDomain(
                inventarioEntity.getId(),
                ProductoEntityAssembler.getInstance().toDomain(inventarioEntity.getProducto()),
                inventarioEntity.getDisponibilidad()
        );
    }

    @Override
    public List<InventarioDomain> toDomains(List<InventarioEntity> entities) {
        var resultados = new ArrayList<InventarioDomain>();

        for (InventarioEntity entity : entities) {
            resultados.add(toDomain(entity));
        }

        return resultados;
    }

    @Override
    public List<InventarioEntity> toEntities(List<InventarioDomain> domains) {
        var resultados = new ArrayList<InventarioEntity>();

        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return resultados;
        }

        for (InventarioDomain domain : domains) {
            resultados.add(toEntity(domain));
        }

        return resultados;
    }
}
