package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.ProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.util.List;
import java.util.UUID;

public class ProductoBusinessLogicImpl implements ProductoBusinessLogic {

    private final DAOFactory factory;

    public ProductoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarProducto(ProductoDomain producto) {
        ProductoEntity productoEntity = null;
        factory.getProductoDAO().create(productoEntity);
    }

    @Override
    public void modificarProducto(UUID id, ProductoDomain producto) {
        ProductoEntity productoEntity = null;
        factory.getProductoDAO().update(id, productoEntity);
    }

    @Override
    public void eliminarProducto(UUID id) {
        factory.getProductoDAO().delete(id);
    }

    @Override
    public List<ProductoDomain> consultarProducto(ProductoDomain filtro) {
        return List.of();
    }

    @Override
    public List<ProductoDomain> consultarProductoDisponible(ProductoDomain filtro) {
        ProductoEntity productoFilter = null;
        List<ProductoEntity> productoEntities = factory.getProductoDAO().listByFilter(productoFilter);
        List<ProductoDomain> datosARetornar = null;

        return datosARetornar;
    }
}
