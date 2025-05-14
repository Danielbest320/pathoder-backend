package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.EstadoDTO;

import java.util.List;
import java.util.UUID;

public interface EstadoFacade {

    void registrarNuevoEstado(EstadoDTO estado);

    void modificarEstadoExistente(UUID id, EstadoDTO estado);

    void darbajaDefinitivamenteEstadoExistente(UUID id);

    EstadoDTO consultarEstadoPorId(UUID id);

    List<EstadoDTO> consultarEstados(EstadoDTO filtro);


}
