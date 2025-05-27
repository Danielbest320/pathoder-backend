package co.edu.uco.pathorder.api;


import co.edu.uco.pathorder.bussinesslogic.facade.TipoNotificacionFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.TipoNotificacionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tipoNotificaciones")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoNotificacionController {

    private final TipoNotificacionFacade tipoNotificacionFacade;

    public TipoNotificacionController(TipoNotificacionFacade tipoNotificacionFacade) throws PathOrderException {
        this.tipoNotificacionFacade = tipoNotificacionFacade;
    }

    @GetMapping("/dummy")
    public TipoNotificacionDTO getDummy() {
        return new TipoNotificacionDTO();
    }

    @GetMapping
    public ResponseEntity<List<TipoNotificacionDTO>> consultar() throws PathOrderException {
        List<TipoNotificacionDTO> lista = tipoNotificacionFacade.consultarTiposNotificacion(getDummy());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoNotificacionDTO> consultarPorId(@PathVariable("id") UUID id) throws PathOrderException {
        var dto = tipoNotificacionFacade.consultarTiposNotificacion(new TipoNotificacionDTO(id)).get(0);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody TipoNotificacionDTO tipoNotificacion) throws PathOrderException {
        tipoNotificacionFacade.crearTiposNotificacion(tipoNotificacion);
        String mensaje = "El tipo de notificación " + tipoNotificacion.getNombre() + " ha sido creado correctamente";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable("id") UUID id,
                                             @RequestBody TipoNotificacionDTO tipoNotificacion) throws PathOrderException {
        tipoNotificacion.setId(id);
        tipoNotificacionFacade.crearTiposNotificacion(tipoNotificacion);
        String mensaje = "El tipo de notificación " + tipoNotificacion.getNombre() + " se ha actualizado exitosamente";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") UUID id) throws PathOrderException {
        tipoNotificacionFacade.consultarTiposNotificacion(new TipoNotificacionDTO(id));
        String mensaje = "El tipo de notificación con id " + id + " ha sido eliminado correctamente";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
