package co.edu.uco.pathorder.crosscutting.excepciones;

public class ApiPathOrderException extends PathOrderException {

    private static final long serialVersionUID = 376198123456789L;

    protected ApiPathOrderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.API);

    }

    public static PathOrderException reportar(String mensajeUsuario) {
        return new ApiPathOrderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new ApiPathOrderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new ApiPathOrderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
