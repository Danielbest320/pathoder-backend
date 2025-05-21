package co.edu.uco.pathorder.crosscutting.excepciones;

public class CrosscuttingPathOrderException extends PathOrderException {

    private static final long serialVersionUID = 376198123456789L;

    protected CrosscuttingPathOrderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.CROSSCUTTING);

    }

    public static PathOrderException reportar(String mensajeUsuario) {
        return new CrosscuttingPathOrderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new CrosscuttingPathOrderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new CrosscuttingPathOrderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
