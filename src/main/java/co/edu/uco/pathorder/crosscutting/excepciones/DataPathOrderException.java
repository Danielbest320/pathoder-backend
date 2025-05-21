package co.edu.uco.pathorder.crosscutting.excepciones;

public class DataPathOrderException extends PathOrderException {

    private static final long serialVersionUID = 376198123456789L;

    private DataPathOrderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.DATA);

    }

    public static PathOrderException reportar(String mensajeUsuario) {
        return new DataPathOrderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new DataPathOrderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new DataPathOrderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
