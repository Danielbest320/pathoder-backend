package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaDomain;

import java.util.List;
import java.util.UUID;

public interface ReservaBusinessLogic {

    void registrarReserva(ReservaDomain reserva);

    void modificarReserva(UUID id, ReservaDomain reserva);

    void eliminarReserva(UUID id);

    List<ReservaDomain> consultarReserva(UUID id);

    List<ReservaDomain> consultarReservas(ReservaDomain filtro);
}
