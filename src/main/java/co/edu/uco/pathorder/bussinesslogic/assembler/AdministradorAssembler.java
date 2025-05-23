package co.edu.uco.pathorder.bussinesslogic.assembler;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.dto.AdministradorDTO;
import java.util.List;
import java.util.stream.Collectors;

public final class AdministradorAssembler {


    private AdministradorAssembler(){

        //evitar instancia

    }


    public static AdministradorDomain toDomain(final AdministradorDTO dto){
        if (dto == null) {
            return null;
        }
        return new AdministradorDomain(
                dto.getId(),
                dto.getDi(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getCorreo(),
                dto.getTelefono(),
                dto.getContrasena(),
                dto.isConfirmacionCorreo(),
                dto.isConfirmacionTelefono(),
                dto.isEstadoCuenta(),
                dto.getUsuario()
        );
    }


    public static AdministradorDTO toDTO(final AdministradorDomain domain) {
        if (domain == null) {
            return null;
        }
        AdministradorDTO dto = new AdministradorDTO();
            dto.setId(domain.getId());
            dto.setDi(domain.getDi());
            dto.setNombre(domain.getNombre());
            dto.setApellido(domain.getApellido());
            dto.setCorreo(domain.getCorreo());
            dto.setTelefono(domain.getTelefono());
            dto.setContrasena(domain.getContrasena());
            dto.setConfirmacionCorreo(domain.isConfirmacionCorreo());
            dto.setConfirmacionTelefono(domain.isConfirmacionTelefono());
            dto.setEstadoCuenta(domain.isEstadoCuenta());
            dto.setUsuario(domain.getUsuario());
        return dto;
    }


    public static List<AdministradorDomain> fromDTOList(final List<AdministradorDTO> dtos) {
        if (dtos == null) {
            return List.of();
        }
        return dtos.stream()
                .map(AdministradorAssembler::toDomain)
                .collect(Collectors.toList());
    }

    public static List<AdministradorDTO> toDTOList(final List<AdministradorDomain> domains) {
        if (domains == null) {
            return List.of();
        }
        return domains.stream()
                .map(AdministradorAssembler::toDTO)
                .collect(Collectors.toList());
    }
}
