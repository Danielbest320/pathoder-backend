package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFecha;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public final class FacturaEntity {

    private UUID id;
    private AdministradorEntity administrador;
    private LocalDateTime fecha;
    private int total;

    public FacturaEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setAdministrador(AdministradorEntity.obtenerValorDefecto());
        setFecha(UtilFecha.getInstance().obtenerValorDefecto());
        setTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public FacturaEntity(final UUID id) {
        setId(id);
        setAdministrador(AdministradorEntity.obtenerValorDefecto());
        setFecha(UtilFecha.getInstance().obtenerValorDefecto());
        setTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public FacturaEntity(final UUID id, final AdministradorEntity administrador, final LocalDateTime fecha, final int total) {
        setId(id);
        setAdministrador(administrador);
        setFecha(fecha);
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = UtilFecha.getInstance().obtenerValorDefecto(fecha);
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
