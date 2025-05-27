package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.administrador.entity.AdministradorEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilSeguridad;
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
        validarNoExistanDatosDuplicados(administrador);

        // Generar nuevo ID
        UUID nuevoId = UtilUUID.generarNuevoUUID();

        String contrasenaEncriptada = UtilSeguridad.encriptar(administrador.getContrasena() );

        var adminConId = new AdministradorDomain(
                nuevoId,
                administrador.getDi(),
                administrador.getNombre(),
                administrador.getApellido(),
                administrador.getCorreo(),
                administrador.getTelefono(),
                contrasenaEncriptada,
                administrador.isConfirmacionCorreo(),
                administrador.isConfirmacionTelefono(),
                administrador.isEstadoCuenta(),
                administrador.getUsuario()
        );

        // Mapear y crear
        var entity = AdministradorEntityAssembler.getInstance().toEntity(adminConId);
        factory.getAdministradorDAO().create(entity);
    }

    @Override
    public void actualizarInformacionAdministrador(UUID id, AdministradorDomain administrador) throws PathOrderException {
        var administradorEntity = AdministradorEntityAssembler.getInstance().toEntity(administrador);
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
        return AdministradorEntityAssembler.getInstance().toDomain(entity);
    }

    @Override
    public List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro) throws PathOrderException {
        var tieneFiltros = filtro != null && (
                !UtilUUID.esValorDefecto(filtro.getId()) ||
                        !UtilTexto.getInstance().esValorDefecto(filtro.getDi()) ||
                        !UtilTexto.getInstance().esValorDefecto(filtro.getCorreo()) ||
                        !UtilTexto.getInstance().esValorDefecto(filtro.getUsuario()) ||
                        !UtilTexto.getInstance().esValorDefecto(filtro.getTelefono())
        );

        var administradorEntities = tieneFiltros
                ? factory.getAdministradorDAO().listByFilter(AdministradorEntityAssembler.getInstance().toEntity(filtro))
                : factory.getAdministradorDAO().listAll();

        return AdministradorEntityAssembler.getInstance().toDomains(administradorEntities);
    }


    // ————— Validaciones de negocio —————

    private void validarIntegridadInformacionAdministrador(AdministradorDomain admin) throws PathOrderException {
        //validaciones D1
        if (UtilTexto.getInstance().esVacio(admin.getDi())){
            throw BusinessLogicPathOrderException.reportar("El Di es obligatorio");
        }
        if(!UtilTexto.getInstance().contieneSoloNumeros(admin.getDi())){
            throw BusinessLogicPathOrderException.reportar("El Di solo debe contener números");
        }
        if(!UtilTexto.getInstance().longitudValida(admin.getDi(),1,12)){
            throw BusinessLogicPathOrderException.reportar("El Di tiene que tener como minimo  1 y maximo 12 numeros");
        }
        //Validaciones nombre
        if (UtilTexto.getInstance().esVacio(admin.getNombre())) {
            throw BusinessLogicPathOrderException.reportar("El nombre es obligatorio");
        }
        if (!UtilTexto.getInstance().contieneSoloLetrasEspacios(admin.getNombre())) {
            throw BusinessLogicPathOrderException.reportar("El nombre solo debe contener letras y espacios");
        }
        if (!UtilTexto.getInstance().longitudValida(admin.getNombre(),1,50)){
            throw BusinessLogicPathOrderException.reportar("El nombre debe contener entre 1 y 50 caracteres");
        }
        //Validaciones apellido
        if (UtilTexto.getInstance().esVacio(admin.getApellido())) {
            throw BusinessLogicPathOrderException.reportar("El apellido es obligatorio");
        }
        if(!UtilTexto.getInstance().contieneSoloLetrasEspacios(admin.getApellido())){
            throw BusinessLogicPathOrderException.reportar("El apellido solo debe contener letras y espacios");
        }
        if (!UtilTexto.getInstance().longitudValida(admin.getApellido(),1,50)){
            throw BusinessLogicPathOrderException.reportar("El apellido debe contener entre 1 y 50 caracteres");
        }
        //Validaciones Usuario
        if (UtilTexto.getInstance().esVacio(admin.getUsuario())) {
            throw BusinessLogicPathOrderException.reportar("El usuario es obligatorio");
        }
        if(!UtilTexto.getInstance().contieneSoloLetrasEspacios(admin.getUsuario())){
            throw BusinessLogicPathOrderException.reportar("El usuario solo debe contener letras y espacios");
        }
        if(!UtilTexto.getInstance().longitudValida(admin.getUsuario(),1,50)){
            throw BusinessLogicPathOrderException.reportar("El usuario debe contener entre 1 y 50 caracteres");
        }
        //Validaciones correo
        if (UtilTexto.getInstance().esVacio(admin.getCorreo())) {
            throw BusinessLogicPathOrderException.reportar("El correo electrónico es obligatorio");
        }
        if (!UtilTexto.getInstance().esEmailValido(admin.getCorreo())) {
            throw BusinessLogicPathOrderException.reportar("El formato de correo electrónico no es válido");
        }
        if(!UtilTexto.getInstance().longitudValida(admin.getCorreo(),1,200)){
            throw BusinessLogicPathOrderException.reportar("El correo debe contener entre 1 y 200 caracteres");
        }
        //Validaciones telefono
        if (UtilTexto.getInstance().esVacio(admin.getTelefono())) {
            throw BusinessLogicPathOrderException.reportar("El telefono es obligatorio");
        }
        if (!UtilTexto.getInstance().contieneSoloNumeros(admin.getTelefono())) {
            throw BusinessLogicPathOrderException.reportar("El Telefono solo puede contener numeros");
        }
        if (!UtilTexto.getInstance().longitudValida(admin.getTelefono(),1,10)){
            throw BusinessLogicPathOrderException.reportar("El teelfono solo puede contener entre 1 y 10 caracteres");
        }
        //Validaciones contrasena
        if (UtilTexto.getInstance().esVacio(admin.getContrasena())) {
            throw BusinessLogicPathOrderException.reportar("La contrasena es obligatorio");
        }
        if (!UtilTexto.getInstance().esContrasenaValida(admin.getContrasena())) {
            throw BusinessLogicPathOrderException.reportar("La contrasena no es valida, debe contener minimo 8 caracteres, 1 mayuscula, un numero y un caracter especial");
        }
        if(!UtilTexto.getInstance().longitudValida(admin.getContrasena(),8,100)){
            throw BusinessLogicPathOrderException.reportar("La contrasena solo puede contener maximo 100 caracteres ");
        }

    }

    private void validarNoExistanDatosDuplicados(AdministradorDomain admin) throws PathOrderException {
        var filtro = AdministradorEntityAssembler.getInstance().toEntity(admin);
        var encontrados = factory.getAdministradorDAO().listByFilter(filtro);

        for (AdministradorEntity existente : encontrados) {
            if (existente.getUsuario().equalsIgnoreCase(admin.getUsuario())) {
                throw BusinessLogicPathOrderException.reportar("Ya existe un administrador con el mismo usuario.");
            }
            if (existente.getCorreo().equalsIgnoreCase(admin.getCorreo())) {
                throw BusinessLogicPathOrderException.reportar("Ya existe un administrador con el mismo correo electrónico.");
            }
            if (existente.getDi().equalsIgnoreCase(admin.getDi())) {
                throw BusinessLogicPathOrderException.reportar("Ya existe un administrador con el mismo número de identificación (DI).");
            }
            if (existente.getTelefono().equalsIgnoreCase(admin.getTelefono())) {
                throw BusinessLogicPathOrderException.reportar("Ya existe un administrador con el mismo número de teléfono.");
            }
        }
    }






}
