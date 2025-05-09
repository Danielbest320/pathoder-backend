package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFechaHora;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public class HorarioLocalEntity {

    private UUID id;
    private Boolean estadoLocal;
    private LocalDateTime horaDesde;
    private LocalDateTime horaHasta;


    public HorarioLocalEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setEstadoLocal(false);
        setHoraDesde(UtilFechaHora.getInstance().obtenerValorDefecto());
        setHoraHasta(UtilFechaHora.getInstance().obtenerValorDefecto());
    }

    public HorarioLocalEntity(final UUID id) {
        setId(id);
        setEstadoLocal(false);
        setHoraDesde(UtilFechaHora.getInstance().obtenerValorDefecto());
        setHoraHasta(UtilFechaHora.getInstance().obtenerValorDefecto());
    }

    public HorarioLocalEntity(final UUID id, final Boolean estadoLocal, final LocalDateTime horaDesde, final LocalDateTime horaHasta) {
        setId(id);
        setEstadoLocal(estadoLocal);
        setHoraDesde(horaDesde);
        setHoraHasta(horaHasta);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto();
    }

    public Boolean getEstadoLocal() {
        return estadoLocal;
    }

    public void setEstadoLocal(final Boolean estadoLocal) {
        this.estadoLocal = estadoLocal;
    }

    public LocalDateTime getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(final LocalDateTime horaDesde) {
        this.horaDesde = UtilFechaHora.getInstance().obtenerValorDefecto(horaDesde);
    }

    public LocalDateTime getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(final LocalDateTime horaHasta) {
        this.horaHasta = UtilFechaHora.getInstance().obtenerValorDefecto(horaHasta);
    }
}
