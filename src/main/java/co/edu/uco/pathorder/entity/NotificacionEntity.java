package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFechaHora;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class NotificacionEntity {

    private UUID id;
    private LocalDateTime fecha;
    private TipoNotificacionEntity tipoNotificacion;
    private Reserva reserva;

    public NotificacionEntity(){
        setId(UtilUUID.obtenerValorDefecto());
        setFecha(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTipoNotificacion(TipoNotificacionEntity.obtenerValorDefecto());
        setReserva(Reserva.obtenerValorDefecto());
    }

    public NotificacionEntity(final UUID id){
        setId(id);
        setFecha(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTipoNotificacion(TipoNotificacionEntity.obtenerValorDefecto());
        setReserva(Reserva.obtenerValorDefecto());
    }

    public NotificacionEntity(final UUID id, final LocalDateTime fecha, final TipoNotificacionEntity tipoNotificacion, final Reserva reserva) {
        setId(id);
        setFecha(fecha);
        setTipoNotificacion(tipoNotificacion);
        setReserva(reserva);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoNotificacionEntity getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacionEntity tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public NotificacionEntity obtenerValorDefecto() {
        return new NotificacionEntity();
    }

    public NotificacionEntity obtenerValorDefecto(final NotificacionEntity notificacionEntity, final NotificacionEntity valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(notificacionEntity, obtenerValorDefecto());
    }
}
