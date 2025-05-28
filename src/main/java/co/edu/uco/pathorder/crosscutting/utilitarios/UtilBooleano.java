package co.edu.uco.pathorder.crosscutting.utilitarios;

public final class UtilBooleano {

    private static final boolean VALOR_DEFECTO = false;
    private static final UtilBooleano INSTANCIA = new UtilBooleano();

    private UtilBooleano() {
        super();
    }

    public static UtilBooleano getInstance() {
        return INSTANCIA;
    }

    public boolean obtenerValorDefecto(final Boolean valorOriginal, final boolean valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public boolean obtenerValorDefecto(final Boolean valor) {
        return obtenerValorDefecto(valor, VALOR_DEFECTO);
    }

    public boolean obtenerValorDefecto() {
        return VALOR_DEFECTO;
    }

    public boolean esValorDefecto(final Boolean valor) {
        return obtenerValorDefecto(valor, VALOR_DEFECTO) == VALOR_DEFECTO;
    }
}
