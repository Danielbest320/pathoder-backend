package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.ReservaProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ReservaProductoBusinessLogicImpl implements ReservaProductoBusinessLogic {

    private DAOFactory factory;

    public ReservaProductoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearReservaProducto(ReservaProductoDomain reservaProducto) throws PathOrderException {
        ReservaProductoEntity reservaProductoEntity = new ReservaProductoEntity();
        factory.getReservaProductoDAO().create(reservaProductoEntity);
    }

    @Override
    public void eliminarReservaProducto(UUID id) throws PathOrderException {
            factory.getReservaProductoDAO().delete(id);
    }

    @Override
    public void modificarReservaProducto(ReservaProductoDomain reservaProducto, UUID id) throws PathOrderException {
        ReservaProductoEntity reservaProductoEntity = new ReservaProductoEntity();
        factory.getReservaProductoDAO().update(id,reservaProductoEntity);
    }

    @Override
    public List<ReservaProductoDomain> consultarReservaProducto(ReservaProductoDomain filtro) throws PathOrderException {
        ReservaProductoEntity reservaProductoEntity = new ReservaProductoEntity();

        List<ReservaProductoEntity> reservaProductoEntities = factory.getReservaProductoDAO().listByFilter(reservaProductoEntity);
        List<ReservaProductoDomain> datosARetornar = null;
        return datosARetornar;
    }
}
