package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.CategoriaBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.CategoriaFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.CategoriaDTO;

import java.util.List;
import java.util.UUID;

public class CategoriaFacadeImpl implements CategoriaFacade {

    private DAOFactory daoFactory;
    private CategoriaBusinessLogic categoriaBusinessLogic;


    public CategoriaFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        categoriaBusinessLogic = new CategoriaBusinessLogicImpl(daoFactory);

    }


    @Override
    public void crearNuevaCategoria(CategoriaDTO categoria) throws PathOrderException{

    }

    @Override
    public void modificarCategoriaExistente(UUID id, CategoriaDTO categoria)throws PathOrderException {

    }

    @Override
    public void eliminarUnaCategoria(UUID id) throws PathOrderException{

    }

    @Override
    public List<CategoriaDTO> consultarCategoriaDisponibles(CategoriaDTO filtro) throws PathOrderException{
        return List.of();
    }

    @Override
    public List<CategoriaDTO> consultarCategoriaExistentes(CategoriaDTO filtro) throws PathOrderException {
        return List.of();
    }
}
