package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.EstadoDTO;

import java.util.List;
import java.util.UUID;

public interface EstadoFacade {

    void registrarNuevoEstado(EstadoDTO estado) throws PathOrderException;

    void modificarEstadoExistente(UUID id, EstadoDTO estado) throws PathOrderException;

    void darbajaDefinitivamenteEstadoExistente(UUID id) throws PathOrderException;

    EstadoDTO consultarEstadoPorId(UUID id) throws PathOrderException;

    List<EstadoDTO> consultarEstados(EstadoDTO filtro) throws PathOrderException;


}
