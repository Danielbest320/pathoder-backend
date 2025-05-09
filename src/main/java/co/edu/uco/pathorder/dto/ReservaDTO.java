package co.edu.uco.pathorder.dto;

import java.util.UUID;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilNumerico;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;

public final class ReservaDTO {

    private UUID id;
    private ClienteDTO cliente;
    private int pin;
    private EstadoDTO estado;

    public ReservaDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setCliente(ClienteDTO.obtenerValorDefecto());
        setPin(UtilNumerico.getInstance().obtenerValorDefecto());
        setEstado(EstadoDTO.obtenerValorDefecto());
    }

    public ReservaDTO(final UUID id, final ClienteDTO cliente, final int pin, final EstadoDTO estado) {
        setId(id);
        setCliente(cliente);
        setPin(pin);
        setEstado(estado);
    }

    public ReservaDTO(final UUID id) {
        setId(id);
        setCliente(ClienteDTO.obtenerValorDefecto());
        setPin(UtilNumerico.getInstance().obtenerValorDefecto());
        setEstado(EstadoDTO.obtenerValorDefecto());
    }

    public static ReservaDTO obtenerValorDefecto() {
        return new ReservaDTO();
    }

    public static ReservaDTO obtenerValorDefecto(final ReservaDTO reserva) {
        return UtilObjeto.getInstance().obtenerValorDefecto(reserva, obtenerValorDefecto());
    }

    public UUID getId() {
        return id;
    }

    public ReservaDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public ReservaDTO setCliente(final ClienteDTO cliente) {
        this.cliente = ClienteDTO.obtenerValorDefecto(cliente);
        return this;
    }

    public int getPin() {
        return pin;
    }

    public ReservaDTO setPin(final int pin) {
        this.pin = UtilNumerico.getInstance().obtenerValorDefecto(pin);
        return this;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public ReservaDTO setEstado(final EstadoDTO estado) {
        this.estado = EstadoDTO.obtenerValorDefecto(estado);
        return this;
    }
}
