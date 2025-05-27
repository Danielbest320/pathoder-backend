package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.tipoProducto.entity.TipoProductoEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoProductoBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoProductoDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.TipoProductoEntity;

import java.util.List;
import java.util.UUID;

public class TipoProductoBusinessLogicImpl implements TipoProductoBusinessLogic {

    private final DAOFactory factory;

    public TipoProductoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearTipoProductoPredeterminado(TipoProductoDomain tipoProducto) throws PathOrderException {
        // 1. Validar integridad de la información
        validarIntegridad(tipoProducto);

        // 2. Validar que no exista un tipo de producto con el mismo nombre
        validarDuplicados(tipoProducto);

        // 3. Generar un identificador único para el nuevo tipo de producto
        UUID nuevoId = generarIdentificadorNuevoTipoProducto();

        // 4. Recrear el domain con el nuevo id
        TipoProductoDomain tipoProductoACrear = new TipoProductoDomain(nuevoId, tipoProducto.getNombre());

        // 5. Crear el tipo de producto en la base de datos
        TipoProductoEntity tipoProductoEntity = TipoProductoEntityAssembler.getInstance().toEntity(tipoProductoACrear);
        factory.getTipoProductoDAO().create(tipoProductoEntity);
    }

    public List<TipoProductoDomain> consultarTipoProductos(TipoProductoDomain filtro) throws PathOrderException {
        var tieneFiltros = filtro != null && !UtilUUID.esValorDefecto(filtro.getId())
                || !UtilTexto.getInstance().esValorDefecto(filtro.getNombre());

        List<TipoProductoEntity> entidades = tieneFiltros
                ? factory.getTipoProductoDAO().listByFilter(TipoProductoEntityAssembler.getInstance().toEntity(filtro))
                : factory.getTipoProductoDAO().listAll();

        return TipoProductoEntityAssembler.getInstance().toDomains(entidades);
    }

    private void validarIntegridad(TipoProductoDomain tipoProducto) throws  PathOrderException {
        if (tipoProducto == null) {
            throw BusinessLogicPathOrderException.reportar("El tipo de producto no puede ser nulo.");
        }

        if (UtilTexto.getInstance().esValorDefecto(tipoProducto.getNombre())){
            throw BusinessLogicPathOrderException.reportar("El nombre del tipo de producto es obligatorio.");
        }
    }

    private void validarDuplicados(TipoProductoDomain tipoProducto) throws  PathOrderException {
        var filtro = new TipoProductoDomain(null, tipoProducto.getNombre());
        var existentes = factory.getTipoProductoDAO().listByFilter(TipoProductoEntityAssembler.getInstance().toEntity(filtro));

        if (!existentes.isEmpty()) {
            throw BusinessLogicPathOrderException.reportar("Ya existe un tipo de producto con ese nombre.");
        }
    }

    private UUID generarIdentificadorNuevoTipoProducto() throws PathOrderException {

        UUID nuevoId;
        var existeId = false;

        do {
            nuevoId = UtilUUID.generarNuevoUUID();
            var categoria = factory.getTipoProductoDAO().listById(nuevoId);
            existeId = !UtilUUID.esValorDefecto(categoria.getId());

        } while (existeId);

        return nuevoId;
    }
}
