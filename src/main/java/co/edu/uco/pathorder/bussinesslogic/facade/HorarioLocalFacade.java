package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.HorarioLocalDTO;

import java.util.List;
import java.util.UUID;

public interface HorarioLocalFacade {

    void registrarHorarioLocal(HorarioLocalDTO horarioLocal);


    void modificarHorarioLocal(HorarioLocalDTO horarioLocal, UUID id);

    List<HorarioLocalDTO> consultarDisponibilidadHorario(HorarioLocalDTO filtro);
}
