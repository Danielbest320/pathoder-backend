package co.edu.uco.pathorder.bussinesslogic.businesslogic;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.CategoriaDomain;

import java.util.List;
import java.util.UUID;

public interface CategoriaBusinessLogic {

    void crearNuevaCategoria(CategoriaDomain categoria);


    void modificarCategoriaExistente(UUID id, CategoriaDomain categoria);

    void eliminarUnaCategoria(UUID id);

    List<CategoriaDomain> consultarCategoriaDisponibles(CategoriaDomain filtro);

    List<CategoriaDomain> consultarCategoriaExistentes(CategoriaDomain filtro);
}
