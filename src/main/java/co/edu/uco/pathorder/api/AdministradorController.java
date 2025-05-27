package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.AdministradorFacade;
import co.edu.uco.pathorder.bussinesslogic.facade.impl.AdministradorFacadeImpl;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.AdministradorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/administradores")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

    private final AdministradorFacade administradorFacade;

    public AdministradorController(AdministradorFacade administradorFacade) throws PathOrderException {
        this.administradorFacade = administradorFacade;
    }

    @GetMapping("/dummy")
    public AdministradorDTO getDummy() {
        return new AdministradorDTO();
    }

    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> consultar() throws PathOrderException {
        List<AdministradorDTO> lista = administradorFacade.consultarAdministradores(getDummy());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> consultarPorId(@PathVariable("id") UUID id) throws PathOrderException {
        var dto = administradorFacade.consultarAdministradorPorId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody AdministradorDTO administrador) throws PathOrderException {
        administradorFacade.registrarAdministrador(administrador);
        var mensaje = "El administrador " + administrador.getNombre() + " ha sido creado correctamente";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable("id") UUID id,
                                             @RequestBody AdministradorDTO administrador) throws PathOrderException {
        administrador.setId(id);
        administradorFacade.actualizarInformacionAdministrador(id, administrador);
        String mensaje = "El administrador " + administrador.getNombre() + " se ha actualizado exitosamente";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") UUID id) throws PathOrderException {
        administradorFacade.eliminarCuentaAdministrador(id);
        String mensaje = "El administrador con id " + id + " ha sido eliminado correctamente";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
