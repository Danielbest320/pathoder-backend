package co.edu.uco.pathorder.crosscutting.excepciones;

import co.edu.uco.pathorder.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilTexto;

public class PathorderException extends Exception{

    private static final long serialVersionUID = 376198123456789L;

    private String mensajeUsuario;
    private LayerException capa;

    protected PathorderException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz, LayerException capa) {
        super(mensajeTecnico, excepcionRaiz);
        setMensajeUsuario(mensajeUsuario);
        setCapa(capa);
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    private void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = UtilTexto.getInstance().quitarEspacioBlancoInicioFin(mensajeUsuario);
    }

    public String getMensajeTecnico() {
        return UtilTexto.getInstance().obtenerValorDefecto(getMessage());
    }

    public Throwable getExcepcionRaiz() {
        return UtilObjeto.getInstance().obtenerValorDefecto(getCause(), new Exception(getMensajeUsuario()));
    }


    public LayerException getCapa() {
        return capa;
    }

    private void setCapa(LayerException capa) {
        this.capa = UtilObjeto.getInstance().obtenerValorDefecto(capa, LayerException.GENERAL);
    }

}
