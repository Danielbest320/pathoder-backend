package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.InventarioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.InventarioDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.InventarioEntity;

import java.util.List;
import java.util.UUID;

public class InventarioBusinessLogicImpl implements InventarioBusinessLogic {

    private final DAOFactory factory;

    public InventarioBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearInventario(InventarioDomain inventario) throws PathOrderException {
        InventarioEntity inventarioEntity = null;
        factory.getInventarioDAO().create(inventarioEntity);
    }

    @Override
    public void actualizarInventario(InventarioDomain inventario, UUID id) throws PathOrderException{
        InventarioEntity inventarioEntity = null;
        factory.getInventarioDAO().update(id, inventarioEntity);
    }

    @Override
    public void actualizarInventarioMomentoReserva(InventarioDomain inventario, UUID id) throws PathOrderException {
        InventarioEntity inventarioEntity = null;
        factory.getInventarioDAO().update(id, inventarioEntity);
    }

    @Override
    public void eliminarInventario(UUID id) throws PathOrderException {
        factory.getInventarioDAO().delete(id);
    }

    @Override
    public List<InventarioDomain> consultarInventario(InventarioDomain filtro) throws PathOrderException {
        InventarioEntity inventarioFilter = null;
        List<InventarioEntity> inventarioEntities = factory.getInventarioDAO().listByFilter(inventarioFilter);
        List<InventarioDomain> datosARetornar = null;

        return datosARetornar;
    }
}
