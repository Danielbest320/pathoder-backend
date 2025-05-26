package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.bussinesslogic.mapper.AdministradorMapper;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.AdministradorEntity;

import java.util.List;
import java.util.UUID;

public class AdminisntradorBusinessLogicImpl  implements AdministradorBusinessLogic {

    private final DAOFactory factory;

    public AdminisntradorBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;

    }


    @Override
    public void registrarAdministrador(AdministradorDomain administrador) throws PathOrderException {
        validarIntegridadInformacionAdministrador(administrador);
        validarNoExistaUsuarioOEmail(administrador);

        // Generar nuevo ID
        UUID nuevoId = UtilUUID.generarNuevoUUID();
        var adminConId = new AdministradorDomain(
                nuevoId,
                administrador.getDi(),
                administrador.getNombre(),
                administrador.getApellido(),
                administrador.getCorreo(),
                administrador.getTelefono(),
                administrador.getContrasena(),
                administrador.isConfirmacionCorreo(),
                administrador.isConfirmacionTelefono(),
                administrador.isEstadoCuenta(),
                administrador.getUsuario()
        );

        // Mapear y crear
        AdministradorEntity entity = AdministradorMapper.toEntity(adminConId);
        factory.getAdministradorDAO().create(entity);
    }

    @Override
    public void actualizarInformacionAdministrador(UUID id, AdministradorDomain administrador) throws PathOrderException {
        AdministradorEntity administradorEntity = AdministradorMapper.toEntity(administrador);
        factory.getAdministradorDAO().update(id,administradorEntity);

    }

    @Override
    public void eliminarCuentaAdministrador(UUID id) throws PathOrderException {
        factory.getAdministradorDAO().delete(id);

    }

    @Override
    public AdministradorDomain consultarAdministradorPorId(UUID id) throws PathOrderException {
        var entity = factory.getAdministradorDAO().listById(id);
        if (entity == null) {
            throw BusinessLogicPathOrderException.reportar("No existe administrador con ID " + id);
        }
        return AdministradorMapper.toDomain(entity);
    }

    @Override
    public List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro) throws PathOrderException {
        AdministradorEntity administradorFilter = AdministradorMapper.toEntity(filtro);
        List<AdministradorEntity> AdministradorEntities = factory.getAdministradorDAO().listByFilter(administradorFilter);
        List<AdministradorDomain> datosARetornar = AdministradorMapper.toDomainList(AdministradorEntities);

        return datosARetornar;
    }

    // ————— Validaciones de negocio —————

    private void validarIntegridadInformacionAdministrador(AdministradorDomain admin) throws PathOrderException {
        if (UtilTexto.getInstance().esVacio(admin.getDi())){
            throw BusinessLogicPathOrderException.reportar("El ID es obligatorio");

        }
        if (UtilTexto.getInstance().esVacio(admin.getNombre())) {
            throw BusinessLogicPathOrderException.reportar("El nombre es obligatorio");
        }
        if (!UtilTexto.getInstance().contieneSoloLetrasEspacios(admin.getNombre())) {
            throw BusinessLogicPathOrderException.reportar("El nombre solo debe contener letras y espacios");
        }
        if (UtilTexto.getInstance().esVacio(admin.getApellido())) {
            throw BusinessLogicPathOrderException.reportar("El apellido es obligatorio");
        }
        if (UtilTexto.getInstance().esVacio(admin.getUsuario())) {
            throw BusinessLogicPathOrderException.reportar("El usuario es obligatorio");
        }
        if (UtilTexto.getInstance().esVacio(admin.getCorreo())) {
            throw BusinessLogicPathOrderException.reportar("El correo electrónico es obligatorio");
        }
        if (!UtilTexto.getInstance().esEmailValido(admin.getCorreo())) {
            throw BusinessLogicPathOrderException.reportar("El formato de correo electrónico no es válido");
        }
        if (UtilTexto.getInstance().esVacio(admin.getTelefono())) {
            throw BusinessLogicPathOrderException.reportar("El telefono es obligatorio");
        }
        if (UtilTexto.getInstance().esVacio(admin.getContrasena())) {
            throw BusinessLogicPathOrderException.reportar("El contrasena es obligatorio");
        }
        if (!UtilTexto.getInstance().esContrasenaValida(admin.getContrasena())) {
            throw BusinessLogicPathOrderException.reportar("El contrasena no es valida, debe contener minimo 8 caracteres, 1 mayuscula, un numero y un caracter especial");
        }

    }

    private void validarNoExistaUsuarioOEmail(AdministradorDomain admin) throws PathOrderException {
        AdministradorEntity filtro = AdministradorMapper.toEntity(admin);
        List<AdministradorEntity> encontrados = factory.getAdministradorDAO().listByFilter(filtro);

        boolean duplicado = encontrados.stream().anyMatch(e ->
                e.getUsuario().equalsIgnoreCase(admin.getUsuario()) ||
                        e.getCorreo().equalsIgnoreCase(admin.getCorreo())
        );
        if (duplicado) {
            throw BusinessLogicPathOrderException.reportar(
                    "Ya existe un administrador con el mismo usuario o correo electrónico"
            );
        }
    }





}
