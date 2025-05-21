package co.edu.uco.pathorder.crosscutting.excepciones;

public class BusinessLogicPathorderException extends PathorderException {

    private static final long serialVersionUID = 376198123456789L;

    protected BusinessLogicPathorderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.BUSINESS_LOGIC);

    }

    public static PathorderException reportar(String mensajeUsuario) {
        return new BusinessLogicPathorderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new BusinessLogicPathorderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathorderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new BusinessLogicPathorderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
