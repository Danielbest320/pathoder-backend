package co.edu.uco.pathorder.bussinesslogic.assembler.producto.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.categoria.entity.CategoriaEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.tipoProducto.entity.TipoProductoEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductoEntityAssembler implements EntityAssembler<ProductoEntity, ProductoDomain> {

    private static final ProductoEntityAssembler INSTANCE = new ProductoEntityAssembler();

    private ProductoEntityAssembler() {
        super();
    }

    public static ProductoEntityAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public ProductoEntity toEntity(ProductoDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? ProductoEntity.obtenerValorDefecto()
                : new ProductoEntity(
                domain.getId(),
                domain.getNombre(),
                TipoProductoEntityAssembler.getInstance().toEntity(domain.getTipoProducto()),
                domain.getDescripcion(),
                domain.getPrecio(),
                CategoriaEntityAssembler.getInstance().toEntity(domain.getCategoria())
        );
    }

    @Override
    public ProductoDomain toDomain(ProductoEntity entity) {
        var productoEntity = ProductoEntity.obtenerValorDefecto(entity);
        return new ProductoDomain(
                productoEntity.getId(),
                productoEntity.getNombre(),
                TipoProductoEntityAssembler.getInstance().toDomain(productoEntity.getTipoProducto()),
                productoEntity.getDescripcion(),
                productoEntity.getPrecio(),
                CategoriaEntityAssembler.getInstance().toDomain(productoEntity.getCategoria())
        );
    }

    @Override
    public List<ProductoDomain> toDomains(List<ProductoEntity> entities) {
        var resultados = new ArrayList<ProductoDomain>();

        for (ProductoEntity entity : entities) {
            resultados.add(toDomain(entity));
        }

        return resultados;
    }

    @Override
    public List<ProductoEntity> toEntities(List<ProductoDomain> domains) {
        var resultados = new ArrayList<ProductoEntity>();

        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return resultados;
        }

        for (ProductoDomain domain : domains) {
            resultados.add(toEntity(domain));
        }

        return resultados;
    }
}
