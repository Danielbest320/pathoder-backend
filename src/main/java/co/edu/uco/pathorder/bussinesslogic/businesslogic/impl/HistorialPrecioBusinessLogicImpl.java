package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.historialPrecio.entity.HistorialPrecioEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.HistorialPrecioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HistorialPrecioDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.HistorialPrecioEntity;

import java.util.List;

public class HistorialPrecioBusinessLogicImpl implements HistorialPrecioBusinessLogic {

    private final DAOFactory factory;

    public HistorialPrecioBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoPrecioHistorial(HistorialPrecioDomain historialPrecio) throws PathOrderException  {
        HistorialPrecioEntity historialPrecioEntity = HistorialPrecioEntityAssembler.getInstance().toEntity(historialPrecio);
        factory.getHistorialPrecioDAO().create(historialPrecioEntity);
    }

    @Override
    public List<HistorialPrecioDomain> consultarHistorialPrecioProducto(HistorialPrecioDomain filtro) throws PathOrderException{
        HistorialPrecioEntity historialPrecioFilter = HistorialPrecioEntityAssembler.getInstance().toEntity(filtro);
        List<HistorialPrecioEntity> historialPrecioEntities = factory.getHistorialPrecioDAO().listByFilter(historialPrecioFilter);
        List<HistorialPrecioDomain> datosARetornar = HistorialPrecioEntityAssembler.getInstance().toDomains(historialPrecioEntities);

        return datosARetornar;
    }
}
