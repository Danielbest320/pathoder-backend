package co.edu.uco.pathorder.bussinesslogic.assembler;

import java.util.List;

public interface EntityAssembler<E, D> {

    E toEntity(D domain);

    D toDomain(E entity);

    List<D> toDomains(List<E> entities);

    List<E> toEntities(List<D> domains);
}
