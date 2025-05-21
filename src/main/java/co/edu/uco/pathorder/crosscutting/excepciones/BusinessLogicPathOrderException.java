package co.edu.uco.pathorder.crosscutting.excepciones;

public class BusinessLogicPathOrderException extends PathOrderException {

    private static final long serialVersionUID = 376198123456789L;

    protected BusinessLogicPathOrderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        super(mensajeUsuario, mensajeTecnico, excepcionRaiz, LayerException.BUSINESS_LOGIC);

    }

    public static PathOrderException reportar(String mensajeUsuario) {
        return new BusinessLogicPathOrderException(mensajeUsuario, mensajeUsuario, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico) {
        return new BusinessLogicPathOrderException(mensajeUsuario, mensajeTecnico, new Exception());
    }

    public static PathOrderException reportar(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
        return new BusinessLogicPathOrderException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
    }
}
