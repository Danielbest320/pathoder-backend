package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.ProductoFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    private final ProductoFacade productoFacade;

    public ProductoController(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    @GetMapping("/dummy")
    public ProductoDTO getDummy() {
        return new ProductoDTO();
    }

    @PostMapping
    public ResponseEntity<String> registrarProducto(@RequestBody ProductoDTO productoDTO) throws PathOrderException {
        productoFacade.registrarProducto(productoDTO);
        var mensaje = "El producto '" + productoDTO.getNombre() + "' ha sido registrado exitosamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarProducto(@PathVariable UUID id, @RequestBody ProductoDTO productoDTO) throws PathOrderException {
        productoFacade.modificarProducto(id, productoDTO);
        var mensaje = "El producto '" + productoDTO.getNombre() + "' ha sido modificado correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable UUID id) throws PathOrderException {
        productoFacade.eliminarProducto(id);
        var mensaje = "El producto con ID '" + id + "' ha sido eliminado correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> consultarProductos() throws PathOrderException {
        List<ProductoDTO> productos = productoFacade.consultarProducto(getDummy());
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductoDTO>> consultarProductosConFiltro(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String nombre
    ) throws PathOrderException {
        ProductoDTO filtro = new ProductoDTO();
        filtro.setId(id);
        filtro.setNombre(nombre);

        List<ProductoDTO> productos = productoFacade.consultarProducto(filtro);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<ProductoDTO>> consultarProductosDisponibles(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String nombre
    ) throws PathOrderException {
        ProductoDTO filtro = new ProductoDTO();
        filtro.setId(id);
        filtro.setNombre(nombre);

        List<ProductoDTO> disponibles = productoFacade.consultarProductoDisponible(filtro);
        return new ResponseEntity<>(disponibles, HttpStatus.OK);
    }
}
