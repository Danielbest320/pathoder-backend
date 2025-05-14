package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HorarioLocalDomain;

import java.util.List;
import java.util.UUID;

public interface HorarioLocalBusinessLogic {

    void registrarHorarioLocal(HorarioLocalDomain horarioLocal);


    void modificarHorarioLocal(HorarioLocalDomain horarioLocal, UUID id);

    List<HorarioLocalDomain> consultarDisponibilidadHorario(HorarioLocalDomain filtro);
}
