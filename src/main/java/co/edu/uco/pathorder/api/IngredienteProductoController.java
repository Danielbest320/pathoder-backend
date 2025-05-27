package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.IngredienteProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.IngredienteProductoDTO;
import co.edu.uco.pathorder.dto.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ingredientes-productos")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredienteProductoController {

    private final IngredienteProductoFacade ingredienteProductoFacade;

    public IngredienteProductoController(IngredienteProductoFacade ingredienteProductoFacade) {
        this.ingredienteProductoFacade = ingredienteProductoFacade;
    }

    @GetMapping("/dummy")
    public IngredienteProductoDTO getDummy() {
        return new IngredienteProductoDTO();
    }

    @PostMapping
    public ResponseEntity<String> asignarIngredienteProducto(@RequestBody IngredienteProductoDTO ingredienteProductoDTO) throws PathOrderException {
        ingredienteProductoFacade.asignarIngredienteProducto(ingredienteProductoDTO);
        var mensaje = "Ingrediente asignado correctamente al producto '" + ingredienteProductoDTO.getProductoVenta().getNombre() + "'.";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarCantidadIngrediente(
            @PathVariable UUID id,
            @RequestBody IngredienteProductoDTO ingredienteProductoDTO) throws PathOrderException {
        ingredienteProductoFacade.modificarCantidadIngrediente(ingredienteProductoDTO, id);
        var mensaje = "Cantidad del ingrediente modificada correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarIngredienteProducto(@PathVariable UUID id) throws PathOrderException {
        ingredienteProductoFacade.eliminarIngredienteProducto(id);
        var mensaje = "Relación ingrediente-producto eliminada correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<IngredienteProductoDTO>> consultarIngredientesProductos(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) UUID productoVentaId,
            @RequestParam(required = false) UUID productoIngredienteId,
            @RequestParam(required = false) Integer cantidad
    ) throws PathOrderException {
        IngredienteProductoDTO filtro = new IngredienteProductoDTO();
        filtro.setId(id);
        filtro.setCantidad(cantidad != null ? cantidad : 0);

        if (productoVentaId != null) {
            ProductoDTO venta = new ProductoDTO();
            venta.setId(productoVentaId);
            filtro.setProductoVenta(venta);
        }

        if (productoIngredienteId != null) {
            ProductoDTO ingrediente = new ProductoDTO();
            ingrediente.setId(productoIngredienteId);
            filtro.setProductoIngrediente(ingrediente);
        }

        List<IngredienteProductoDTO> resultado = ingredienteProductoFacade.consultarIngredientesProductos(filtro);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
