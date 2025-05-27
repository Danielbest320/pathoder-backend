package co.edu.uco.pathorder.bussinesslogic.assembler.categoria.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.CategoriaEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoriaEntityAssembler implements EntityAssembler<CategoriaEntity, CategoriaDomain> {

    private static final CategoriaEntityAssembler INSTANCE = new CategoriaEntityAssembler();

    private CategoriaEntityAssembler() {
        super();
    }

    public static CategoriaEntityAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public CategoriaEntity toEntity(CategoriaDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? CategoriaEntity.obtenerValorDefecto()
                : new CategoriaEntity(domain.getId(), domain.getNombre());
    }

    @Override
    public CategoriaDomain toDomain(CategoriaEntity entity) {
        var categoriaEntity = CategoriaEntity.obtenerValorDefecto(entity);
        return new CategoriaDomain(categoriaEntity.getId(), categoriaEntity.getNombre());
    }

    @Override
    public List<CategoriaDomain> toDomains(List<CategoriaEntity> entities) {
        var resultados = new ArrayList<CategoriaDomain>();

        for (CategoriaEntity entity : entities) {
            resultados.add(toDomain(entity));
        }

        return resultados;
    }

    @Override
    public List<CategoriaEntity> toEntities(List<CategoriaDomain> domains) {
        var resultados = new ArrayList<CategoriaEntity>();

        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return resultados;
        }

        for (CategoriaDomain domain : domains) {
            resultados.add(toEntity(domain));
        }

        return resultados;
    }
}
