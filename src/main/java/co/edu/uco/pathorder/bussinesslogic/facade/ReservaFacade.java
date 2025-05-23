package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.ReservaDTO;

import java.util.List;
import java.util.UUID;

public interface ReservaFacade {
    void registrarReserva(ReservaDTO reserva) throws PathOrderException;

    void modificarReserva(UUID id, ReservaDTO reserva) throws PathOrderException;

    void eliminarReserva(UUID id) throws PathOrderException;

    List<ReservaDTO> consultarReserva(UUID id) throws PathOrderException;

    List<ReservaDTO> consultarReservas(ReservaDTO filtro) throws PathOrderException;




}
