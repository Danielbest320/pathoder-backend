package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.ReservaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaDomain;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.ReservaEntity;

import java.util.List;
import java.util.UUID;

public class ReservaBusinessLogicImpl implements ReservaBusinessLogic {

    private final DAOFactory factory;

    public ReservaBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }


    @Override
    public void registrarReserva(ReservaDomain reserva) {
        ReservaEntity reservaEntity = null;
        factory.getReservaDAO().create(reservaEntity);


    }

    @Override
    public void modificarReserva(UUID id, ReservaDomain reserva) {
        ReservaEntity reservaEntity = null;
        factory.getReservaDAO().update(id,reservaEntity);



    }

    @Override
    public void eliminarReserva(UUID id) {
        factory.getReservaDAO().delete(id);

    }

    @Override
    public List<ReservaDomain> consultarReserva(UUID id) {
        return null;
    }


    @Override
    public List<ReservaDomain> consultarReservas(ReservaDomain filtro) {
        ReservaEntity reservaFilter = null;
        List<ReservaEntity> reservaEntities = factory.getReservaDAO().listByFilter(reservaFilter);
        List<ReservaDomain> datosARetornar = null;

        return datosARetornar;
    }
}
