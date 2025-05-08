package co.edu.uco.pathorder.crosscutting.utilitarios;

public final class UtilNumerico {

    private static UtilNumerico instancia = new UtilNumerico();
    public final static int numerico = 0;

    private UtilNumerico (){

    }

    public static UtilNumerico  getInstance() {
        return instancia;
    }

    public boolean esNula(final int valor) {
        return UtilObjeto.getIntance().esNulo(valor);
    };

    public int obtenerValorDefecto(final int valorOriginal, final int valorDefecto) {
        return UtilObjeto.getIntance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public int obtenerValorDefecto(final int valor) {
        return obtenerValorDefecto (valor, numerico);
    }

    public int obtenerValorDefecto() {
        return numerico;
    }

}
