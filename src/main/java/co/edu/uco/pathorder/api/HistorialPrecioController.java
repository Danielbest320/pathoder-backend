package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.HistorialPrecioFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.HistorialPrecioDTO;
import co.edu.uco.pathorder.dto.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/historial-precios")
@CrossOrigin(origins = "http://localhost:4200")
public class HistorialPrecioController {

    private final HistorialPrecioFacade historialPrecioFacade;

    public HistorialPrecioController(HistorialPrecioFacade historialPrecioFacade) {
        this.historialPrecioFacade = historialPrecioFacade;
    }

    @GetMapping("/dummy")
    public HistorialPrecioDTO getDummy() {
        return new HistorialPrecioDTO();
    }

    @PostMapping
    public ResponseEntity<String> registrarHistorialPrecio(@RequestBody HistorialPrecioDTO historialPrecioDTO) throws PathOrderException {
        historialPrecioFacade.registrarNuevoPrecioHistorial(historialPrecioDTO);
        var mensaje = "Historial de precio registrado exitosamente para el producto '" + historialPrecioDTO.getProducto().getNombre() + "'.";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HistorialPrecioDTO>> consultarHistorialPrecio(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) UUID productoId,
            @RequestParam(required = false) Integer precio
    ) throws PathOrderException {
        HistorialPrecioDTO filtro = new HistorialPrecioDTO();
        filtro.setId(id);
        if (precio != null) {
            filtro.setPrecio(precio);
        }

        if (productoId != null) {
            ProductoDTO producto = new ProductoDTO();
            producto.setId(productoId);
            filtro.setProducto(producto);
        }

        List<HistorialPrecioDTO> resultado = historialPrecioFacade.consultarHistorialPrecioProducto(filtro);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
