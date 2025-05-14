package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaDomain;
import co.edu.uco.pathorder.dto.ReservaDTO;

import java.util.List;
import java.util.UUID;

public interface ReservaFacade {
    void registrarReserva(ReservaDTO reserva);

    void modificarReserva(UUID id, ReservaDTO reserva);

    void eliminarReserva(UUID id);

    List<ReservaDTO> consultarReserva(UUID id);

    List<ReservaDTO> consultarReservas(ReservaDTO filtro);




}
