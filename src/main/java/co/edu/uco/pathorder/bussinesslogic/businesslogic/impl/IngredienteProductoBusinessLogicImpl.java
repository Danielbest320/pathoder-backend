package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.IngredienteProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.IngredienteProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.IngredienteProductoEntity;

import java.util.List;
import java.util.UUID;

public class IngredienteProductoBusinessLogicImpl implements IngredienteProductoBusinessLogic {

    private final DAOFactory factory;

    public IngredienteProductoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void asignarIngredienteProducto(IngredienteProductoDomain ingredienteProducto) throws PathOrderException {
        IngredienteProductoEntity ingredienteProductoEntity = null;
        factory.getIngredienteProductoDAO().create(ingredienteProductoEntity);
    }

    @Override
    public void modificarCantidadIngrediente(IngredienteProductoDomain ingredienteProducto, UUID id) throws PathOrderException{
        IngredienteProductoEntity ingredienteProductoEntity = null;
        factory.getIngredienteProductoDAO().update(id, ingredienteProductoEntity);
    }

    @Override
    public void eliminarIngredienteProducto(UUID id) throws PathOrderException{
        factory.getIngredienteProductoDAO().delete(id);
    }

    @Override
    public List<IngredienteProductoDomain> consultarIngredientesProductos(IngredienteProductoDomain filtro) throws PathOrderException{
        IngredienteProductoEntity ingredienteProductoFilter = null;
        List<IngredienteProductoEntity> ingredienteProductoEntities = factory.getIngredienteProductoDAO().listByFilter(ingredienteProductoFilter);
        List<IngredienteProductoDomain> datosARetornar = null;

        return datosARetornar;
    }
}
