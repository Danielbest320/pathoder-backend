package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.*;
import co.edu.uco.pathorder.dto.AdministradorDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public final class FacturaDTO {

    private UUID id;
    private AdministradorDTO administrador;
    private LocalDateTime fechaHora;
    private int total;

    public FacturaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setAdministrador(AdministradorDTO.obtenerValorDefecto());
        setFechaHora(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTotal(UtilPrecio.getInstance().obtenerValorDefecto());
    }

    public FacturaDTO(final UUID id) {
        setId(id);
        setAdministrador(AdministradorDTO.obtenerValorDefecto());
        setFechaHora(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTotal(UtilPrecio.getInstance().obtenerValorDefecto());
    }

    public FacturaDTO(final UUID id, final AdministradorDTO administrador, final LocalDateTime fechaHora, final int total) {
        setId(id);
        setAdministrador(administrador);
        setFechaHora(fechaHora);
        setTotal(total);
    }

    public UUID getId() {
        return id;
    }

    public FacturaDTO setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public AdministradorDTO getAdministrador() {
        return administrador;
    }

    public FacturaDTO setAdministrador(AdministradorDTO administrador) {
        this.administrador = AdministradorDTO.obtenerValorDefecto(administrador);
        return this;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public FacturaDTO setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = UtilFechaHora.getInstance().obtenerValorDefecto(fechaHora);
        return this;
    }

    public int getTotal() {
        return total;
    }

    public FacturaDTO setTotal(int total) {
        this.total = UtilPrecio.getInstance().obtenerValorDefecto(total);
        return this;
    }

    public static FacturaDTO obtenerValorDefecto() {
        return new FacturaDTO();
    }

    public static FacturaDTO obtenerValorDefecto(final FacturaDTO factura) {
        return UtilObjeto.getInstance().obtenerValorDefecto(factura, obtenerValorDefecto());
    }

}
