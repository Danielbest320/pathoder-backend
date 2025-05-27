package co.edu.uco.pathorder.bussinesslogic.assembler.administrador.entity;

import co.edu.uco.pathorder.bussinesslogic.assembler.EntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.entity.AdministradorEntity;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class AdministradorEntityAssembler implements EntityAssembler<AdministradorEntity, AdministradorDomain> {

    private static final AdministradorEntityAssembler INSTANCE = new AdministradorEntityAssembler();

    private AdministradorEntityAssembler() {
        super();
    }

    public static AdministradorEntityAssembler getInstance() {
        return INSTANCE;
    }

    @Override
    public AdministradorEntity toEntity(AdministradorDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)? AdministradorEntity.obtenerValorDefecto()
                :new AdministradorEntity(
                domain.getId(),
                domain.getDi(),
                domain.getNombre(),
                domain.getApellido(),
                domain.getCorreo(),
                domain.getTelefono(),
                domain.getContrasena(),
                domain.isConfirmacionCorreo(),
                domain.isConfirmacionTelefono(),
                domain.isEstadoCuenta(),
                domain.getUsuario()
        );
    }

    @Override
    public AdministradorDomain toDomain(AdministradorEntity entity) {
        var paisEntityAssembler = AdministradorEntity.obtenerValorDefecto(entity);


        return new AdministradorDomain(
                paisEntityAssembler.getId(),
                paisEntityAssembler.getDi(),
                paisEntityAssembler.getNombre(),
                paisEntityAssembler.getApellido(),
                paisEntityAssembler.getCorreo(),
                paisEntityAssembler.getTelefono(),
                paisEntityAssembler.getContrasena(),
                paisEntityAssembler.isConfirmacionCorreo(),
                paisEntityAssembler.isConfirmacionTelefono(),
                paisEntityAssembler.isEstadoCuenta(),
                paisEntityAssembler.getUsuario()
        );
    }

    @Override
    public List<AdministradorDomain> toDomains(List<AdministradorEntity> entityList) {
        var listaResultados = new ArrayList<AdministradorDomain>();

        for (AdministradorEntity adminentity : entityList) {
            listaResultados.add(toDomain(adminentity));
        }
        return listaResultados;
    }

    @Override
    public List<AdministradorEntity> toEntities(List<AdministradorDomain> domains) {
        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return Collections.emptyList();
        }
        return null;

    }
}
