package co.edu.uco.pathorder.crosscutting.excepciones;

public class ApiPathorderException extends PathorderException {

    private static final long serialVersionUID = 376198123456789L;

    protected ApiPathorderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.API);

    }

    public static PathorderException reportar(String mensajeUsuario) {
        return new ApiPathorderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new ApiPathorderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new ApiPathorderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
