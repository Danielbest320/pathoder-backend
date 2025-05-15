package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain;


import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;

import java.util.UUID;

public class ReservaDomain {

    private UUID id;
    private ClienteDomain cliente;
    private int pin;
    private EstadoDomain estado;

    ReservaDomain() {
        setId(UUID.randomUUID());
        setCliente(ClienteDomain.obtenerValorDefecto());
        setPin(UtilNumerico.getInstance().obtenerValorDefecto());
        setEstado(EstadoDomain.obtenerValorDefecto());
    }

    public ReservaDomain(final UUID id) {
        setId(id);
        setCliente(ClienteDomain.obtenerValorDefecto());
        setPin(UtilNumerico.getInstance().obtenerValorDefecto());
        setEstado(EstadoDomain.obtenerValorDefecto());
    }

    public ReservaDomain(final UUID id, final ClienteDomain cliente, final int pin, final EstadoDomain estado) {
        setId(id);
        setCliente(cliente);
        setPin(pin);
        setEstado(estado);
    }

    static ReservaDomain obtenerValorDefecto() {
        return new ReservaDomain();
    }

    static ReservaDomain obtenerValorDefecto(final ReservaDomain reserva) {
        return UtilObjeto.getInstance().obtenerValorDefecto(reserva, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = UtilObjeto.getInstance().obtenerValorDefecto(id, UUID.randomUUID());
    }

    public ClienteDomain getCliente() {
        return cliente;
    }

    private void setCliente(ClienteDomain cliente) {
        this.cliente = UtilObjeto.getInstance().obtenerValorDefecto(cliente, ClienteDomain.obtenerValorDefecto());
    }

    public int getPin() {
        return pin;
    }

    private void setPin(int pin) {
        this.pin = UtilNumerico.getInstance().obtenerValorDefecto(pin);
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = EstadoDomain.obtenerValorDefecto(estado);
    }
}