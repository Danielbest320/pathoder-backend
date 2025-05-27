package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.categoria.entity.CategoriaEntityAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.CategoriaBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.CategoriaEntity;

import java.util.List;
import java.util.UUID;

public class CategoriaBusinessLogicImpl implements CategoriaBusinessLogic {

    private final DAOFactory factory;

    public CategoriaBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void crearNuevaCategoria(CategoriaDomain categoria) throws PathOrderException {

        // 1. Validar integridad de la información
        validarIntegridadInformacionRegistrarNuevaCategoria(categoria);

        // 2. Validar que no exista una categoría con el mismo nombre
        validarNoExistaCategoriaConMismoNombre(categoria.getNombre());

        // 3. Generar un identificador único para la nueva categoría
        var nuevoId = generarIdentificadorNuevaCategoria();

        // 4. Recrear el domain con el nuevo id
        var categoriaDomainACrear = new CategoriaDomain(nuevoId, categoria.getNombre());

        // 5. Crear la categoría en la base de datos

        var categoriaEntity = CategoriaEntityAssembler.getInstance().toEntity(categoriaDomainACrear);
        factory.getCategoriaDAO().create(categoriaEntity);
    }

    private void validarIntegridadInformacionRegistrarNuevaCategoria(CategoriaDomain categoria) throws PathOrderException {
        validarIntegridadNombreCategoria(categoria.getNombre());
    }

    private void validarIntegridadNombreCategoria(String nombreCategoria) throws PathOrderException {
        // Nombre de la categoría obligatorio
        if (UtilTexto.getInstance().esVacio(nombreCategoria)) {
            throw BusinessLogicPathOrderException.reportar("El nombre de la categoría es obligatorio...");
        }

        // Nombre solo con letras y espacios
        if (!UtilTexto.getInstance().contieneSoloLetrasEspacios(nombreCategoria)) {
            throw BusinessLogicPathOrderException.reportar("El nombre de la categoría solo puede contener letras...");
        }

        // Longitud del nombre válida
        if (!UtilTexto.getInstance().longitudValida(nombreCategoria, 1, 50)) {
            throw BusinessLogicPathOrderException.reportar("El nombre de la categoría supera los 50 caracteres...");
        }
    }

    private void validarNoExistaCategoriaConMismoNombre(String nombreCategoria) throws PathOrderException {

        nombreCategoria = nombreCategoria.trim().toLowerCase();

        var filtro = new CategoriaEntity();
        filtro.setNombre(nombreCategoria);

        var listaResultados = factory.getCategoriaDAO().listByFilter(filtro);

        // Si la lista devolvió resultados, entonces ya existe una categoría con ese nombre
        if (!listaResultados.isEmpty()) {
            throw BusinessLogicPathOrderException.reportar("Ya existe una categoría con el nombre: " + nombreCategoria + "...");
        }
    }

    private UUID generarIdentificadorNuevaCategoria() throws PathOrderException {

        UUID nuevoId;
        var existeId = false;

        do {
            nuevoId = UtilUUID.generarNuevoUUID();
            var categoria = factory.getCategoriaDAO().listById(nuevoId);
            existeId = !UtilUUID.esValorDefecto(categoria.getId());

        } while (existeId);

        return nuevoId;
    }



    @Override
    public void modificarCategoriaExistente(UUID id, CategoriaDomain categoria) throws PathOrderException {

        var categoriaExistente = factory.getCategoriaDAO().listById(id);
        if (UtilUUID.esValorDefecto(categoriaExistente.getId())) {
            throw BusinessLogicPathOrderException.reportar("No existe una categoria con el id: " + id + "...");
        }

        validarIntegridadNombreCategoria(categoria.getNombre());
        var categoriaEntity = CategoriaEntityAssembler.getInstance().toEntity(categoria);
        factory.getCategoriaDAO().update(id,categoriaEntity);
    }

    @Override
    public void eliminarUnaCategoria(UUID id) throws PathOrderException {
        var categoriaExistente = factory.getCategoriaDAO().listById(id);
        if (UtilUUID.esValorDefecto(categoriaExistente.getId())) {
            throw BusinessLogicPathOrderException.reportar("No existe una categoria con el id: " + id + "...");
        }
        factory.getCategoriaDAO().delete(id);
    }

    //Para administradores
    public List<CategoriaDomain> consultarCategoriaDisponibles(CategoriaDomain filtro) throws PathOrderException {
        var tieneFiltros = filtro != null && (
                !UtilUUID.esValorDefecto(filtro.getId()) ||
                        !UtilTexto.getInstance().esValorDefecto(filtro.getNombre())
        );

        var categoriaEntities = tieneFiltros
                ? factory.getCategoriaDAO().listByFilter(CategoriaEntityAssembler.getInstance().toEntity(filtro))
                : factory.getCategoriaDAO().listAll();

        return CategoriaEntityAssembler.getInstance().toDomains(categoriaEntities);
    }
// Para clientes
    @Override
    public List<CategoriaDomain> consultarCategoriaExistentes(CategoriaDomain filtro) throws PathOrderException {
        var tieneFiltros = filtro != null && (
                !UtilUUID.esValorDefecto(filtro.getId()) ||
                        !UtilTexto.getInstance().esValorDefecto(filtro.getNombre())
        );

        var categoriaEntities = tieneFiltros
                ? factory.getCategoriaDAO().listByFilter(CategoriaEntityAssembler.getInstance().toEntity(filtro))
                : factory.getCategoriaDAO().listAll();

        return CategoriaEntityAssembler.getInstance().toDomains(categoriaEntities);

    }
}
