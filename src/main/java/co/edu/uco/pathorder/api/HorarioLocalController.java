package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.bussinesslogic.facade.HorarioLocalFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.dto.HorarioLocalDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/horarios-locales")
@CrossOrigin(origins = "http://localhost:4200")
public class HorarioLocalController {

    private final HorarioLocalFacade horarioLocalFacade;

    public HorarioLocalController(HorarioLocalFacade horarioLocalFacade) {
        this.horarioLocalFacade = horarioLocalFacade;
    }

    @GetMapping("/dummy")
    public HorarioLocalDTO getDummy() {
        return new HorarioLocalDTO();
    }

    @PostMapping
    public ResponseEntity<String> registrarHorario(@RequestBody HorarioLocalDTO horarioLocalDTO) throws PathOrderException {
        horarioLocalFacade.registrarHorarioLocal(horarioLocalDTO);
        var mensaje = "Horario del local registrado correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarHorario(@PathVariable UUID id, @RequestBody HorarioLocalDTO horarioLocalDTO) throws PathOrderException {
        horarioLocalFacade.modificarHorarioLocal(horarioLocalDTO, id);
        var mensaje = "Horario del local modificado correctamente.";
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HorarioLocalDTO>> consultarDisponibilidadHorario(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) Boolean estadoLocal,
            @RequestParam(required = false) String horaDesde,
            @RequestParam(required = false) String horaHasta
    ) throws PathOrderException {
        HorarioLocalDTO filtro = new HorarioLocalDTO();
        filtro.setId(id);
        filtro.setEstadoLocal(estadoLocal);

        if (horaDesde != null) {
            filtro.setHoraDesde(LocalDateTime.parse(horaDesde));
        }
        if (horaHasta != null) {
            filtro.setHoraHasta(LocalDateTime.parse(horaHasta));
        }

        List<HorarioLocalDTO> resultado = horarioLocalFacade.consultarDisponibilidadHorario(filtro);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
