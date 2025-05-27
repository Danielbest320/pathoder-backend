package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.TipoProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.TipoProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tipo-productos")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoProductoController {

    private final TipoProductoFacade tipoProductoFacade;

    public TipoProductoController(TipoProductoFacade tipoProductoFacade) {
        this.tipoProductoFacade = tipoProductoFacade;
    }

    @GetMapping("/dummy")
    public TipoProductoDTO getDummy() {
        return new TipoProductoDTO();
    }

    @PostMapping
    public ResponseEntity<String> crearTipoProducto(@RequestBody TipoProductoDTO tipoProductoDTO) throws PathOrderException {
        tipoProductoFacade.crearTipoProductoPredeterminado(tipoProductoDTO);
        String mensaje = "El tipo de producto '" + tipoProductoDTO.getNombre() + "' se ha registrado exitosamente";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TipoProductoDTO>> consultarTipoProductos() throws PathOrderException {
        List<TipoProductoDTO> lista = tipoProductoFacade.consultarTipoProductos(getDummy());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TipoProductoDTO>> consultarTipoProductosConFiltro(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String nombre
    ) throws PathOrderException {
        TipoProductoDTO filtro = new TipoProductoDTO();
        filtro.setId(id);
        filtro.setNombre(nombre);

        List<TipoProductoDTO> resultado = tipoProductoFacade.consultarTipoProductos(filtro);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
