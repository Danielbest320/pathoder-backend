package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.reservaproducto.entity.ReservaProductoEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.ReservaProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ProductoDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.ReservaProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
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

        validarIntegridadInformacionReservaProducto(reservaProducto);

        var id = generarId();

        reservaProducto.setId(id);
        ReservaProductoDomain reservaProductoFinal = new ReservaProductoDomain(
                reservaProducto.getId(),
                reservaProducto.getReserva(),
                reservaProducto.getProducto(),
                reservaProducto.getCantidad()
        );

        ReservaProductoEntity reservaProductoEntity = ReservaProductoEntityAssembler.getInstance().toEntity(reservaProductoFinal);
        factory.getReservaProductoDAO().create(reservaProductoEntity);
    }

    @Override
    public void eliminarReservaProducto(UUID id) throws PathOrderException {
            factory.getReservaProductoDAO().delete(id);
    }

    @Override
    public void modificarReservaProducto(ReservaProductoDomain reservaProducto, UUID id) throws PathOrderException {
        ReservaProductoEntity reservaProductoEntity = ReservaProductoEntityAssembler.getInstance().toEntity(reservaProducto);
        factory.getReservaProductoDAO().update(id, reservaProductoEntity);
    }

    @Override
    public List<ReservaProductoDomain> consultarReservaProducto(ReservaProductoDomain filtro) throws PathOrderException {
        ReservaProductoEntity reservaProductoEntity = ReservaProductoEntityAssembler.getInstance().toEntity(filtro);
        List<ReservaProductoEntity> reservaProductoEntities = factory.getReservaProductoDAO().listByFilter(reservaProductoEntity);
        return ReservaProductoEntityAssembler.getInstance().toDomains(reservaProductoEntities);
    }

    private UUID generarId() throws PathOrderException {
        UUID id;
        boolean existeId;
        do {
            id = UtilUUID.generarNuevoUUID();
            var reservaProducto = factory.getReservaProductoDAO().listById(id);
            existeId = !UtilUUID.esValorDefecto(reservaProducto.getId());
        } while (existeId);

        return id;
    }

    private void validarReserva(ReservaDomain reserva) throws PathOrderException {
        if (UtilObjeto.getInstance().esNulo(reserva)) {
            throw BusinessLogicPathOrderException.reportar("La reserva es obligatoria");
        }
    }

    private void validarCantidadReservaProducto(int cantidad) throws PathOrderException {
        if (!(cantidad >= 1 && cantidad <= 2000)) {
            throw BusinessLogicPathOrderException.reportar("La cantidad de la reserva del producto debe ser mayor a cero y menor o igual a 2000");
        }
    }

    private void validarProductoReservaProducto(ProductoDomain producto) throws PathOrderException {
        if ((UtilObjeto.getInstance().esNulo(producto))) {
            throw BusinessLogicPathOrderException.reportar("El producto de la reserva es obligatorio");
        }
    }

    private void validarIntegridadInformacionReservaProducto(ReservaProductoDomain reservaProducto) throws PathOrderException {
        validarReserva(reservaProducto.getReserva());
        validarCantidadReservaProducto(reservaProducto.getCantidad());
        validarProductoReservaProducto(reservaProducto.getProducto());
    }
}
