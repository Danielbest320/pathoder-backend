package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.tiponotificacion.entity.TipoNotificacionEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.TipoNotificacionBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.TipoNotificacionDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;

import java.util.List;
import java.util.UUID;

public class TipoNotificacionBusinessLogicImpl implements TipoNotificacionBusinessLogic {

    private final DAOFactory factory;

    public TipoNotificacionBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearTiposNotificacion(TipoNotificacionDomain tipoNotificacion) throws PathOrderException {
        validarIntegridadInformacionTipoNotificacion(tipoNotificacion);
        validarValorUnicoNombre(tipoNotificacion.getNombre());

        var id = generarIdTipoNotificacion();

        tipoNotificacion.setId(id);

        TipoNotificacionEntity tipoNotificacionEntity = TipoNotificacionEntityAssembler.getInstance().toEntity(tipoNotificacion);
        factory.getTipoNotificacionDAO().create(tipoNotificacionEntity);
    }

    @Override
    public List<TipoNotificacionDomain> consultarTiposNotificacion(TipoNotificacionDomain filtro) throws PathOrderException {
        TipoNotificacionEntity tipoNotificacionEntity = TipoNotificacionEntityAssembler.getInstance().toEntity(filtro);
        List<TipoNotificacionEntity> tipoNotificacionEntities = factory.getTipoNotificacionDAO().listByFilter(tipoNotificacionEntity);
        return TipoNotificacionEntityAssembler.getInstance().toDomains(tipoNotificacionEntities);
    }

    private void validarValorUnicoNombre(String nombre) throws  PathOrderException {
        var tipoNotificacionEntity = new TipoNotificacionEntity();
        tipoNotificacionEntity.setNombre(nombre);

        List<TipoNotificacionEntity> resultados = factory.getTipoNotificacionDAO().listByFilter(tipoNotificacionEntity);

        if (!resultados.isEmpty()) {
            throw BusinessLogicPathOrderException.reportar("El nombre del tipo de notificación ya existe en el sistema");
        }
    }

    private UUID generarIdTipoNotificacion() throws PathOrderException {
        UUID id;
        boolean existeId;
        do {
            id = UtilUUID.generarNuevoUUID();
            var tipoNotificacion = factory.getTipoNotificacionDAO().listById(id); tipoNotificacion.getId();
            existeId = !UtilUUID.esValorDefecto(id);
        } while (!existeId);

        return id;
    }

    private void validarIntegridadInformacionTipoNotificacion(TipoNotificacionDomain tipoNotificacion) throws PathOrderException {
        validarNombre(tipoNotificacion.getNombre());
        validarMensaje(tipoNotificacion.getMensaje());
        validarDescripcion(tipoNotificacion.getDescripcion());
    }

    private void validarNombre(String nombre) throws PathOrderException {
        if (UtilTexto.getInstance().esVacio(nombre)) {
            throw BusinessLogicPathOrderException.reportar("El nombre del tipo de notificación es obligatorio");
        }
        if (!(!nombre.isEmpty() && nombre.length() <= 20)) {
            throw BusinessLogicPathOrderException.reportar("El nombre del tipo de notificación no puede exceder los 50 caracteres");
        }
        if (!UtilTexto.getInstance().contieneSoloLetrasEspacios(nombre)) {
            throw BusinessLogicPathOrderException.reportar("El nombre del tipo de notificación solo debe contener letras y espacios");
        }

    }

    private void validarMensaje(String mensaje) throws PathOrderException {
        if (UtilTexto.getInstance().esVacio(mensaje)) {
            throw BusinessLogicPathOrderException.reportar("El mensaje del tipo de notificación es obligatorio");
        }
        if (!(!mensaje.isEmpty() && mensaje.length() <= 100)) {
            throw BusinessLogicPathOrderException.reportar("El mensaje del tipo de notificación no puede exceder los 100 caracteres");
        }
       if (UtilTexto.getInstance().contieneSoloLetrasEspacios(mensaje)) {throw BusinessLogicPathOrderException.reportar("El mensaje del tipo de notificación solo debe contener letras y espacios");        }
    }

    private void validarDescripcion(String descripcion) throws PathOrderException {
        if (UtilTexto.getInstance().esVacio(descripcion)) {
            throw BusinessLogicPathOrderException.reportar("La descripción del tipo de notificación es obligatoria");
        }
        if (!(!descripcion.isEmpty() && descripcion.length() <= 100)) {
            throw BusinessLogicPathOrderException.reportar("La descripción del tipo de notificación no puede exceder los 100 caracteres");
        }

    }
}