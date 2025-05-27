package co.edu.uco.pathorder.bussinesslogic.assembler.tipoProducto.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoProductoDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.entity.TipoProductoEntity;

import java.util.ArrayList;
import java.util.List;

public class TipoProductoEntityAssembler implements EntityAssembler <TipoProductoEntity, TipoProductoDomain> {

    private static final TipoProductoEntityAssembler INSTANCE = new TipoProductoEntityAssembler();

    private TipoProductoEntityAssembler() {
        super();
    }

    public static TipoProductoEntityAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public TipoProductoEntity toEntity(TipoProductoDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? TipoProductoEntity.obtenerValorDefecto()
                : new TipoProductoEntity(domain.getId(), domain.getNombre());
    }

    @Override
    public TipoProductoDomain toDomain(TipoProductoEntity entity) {
        var tipoProductoEntity = TipoProductoEntity.obtenerValorDefecto(entity);
        return new TipoProductoDomain(tipoProductoEntity.getId(), tipoProductoEntity.getNombre());
    }

    @Override
    public List<TipoProductoDomain> toDomains(List<TipoProductoEntity> entities) {
        var listaResultado = new ArrayList<TipoProductoDomain>();

        for (TipoProductoEntity entity : entities) {
            listaResultado.add(toDomain(entity));
        }

        return listaResultado;
    }

    @Override
    public List<TipoProductoEntity> toEntities(List<TipoProductoDomain> domains) {
        var listaResultado = new ArrayList<TipoProductoEntity>();

        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return listaResultado;
        }

        for (TipoProductoDomain domain : domains) {
            listaResultado.add(toEntity(domain));
        }

        return listaResultado;
    }
}
