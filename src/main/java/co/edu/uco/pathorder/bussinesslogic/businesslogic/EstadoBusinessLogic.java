package co.edu.uco.pathorder.bussinesslogic.businesslogic;


import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;


public interface EstadoBusinessLogic {

    void registrarNuevoEstado(EstadoDomain estado) throws PathOrderException;

    void modificarEstadoExistente(UUID id, EstadoDomain estado) throws PathOrderException;

    void darbajaDefinitivamenteEstadoExistente(UUID id) throws PathOrderException;

    EstadoDomain consultarEstadoPorId(UUID id) throws PathOrderException;

    List<EstadoDomain> consultarEstados(EstadoDomain filtro) throws PathOrderException;
}
