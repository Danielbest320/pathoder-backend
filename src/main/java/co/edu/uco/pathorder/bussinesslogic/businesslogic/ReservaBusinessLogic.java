package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface ReservaBusinessLogic {

    void registrarReserva(ReservaDomain reserva) throws PathOrderException;

    void modificarReserva(UUID id, ReservaDomain reserva) throws PathOrderException;

    void eliminarReserva(UUID id) throws PathOrderException;

    List<ReservaDomain> consultarReserva(UUID id) throws PathOrderException;

    List<ReservaDomain> consultarReservas(ReservaDomain filtro) throws PathOrderException;
}
