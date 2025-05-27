package co.edu.uco.pathorder.api;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// DTO para errores de API
class ApiError {
    private String mensaje;

    private String detalle;

    public ApiError(String mensaje, String detalle) {
        this.mensaje = mensaje;
        //this.detalle = detalle;
    }
    public String getMensaje() { return mensaje; }
    //public String getDetalle() { return detalle; }
}

@ControllerAdvice
public class ControladorGlobalExcepciones {

    @ExceptionHandler(PathOrderException.class)
    @ResponseBody
    public ResponseEntity<ApiError> controladorPathOrderException(PathOrderException ex) {
        ex.printStackTrace();
        ApiError error = new ApiError(
                ex.getMensajeUsuario(),
                ex.getMensajeTecnico() != null ? ex.getMensajeTecnico() : null
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ApiError> controladorException(Exception ex) {
        ex.printStackTrace();
        ApiError error = new ApiError(
                "Se ha presentado un problema al procesar la operación",
                ex.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
}
