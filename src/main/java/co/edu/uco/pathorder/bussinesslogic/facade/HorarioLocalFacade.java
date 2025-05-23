package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.HorarioLocalDTO;

import java.util.List;
import java.util.UUID;

public interface HorarioLocalFacade {

    void registrarHorarioLocal(HorarioLocalDTO horarioLocal) throws PathOrderException;


    void modificarHorarioLocal(HorarioLocalDTO horarioLocal, UUID id)throws PathOrderException ;

    List<HorarioLocalDTO> consultarDisponibilidadHorario(HorarioLocalDTO filtro) throws PathOrderException;
}
