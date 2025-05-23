package co.edu.uco.pathorder.bussinesslogic.mapper;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.entity.AdministradorEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class AdministradorMapper {

    private  AdministradorMapper() {
        //evitar instancia
    }



    public static AdministradorEntity toEntity(final AdministradorDomain domain)  {
        if (domain == null) {
            return null;
        }
        var entityRetorno = new AdministradorEntity();
        entityRetorno.setId(domain.getId());
        entityRetorno.setDi(domain.getDi());
        entityRetorno.setNombre(domain.getNombre());
        entityRetorno.setApellido(domain.getApellido());
        entityRetorno.setCorreo(domain.getCorreo());
        entityRetorno.setTelefono(domain.getTelefono());
        entityRetorno.setContrasena(domain.getContrasena());
        entityRetorno.setConfirmacionCorreo(domain.isConfirmacionCorreo());
        entityRetorno.setConfirmacionTelefono(domain.isConfirmacionTelefono());
        entityRetorno.setEstadoCuenta(domain.isEstadoCuenta());
        entityRetorno.setUsuario(domain.getUsuario());
        return entityRetorno;

    }


    public static AdministradorDomain toDomain(final AdministradorEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AdministradorDomain(
                entity.getId(),
                entity.getDi(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getCorreo(),
                entity.getTelefono(),
                entity.getContrasena(),
                entity.isConfirmacionCorreo(),
                entity.isConfirmacionTelefono(),
                entity.isEstadoCuenta(),
                entity.getUsuario()
        );
    }


    public static List<AdministradorDomain> toDomainList(final List<AdministradorEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(AdministradorMapper::toDomain)
                .collect(Collectors.toList());
    }


}
