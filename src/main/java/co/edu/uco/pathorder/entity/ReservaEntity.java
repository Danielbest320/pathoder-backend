package co.edu.uco.pathorder.entity;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;

import java.util.UUID;

public final class ReservaEntity {

    private UUID id;
    private ClienteEntity cliente;
    private int pin;
    private EstadoEntity estado;

    public ReservaEntity() {
        setId(UUID.randomUUID());
        setCliente(ClienteEntity.obtenerValorDefecto());
        setPin(UtilNumerico.getInstance().obtenerValorDefecto());
        setEstado(EstadoEntity.obtenerValorDefecto());
    }

    public ReservaEntity(final UUID id) {
        setId(id);
        setCliente(ClienteEntity.obtenerValorDefecto());
        setPin(UtilNumerico.getInstance().obtenerValorDefecto());
        setEstado(EstadoEntity.obtenerValorDefecto());
    }

    public  ReservaEntity(final UUID id,final ClienteEntity cliente,final int pin,final EstadoEntity estado) {
        setId(id);
        setCliente(cliente);
        setPin(pin);
        setEstado(estado);
    }

    public static ReservaEntity obtenerValorDefecto() {
        return new ReservaEntity();
    }

    public static ReservaEntity obtenerValorDefecto(final ReservaEntity reserva) {
        return UtilObjeto.getInstance().obtenerValorDefecto(reserva, obtenerValorDefecto());
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilObjeto.getInstance().obtenerValorDefecto(id, UUID.randomUUID());
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = UtilObjeto.getInstance().obtenerValorDefecto(cliente, ClienteEntity.obtenerValorDefecto());
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = UtilNumerico.getInstance().obtenerValorDefecto(pin);
    }

    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntity estado) {
        this.estado = EstadoEntity.obtenerValorDefecto(estado);
    }
}
