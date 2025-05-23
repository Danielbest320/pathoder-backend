package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HorarioLocalDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface HorarioLocalBusinessLogic {

    void registrarHorarioLocal(HorarioLocalDomain horarioLocal) throws PathOrderException;


    void modificarHorarioLocal(HorarioLocalDomain horarioLocal, UUID id) throws PathOrderException;

    List<HorarioLocalDomain> consultarDisponibilidadHorario(HorarioLocalDomain filtro) throws PathOrderException;
}
