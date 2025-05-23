package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.CategoriaDomain;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;
import java.util.UUID;

public interface CategoriaBusinessLogic {

    void crearNuevaCategoria(CategoriaDomain categoria) throws PathOrderException;


    void modificarCategoriaExistente(UUID id, CategoriaDomain categoria) throws PathOrderException;

    void eliminarUnaCategoria(UUID id) throws PathOrderException;

    List<CategoriaDomain> consultarCategoriaDisponibles(CategoriaDomain filtro) throws PathOrderException;

    List<CategoriaDomain> consultarCategoriaExistentes(CategoriaDomain filtro) throws PathOrderException;
}
