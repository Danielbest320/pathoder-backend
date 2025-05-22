package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFechaHora;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificacionDomain  {

    private UUID id;
    private LocalDateTime fecha;
    private TipoNotificacionDomain tipoNotificacion;
    private ReservaDomain reserva;

    NotificacionDomain(){
        setId(UtilUUID.obtenerValorDefecto());
        setFecha(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTipoNotificacion(TipoNotificacionDomain.obtenerValorDefecto());
        setReserva(ReservaDomain.obtenerValorDefecto());
    }

    public NotificacionDomain(final UUID id){
        setId(id);
        setFecha(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTipoNotificacion(TipoNotificacionDomain.obtenerValorDefecto());
        setReserva(ReservaDomain.obtenerValorDefecto());
    }

    public NotificacionDomain(final UUID id, final LocalDateTime fecha, final TipoNotificacionDomain tipoNotificacion, final ReservaDomain reserva) {
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

    public TipoNotificacionDomain getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacionDomain tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public ReservaDomain getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDomain reserva) {
        this.reserva = reserva;
    }

    static NotificacionDomain obtenerValorDefecto() {
        return new NotificacionDomain();
    }

    static NotificacionDomain obtenerValorDefecto(final NotificacionDomain notificacionDomain, final NotificacionDomain valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(notificacionDomain, obtenerValorDefecto());
    }


}
