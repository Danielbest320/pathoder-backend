package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFechaHora;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public class HorarioLocalDTO {

    private UUID id;
    private Boolean estadoLocal;
    private LocalDateTime horaDesde;
    private LocalDateTime horaHasta;


    public HorarioLocalDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setEstadoLocal(false);
        setHoraDesde(UtilFechaHora.getInstance().obtenerValorDefecto());
        setHoraHasta(UtilFechaHora.getInstance().obtenerValorDefecto());
    }

    public HorarioLocalDTO(final UUID id) {
        setId(id);
        setEstadoLocal(false);
        setHoraDesde(UtilFechaHora.getInstance().obtenerValorDefecto());
        setHoraHasta(UtilFechaHora.getInstance().obtenerValorDefecto());
    }

    public HorarioLocalDTO(final UUID id, final Boolean estadoLocal, final LocalDateTime horaDesde, final LocalDateTime horaHasta) {
        setId(id);
        setEstadoLocal(estadoLocal);
        setHoraDesde(horaDesde);
        setHoraHasta(horaHasta);
    }

    public static HorarioLocalDTO obtenerValorDefecto() {
        return new HorarioLocalDTO();
    }

    public static HorarioLocalDTO obtenerValorDefecto(final HorarioLocalDTO horarioLocal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(horarioLocal, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public HorarioLocalDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto();
        return this;
    }

    public Boolean getEstadoLocal() {
        return estadoLocal;
    }

    public HorarioLocalDTO setEstadoLocal(final Boolean estadoLocal) {
        this.estadoLocal = estadoLocal;
        return this;
    }

    public LocalDateTime getHoraDesde() {
        return horaDesde;
    }

    public HorarioLocalDTO setHoraDesde(final LocalDateTime horaDesde) {
        this.horaDesde = UtilFechaHora.getInstance().obtenerValorDefecto(horaDesde);
        return this;
    }

    public LocalDateTime getHoraHasta() {
        return horaHasta;
    }

    public HorarioLocalDTO setHoraHasta(final LocalDateTime horaHasta) {
        this.horaHasta = UtilFechaHora.getInstance().obtenerValorDefecto(horaHasta);
        return this;
    }
}
