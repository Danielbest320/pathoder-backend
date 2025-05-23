package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.TipoProductoEntity;

import java.util.List;

public class TipoProductoBusinessLogicImpl implements TipoProductoBusinessLogic {

    private final DAOFactory factory;

    public TipoProductoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearTipoProductoPredeterminado(TipoProductoDomain tipoProducto) throws PathOrderException {
        TipoProductoEntity tipoProductoEntity = null;
        factory.getTipoProductoDAO().create(tipoProductoEntity);
    }

    @Override
    public List<TipoProductoDomain> consultarTipoProductos(TipoProductoDomain filtro) throws PathOrderException {
        TipoProductoEntity tipoProductoFilter = null;
        List<TipoProductoEntity> tipoProductoEntities = factory.getTipoProductoDAO().listByFilter(tipoProductoFilter);
        List<TipoProductoDomain> datosARetornar = null;

        return datosARetornar;
    }
}
