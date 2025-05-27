package co.edu.uco.pathorder.bussinesslogic.assembler.historialPrecio.dto;

import co.edu.uco.pathorder.bussinesslogic.assembler.DTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.assembler.producto.dto.ProductoDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HistorialPrecioDomain;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.dto.HistorialPrecioDTO;

import java.util.ArrayList;
import java.util.List;

public class HistorialPrecioDTOAssembler implements DTOAssembler<HistorialPrecioDTO, HistorialPrecioDomain> {

    private static final HistorialPrecioDTOAssembler INSTANCE = new HistorialPrecioDTOAssembler();

    private HistorialPrecioDTOAssembler() {
        super();
    }

    public static HistorialPrecioDTOAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public HistorialPrecioDTO toDTO(final HistorialPrecioDomain domain) {
        return UtilObjeto.getInstance().esNulo(domain)
                ? HistorialPrecioDTO.obtenerValorDefecto()
                : new HistorialPrecioDTO(
                domain.getId(),
                ProductoDTOAssembler.getInstance().toDTO(domain.getProducto()),
                domain.getPrecio(),
                domain.getFechaDesde(),
                domain.getFechaHasta()
        );
    }

    @Override
    public HistorialPrecioDomain toDomain(final HistorialPrecioDTO dto) {
        if (UtilObjeto.getInstance().esNulo(dto)) {
            return null;
        }

        return new HistorialPrecioDomain(
                dto.getId(),
                ProductoDTOAssembler.getInstance().toDomain(dto.getProducto()),
                dto.getPrecio(),
                dto.getFechaDesde(),
                dto.getFechaHasta()
        );
    }

    @Override
    public List<HistorialPrecioDTO> toDTOs(final List<HistorialPrecioDomain> domains) {
        if (UtilObjeto.getInstance().esNulo(domains) || domains.isEmpty()) {
            return new ArrayList<>();
        }

        List<HistorialPrecioDTO> dtos = new ArrayList<>();
        for (HistorialPrecioDomain domain : domains) {
            dtos.add(toDTO(domain));
        }

        return dtos;
    }

    @Override
    public List<HistorialPrecioDomain> toDomains(final List<HistorialPrecioDTO> dtos) {
        if (UtilObjeto.getInstance().esNulo(dtos) || dtos.isEmpty()) {
            return new ArrayList<>();
        }

        List<HistorialPrecioDomain> domains = new ArrayList<>();
        for (HistorialPrecioDTO dto : dtos) {
            HistorialPrecioDomain domain = toDomain(dto);
            if (domain != null) {
                domains.add(domain);
            }
        }

        return domains;
    }
}
