package co.edu.uco.pathorder.bussinesslogic.facade;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.CategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface CategoriaFacade {

    void crearNuevaCategoria(CategoriaDTO categoria) throws PathOrderException;


    void modificarCategoriaExistente(UUID id, CategoriaDTO categoria) throws PathOrderException;

    void eliminarUnaCategoria(UUID id) throws PathOrderException;

    List<CategoriaDTO> consultarCategoriaDisponibles(CategoriaDTO filtro) throws PathOrderException;

    List<CategoriaDTO> consultarCategoriaExistentes(CategoriaDTO filtro) throws PathOrderException;
}
