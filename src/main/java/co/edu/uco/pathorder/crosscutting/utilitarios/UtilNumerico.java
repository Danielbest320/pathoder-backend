package co.edu.uco.pathorder.crosscutting.utilitarios;

public final class UtilNumerico {

    private static UtilNumerico instancia = new UtilNumerico();
    public final static int numerico = 0;

    private UtilNumerico (){
        super();
    }

    public static UtilNumerico  getInstance() {
        return instancia;
    }

    public boolean esNula(final int valor) {

        return UtilObjeto.getInstance().esNulo(valor);
    };

    public int obtenerValorDefecto(final int valorOriginal, final int valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public int obtenerValorDefecto(final int valor) {
        return obtenerValorDefecto (valor, numerico);
    }

    public int obtenerValorDefecto() {
        return numerico;
    }

}
