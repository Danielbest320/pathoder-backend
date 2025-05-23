package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.EstadoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.EstadoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.EstadoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.EstadoDTO;

import java.util.List;
import java.util.UUID;

public class EstadoFacadeImpl implements EstadoFacade {

    private DAOFactory daoFactory;
    private EstadoBusinessLogic estadoBusinessLogic;


    public EstadoFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        estadoBusinessLogic = new EstadoBusinessLogicImpl(daoFactory);

    }

    @Override
    public void registrarNuevoEstado(EstadoDTO estado) throws PathOrderException {

    }

    @Override
    public void modificarEstadoExistente(UUID id, EstadoDTO estado) throws PathOrderException {

    }

    @Override
    public void darbajaDefinitivamenteEstadoExistente(UUID id) throws PathOrderException {

    }

    @Override
    public EstadoDTO consultarEstadoPorId(UUID id) throws PathOrderException {
        return null;
    }

    @Override
    public List<EstadoDTO> consultarEstados(EstadoDTO filtro) throws PathOrderException {
        return List.of();
    }
}
