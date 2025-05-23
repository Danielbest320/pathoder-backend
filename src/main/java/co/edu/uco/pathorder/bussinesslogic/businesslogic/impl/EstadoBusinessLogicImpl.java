package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.EstadoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.EstadoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.EstadoEntity;

import java.util.List;
import java.util.UUID;

public class EstadoBusinessLogicImpl implements EstadoBusinessLogic {

    private final DAOFactory factory;

    public EstadoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoEstado(EstadoDomain estado) throws PathOrderException {
        EstadoEntity estadoEntity = null;
        factory.getEstadoDAO().create(estadoEntity);
    }

    @Override
    public void modificarEstadoExistente(UUID id, EstadoDomain estado) throws PathOrderException {
        EstadoEntity estadoEntity = null;
        factory.getEstadoDAO().update(id, estadoEntity);
    }

    @Override
    public void darbajaDefinitivamenteEstadoExistente(UUID id) throws PathOrderException {
        factory.getEstadoDAO().delete(id);
    }

    @Override
    public EstadoDomain consultarEstadoPorId(UUID id) throws PathOrderException {
        return null;
    }

    @Override
    public List<EstadoDomain> consultarEstados(EstadoDomain filtro) throws PathOrderException {
        EstadoEntity estadoFilter = null;
        List<EstadoEntity> estadoEntities = factory.getEstadoDAO().listByFilter(estadoFilter);
        List<EstadoDomain> datosARetornar = null;
        return datosARetornar;
    }

}
