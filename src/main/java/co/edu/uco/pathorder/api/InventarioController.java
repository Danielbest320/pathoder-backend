package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.InventarioFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.InventarioDTO;
import co.edu.uco.pathorder.dto.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/inventarios")
@CrossOrigin(origins = "http://localhost:4200")
public class InventarioController {

    private final InventarioFacade inventarioFacade;

    public InventarioController(InventarioFacade inventarioFacade) {
        this.inventarioFacade = inventarioFacade;
    }

    @GetMapping("/dummy")
    public InventarioDTO getDummy() {
        return new InventarioDTO();
    }

    @PostMapping
    public ResponseEntity<String> crearInventario(@RequestBody InventarioDTO inventarioDTO) throws PathOrderException {
        inventarioFacade.crearInventario(inventarioDTO);
        var mensaje = "Inventario para el producto '" + inventarioDTO.getProducto().getNombre() + "' creado exitosamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarInventario(@PathVariable UUID id, @RequestBody InventarioDTO inventarioDTO) throws PathOrderException {
        inventarioFacade.actualizarInventario(inventarioDTO, id);
        var mensaje = "Inventario actualizado correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/reserva/{id}")
    public ResponseEntity<String> actualizarInventarioMomentoReserva(@PathVariable UUID id, @RequestBody InventarioDTO inventarioDTO) throws PathOrderException {
        inventarioFacade.actualizarInventarioMomentoReserva(inventarioDTO, id);
        var mensaje = "Inventario actualizado en el momento de la reserva.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarInventario(@PathVariable UUID id) throws PathOrderException {
        inventarioFacade.eliminarInventario(id);
        var mensaje = "Inventario con ID '" + id + "' eliminado correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> consultarInventario(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) Integer disponibilidad,
            @RequestParam(required = false) UUID productoId
    ) throws PathOrderException {
        InventarioDTO filtro = new InventarioDTO();
        filtro.setId(id);
        filtro.setDisponibilidad(disponibilidad);

        if (productoId != null) {
            var producto = new ProductoDTO();
            producto.setId(productoId);
            filtro.setProducto(producto);
        }

        List<InventarioDTO> resultado = inventarioFacade.consultarInventario(filtro);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
