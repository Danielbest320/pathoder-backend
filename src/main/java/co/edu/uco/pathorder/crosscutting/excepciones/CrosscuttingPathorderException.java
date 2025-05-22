package co.edu.uco.pathorder.crosscutting.excepciones;

public class CrosscuttingPathorderException extends PathorderException {

    private static final long serialVersionUID = 376198123456789L;

    protected CrosscuttingPathorderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.CROSSCUTTING);

    }

    public static PathorderException reportar(String mensajeUsuario) {
        return new CrosscuttingPathorderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new CrosscuttingPathorderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new CrosscuttingPathorderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
