package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.ProductoBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.ProductoFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.ProductoDTO;

import java.util.List;
import java.util.UUID;

public class ProductoFacadeImpl implements ProductoFacade {

    private DAOFactory daoFactory;
    private ProductoBusinessLogic productoBusinessLogic;


    public ProductoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        productoBusinessLogic = new ProductoBusinessLogicImpl(daoFactory);

    }

    @Override
    public void registrarProducto(ProductoDTO producto) {

    }

    @Override
    public void modificarProducto(UUID id, ProductoDTO producto) {

    }

    @Override
    public void eliminarProducto(UUID id) {

    }

    @Override
    public List<ProductoDTO> consultarProducto(ProductoDTO filtro) {
        return List.of();
    }

    @Override
    public List<ProductoDTO> consultarProductoDisponible(ProductoDTO filtro) {
        return List.of();
    }
}
