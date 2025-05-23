package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.IngredienteProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.IngredienteProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.IngredienteProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.IngredienteProductoDTO;

import java.util.List;
import java.util.UUID;

public class IngredienteProductoFacadeImpl implements IngredienteProductoFacade {

    private DAOFactory daoFactory;
    private IngredienteProductoBusinessLogic ingredienteProductoBusinessLogic;


    public IngredienteProductoFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        ingredienteProductoBusinessLogic = new IngredienteProductoBusinessLogicImpl(daoFactory);

    }

    @Override
    public void asignarIngredienteProducto(IngredienteProductoDTO ingredienteProducto) throws PathOrderException {

    }

    @Override
    public void modificarCantidadIngrediente(IngredienteProductoDTO ingredienteProducto, UUID id) throws PathOrderException {

    }

    @Override
    public void eliminarIngredienteProducto(UUID id) throws PathOrderException {

    }

    @Override
    public List<IngredienteProductoDTO> consultarIngredientesProductos(IngredienteProductoDTO filtro) throws PathOrderException {
        return List.of();
    }
}
