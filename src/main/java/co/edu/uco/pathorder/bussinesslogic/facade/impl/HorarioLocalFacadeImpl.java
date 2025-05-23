package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.HorarioLocalBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.HorarioLocalBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.HorarioLocalFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.HorarioLocalDTO;

import java.util.List;
import java.util.UUID;

public class HorarioLocalFacadeImpl implements HorarioLocalFacade {

    private DAOFactory daoFactory;
    private HorarioLocalBusinessLogic horarioLocalBusinessLogic;


    public HorarioLocalFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        horarioLocalBusinessLogic = new HorarioLocalBusinessLogicImpl(daoFactory);

    }

    @Override
    public void registrarHorarioLocal(HorarioLocalDTO horarioLocal) throws PathOrderException {

    }

    @Override
    public void modificarHorarioLocal(HorarioLocalDTO horarioLocal, UUID id) throws PathOrderException{

    }

    @Override
    public List<HorarioLocalDTO> consultarDisponibilidadHorario(HorarioLocalDTO filtro) throws PathOrderException{
        return List.of();
    }
}
