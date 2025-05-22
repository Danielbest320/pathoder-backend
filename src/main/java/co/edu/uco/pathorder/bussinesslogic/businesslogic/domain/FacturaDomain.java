package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilFechaHora;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public class FacturaDomain {

    private UUID id;
    private AdministradorDomain administrador;
    private LocalDateTime fechaHora;
    private int total;

    FacturaDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setAdministrador(AdministradorDomain.obtenerValorDefecto());
        setFechaHora(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public FacturaDomain(final UUID id) {
        setId(id);
        setAdministrador(AdministradorDomain.obtenerValorDefecto());
        setFechaHora(UtilFechaHora.getInstance().obtenerValorDefecto());
        setTotal(UtilNumerico.getInstance().obtenerValorDefecto());
    }

    public FacturaDomain(final UUID id, final AdministradorDomain administrador, final LocalDateTime fechaHora, final int total) {
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

    public AdministradorDomain getAdministrador() {
        return administrador;
    }

    public void setAdministrador(AdministradorDomain administrador) {
        this.administrador = AdministradorDomain.obtenerValorDefecto(administrador);
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

    static FacturaDomain obtenerValorDefecto() {
        return new FacturaDomain();
    }

    static FacturaDomain obtenerValorDefecto(final FacturaDomain factura) {
        return UtilObjeto.getInstance().obtenerValorDefecto(factura, obtenerValorDefecto());
    }

}
