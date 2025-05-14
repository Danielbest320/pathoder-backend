package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFechaHora;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public class HorarioLocalDomain {

    private UUID id;
    private Boolean estadoLocal;
    private LocalDateTime horaDesde;
    private LocalDateTime horaHasta;


    HorarioLocalDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setEstadoLocal(false);
        setHoraDesde(UtilFechaHora.getInstance().obtenerValorDefecto());
        setHoraHasta(UtilFechaHora.getInstance().obtenerValorDefecto());
    }

    public HorarioLocalDomain(final UUID id) {
        setId(id);
        setEstadoLocal(false);
        setHoraDesde(UtilFechaHora.getInstance().obtenerValorDefecto());
        setHoraHasta(UtilFechaHora.getInstance().obtenerValorDefecto());
    }

    public HorarioLocalDomain(final UUID id, final Boolean estadoLocal, final LocalDateTime horaDesde, final LocalDateTime horaHasta) {
        setId(id);
        setEstadoLocal(estadoLocal);
        setHoraDesde(horaDesde);
        setHoraHasta(horaHasta);
    }

    static HorarioLocalDomain obtenerValorDefecto() {
        return new HorarioLocalDomain();
    }

    static HorarioLocalDomain obtenerValorDefecto(final HorarioLocalDomain horarioLocal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(horarioLocal, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public Boolean getEstadoLocal() {
        return estadoLocal;
    }

    private void setEstadoLocal(final Boolean estadoLocal) {
        this.estadoLocal = estadoLocal;
    }

    public LocalDateTime getHoraDesde() {
        return horaDesde;
    }

    private void setHoraDesde(final LocalDateTime horaDesde) {
        this.horaDesde = UtilFechaHora.getInstance().obtenerValorDefecto(horaDesde);
    }

    public LocalDateTime getHoraHasta() {
        return horaHasta;
    }

    private void setHoraHasta(final LocalDateTime horaHasta) {
        this.horaHasta = UtilFechaHora.getInstance().obtenerValorDefecto(horaHasta);
    }
}
