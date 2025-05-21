package co.edu.uco.pathorder.crosscutting.excepciones;

public class DataPathorderException extends PathorderException {

    private static final long serialVersionUID = 376198123456789L;

    private DataPathorderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.DATA);

    }

    public static PathorderException reportar(String mensajeUsuario) {
        return new DataPathorderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new DataPathorderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new DataPathorderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
