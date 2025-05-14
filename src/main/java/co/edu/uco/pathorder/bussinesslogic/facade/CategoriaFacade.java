package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.dto.CategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface CategoriaFacade {

    void crearNuevaCategoria(CategoriaDTO categoria);


    void modificarCategoriaExistente(UUID id, CategoriaDTO categoria);

    void eliminarUnaCategoria(UUID id);

    List<CategoriaDTO> consultarCategoriaDisponibles(CategoriaDTO filtro);

    List<CategoriaDTO> consultarCategoriaExistentes(CategoriaDTO filtro);
}
