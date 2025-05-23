package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.CategoriaEntity;

import java.util.List;
import java.util.UUID;

public class CategoriaBusinessLogicImpl implements CategoriaBusinessLogic {

    private final DAOFactory factory;

    public CategoriaBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearNuevaCategoria(CategoriaDomain categoria) throws PathOrderException {
        CategoriaEntity categoriaEntity = null;
        factory.getCategoriaDAO().create(categoriaEntity);
    }

    @Override
    public void modificarCategoriaExistente(UUID id, CategoriaDomain categoria) throws PathOrderException {
        CategoriaEntity categoriaEntity = null;
        factory.getCategoriaDAO().update(id,categoriaEntity);
    }

    @Override
    public void eliminarUnaCategoria(UUID id) throws PathOrderException {
        factory.getCategoriaDAO().delete(id);
    }

    @Override
    public List<CategoriaDomain> consultarCategoriaDisponibles(CategoriaDomain filtro) throws PathOrderException {
        CategoriaEntity categoriaFilter = null;
        List<CategoriaEntity> categoriaEntities = factory.getCategoriaDAO().listByFilter(categoriaFilter);
        List<CategoriaDomain> datosARetornar = null;

        return datosARetornar;
    }

    @Override
    public List<CategoriaDomain> consultarCategoriaExistentes(CategoriaDomain filtro) throws PathOrderException{
        CategoriaEntity categoriaFilter = null;
        List<CategoriaEntity> categoriaEntities = factory.getCategoriaDAO().listByFilter(categoriaFilter);
        List<CategoriaDomain> datosARetornar = null;

        return datosARetornar;
    }
}
