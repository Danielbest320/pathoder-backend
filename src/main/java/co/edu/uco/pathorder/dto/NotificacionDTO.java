package co.edu.uco.pathorder.dto;

import co.edu.uco.pathorder.crosscutting.utilitarios.*;
import co.edu.uco.pathorder.dto.ReservaDTO;
import co.edu.uco.pathorder.dto.TipoNotificacionDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public final class NotificacionDTO {

    private UUID id;
    private LocalDateTime fecha;
    private TipoNotificacionDTO tipoNotificacion;
    private ReservaDTO reserva;

    public NotificacionDTO(){
        setId(UtilUUID.obtenerValorDefecto());
        setFecha(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTipoNotificacion(TipoNotificacionDTO.obtenerValorDefecto());
        setReserva(ReservaDTO.obtenerValorDefecto());
    }

    public NotificacionDTO(final UUID id){
        setId(id);
        setFecha(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTipoNotificacion(TipoNotificacionDTO.obtenerValorDefecto());
        setReserva(ReservaDTO.obtenerValorDefecto());
    }

    public NotificacionDTO(final UUID id, final LocalDateTime fecha, final TipoNotificacionDTO tipoNotificacion, final ReservaDTO reserva) {
        setId(id);
        setFecha(fecha);
        setTipoNotificacion(tipoNotificacion);
        setReserva(reserva);
    }

    public UUID getId() {
        return id;
    }

    public NotificacionDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public NotificacionDTO setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public TipoNotificacionDTO getTipoNotificacion() {
        return tipoNotificacion;
    }

    public NotificacionDTO setTipoNotificacion(TipoNotificacionDTO tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
        return this;
    }

    public ReservaDTO getReserva() {
        return reserva;
    }

    public NotificacionDTO setReserva(ReservaDTO reserva) {
        this.reserva = reserva;
        return this;
    }

    public NotificacionDTO obtenerValorDefecto() {
        return new NotificacionDTO();
    }

    public NotificacionDTO obtenerValorDefecto(final NotificacionDTO notificacionDTO, final NotificacionDTO valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(notificacionDTO, obtenerValorDefecto());
    }
}
