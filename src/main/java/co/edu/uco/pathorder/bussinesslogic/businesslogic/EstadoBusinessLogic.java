package co.edu.uco.pathorder.bussinesslogic.businesslogic;


import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.EstadoDomain;

import java.util.List;
import java.util.UUID;


public interface EstadoBusinessLogic {

    void registrarNuevoEstado(EstadoDomain estado);

    void modificarEstadoExistente(UUID id, EstadoDomain estado);

    void darbajaDefinitivamenteEstadoExistente(UUID id);

    EstadoDomain consultarEstadoPorId(UUID id);

    List<EstadoDomain> consultarEstados(EstadoDomain filtro);
}
