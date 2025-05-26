package co.edu.uco.pathorder.bussinesslogic.assembler.administrador.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.AdministradorDTO;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDTOAssembler implements DTOAssembler<AdministradorDTO,AdministradorDomain> {



    private static final AdministradorDTOAssembler INSTANCE = new AdministradorDTOAssembler();

    private AdministradorDTOAssembler() {
        super();
    }

    public static AdministradorDTOAssembler getInstance() {
        return INSTANCE;
    }




    @Override
    public AdministradorDomain toDomain(AdministradorDTO dto) {
        var administradorDTPAssembler = UtilObjeto.getInstance().esNulo(dto)
                ?AdministradorDTO.obtenerValorDefecto()
                :dto;

        return new AdministradorDomain(
                administradorDTPAssembler.getId(),
                administradorDTPAssembler.getDi(),
                administradorDTPAssembler.getNombre(),
                administradorDTPAssembler.getApellido(),
                administradorDTPAssembler.getCorreo(),
                administradorDTPAssembler.getTelefono(),
                administradorDTPAssembler.getContrasena(),
                administradorDTPAssembler.isConfirmacionCorreo(),
                administradorDTPAssembler.isConfirmacionTelefono(),
                administradorDTPAssembler.isEstadoCuenta(),
                administradorDTPAssembler.getUsuario()
        );
    }

    @Override
    public AdministradorDTO toDTO(AdministradorDomain domain) {
        if (UtilObjeto.getInstance().esNulo(domain)) {
            return AdministradorDTO.obtenerValorDefecto();
        }

        return new AdministradorDTO(
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
    public List<AdministradorDTO> toDTOs(List<AdministradorDomain> domainsList) {
        var resultados = new ArrayList<AdministradorDTO>();
        if (UtilObjeto.getInstance().esNulo(domainsList)) {
            return resultados;
        }

        for (AdministradorDomain domain : domainsList) {
            resultados.add(toDTO(domain));
        }
        return resultados;
    }

    @Override
    public List<AdministradorDomain> toDomains(List<AdministradorDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return List.of();
        }
        List<AdministradorDomain> domains = new ArrayList<>();
        for (AdministradorDTO dtoItem : dtos) {
            AdministradorDomain domain = toDomain(dtoItem);
            if (domain != null) {
                domains.add(domain);
            }
        }
        return domains;
    }
}
