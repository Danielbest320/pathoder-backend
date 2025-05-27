package co.edu.uco.pathorder.api;


import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControladorGlobalExcepciones {

    @ExceptionHandler(PathOrderException.class)
    public ResponseEntity<String> controladorPathOrderException(PathOrderException exception) {
        exception.printStackTrace();
        return new ResponseEntity<>(exception.getMensajeUsuario(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> controladorException(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity<>("Se a precentado un problema tratano de llevar a cabo la operacion ", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
