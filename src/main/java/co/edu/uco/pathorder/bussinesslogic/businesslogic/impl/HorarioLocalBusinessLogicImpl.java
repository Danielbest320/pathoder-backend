package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.horarioLocal.entity.HorarioLocalEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.HorarioLocalBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HorarioLocalDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.HorarioLocalEntity;

import java.util.List;
import java.util.UUID;

public class HorarioLocalBusinessLogicImpl implements HorarioLocalBusinessLogic {

    private final DAOFactory factory;

    public HorarioLocalBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarHorarioLocal(HorarioLocalDomain horarioLocal) throws PathOrderException {
        HorarioLocalEntity horarioLocalEntity = HorarioLocalEntityAssembler.getInstance().toEntity(horarioLocal);
        factory.getHorarioLocalDAO().create(horarioLocalEntity);
    }

    @Override
    public void modificarHorarioLocal(HorarioLocalDomain horarioLocal, UUID id) throws PathOrderException{
        HorarioLocalEntity horarioLocalEntity =HorarioLocalEntityAssembler.getInstance().toEntity(horarioLocal);
        factory.getHorarioLocalDAO().update(id, horarioLocalEntity);
    }

    @Override
    public List<HorarioLocalDomain> consultarDisponibilidadHorario(HorarioLocalDomain filtro) throws PathOrderException{
        HorarioLocalEntity horarioLocalFilter = HorarioLocalEntityAssembler.getInstance().toEntity(filtro);
        List<HorarioLocalEntity> horarioLocalEntities = factory.getHorarioLocalDAO().listByFilter(horarioLocalFilter);
        List<HorarioLocalDomain> datosARetornar = HorarioLocalEntityAssembler.getInstance().toDomains(horarioLocalEntities);

        return datosARetornar;
    }
}
