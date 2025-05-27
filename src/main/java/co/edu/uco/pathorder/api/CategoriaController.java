package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.CategoriaFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.CategoriaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaFacade categoriaFacade;

    public CategoriaController(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    @GetMapping("/dummy")
    public CategoriaDTO getDummy() {
        return new CategoriaDTO();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> consultarCategorias() throws PathOrderException {
        var lista = categoriaFacade.consultarCategoriaExistentes(getDummy());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) throws PathOrderException {
        categoriaFacade.crearNuevaCategoria(categoriaDTO);
        var mensajeExito = "La categoría '" + categoriaDTO.getNombre() + "' se ha registrado exitosamente";
        return new ResponseEntity<>(mensajeExito, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarCategoria(@PathVariable UUID id, @RequestBody CategoriaDTO categoriaDTO) throws PathOrderException {
        categoriaFacade.modificarCategoriaExistente(id, categoriaDTO);
        var mensajeExito = "La categoría '" + categoriaDTO.getNombre() + "' se ha modificado exitosamente";
        return new ResponseEntity<>(mensajeExito, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable UUID id) throws PathOrderException {
        categoriaFacade.eliminarUnaCategoria(id);
        var mensajeExito = "La categoría con id '" + id + "' se ha eliminado exitosamente";
        return new ResponseEntity<>(mensajeExito, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CategoriaDTO>> consultarCategoriasConFiltro(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String nombre
    ) throws PathOrderException {

        CategoriaDTO filtro = new CategoriaDTO();
        filtro.setId(id);
        filtro.setNombre(nombre);

        var lista = categoriaFacade.consultarCategoriaExistentes(filtro);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
