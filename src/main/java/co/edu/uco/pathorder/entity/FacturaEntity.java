package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.*;
import java.time.LocalDateTime;
import java.util.UUID;

public final class FacturaEntity {

    private UUID id;
    private AdministradorEntity administrador;
    private LocalDateTime fechaHora;
    private int total;

    public FacturaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setAdministrador(AdministradorEntity.obtenerValorDefecto());
        setFechaHora(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public FacturaEntity(final UUID id) {
        setId(id);
        setAdministrador(AdministradorEntity.obtenerValorDefecto());
        setFechaHora(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public FacturaEntity(final UUID id, final AdministradorEntity administrador, final LocalDateTime fechaHora, final int total) {
        setId(id);
        setAdministrador(administrador);
        setFechaHora(fechaHora);
        setTotal(total);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public AdministradorEntity getAdministrador() {
        return administrador;
    }

    public void setAdministrador(AdministradorEntity administrador) {
        this.administrador = AdministradorEntity.obtenerValorDefecto(administrador);
    }

    public LocalDateTime getFechaHora() {

        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = UtilFechaHora.getInstance().obtenerValorDefecto(fechaHora);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = UtilNumerico.getInstance().obtenerValorDefecto(total);
    }

    public static FacturaEntity obtenerValorDefecto() {
        return new FacturaEntity();
    }

    public static FacturaEntity obtenerValorDefecto(final FacturaEntity factura) {
        return UtilObjeto.getInstance().obtenerValorDefecto(factura, obtenerValorDefecto());
    }

}
