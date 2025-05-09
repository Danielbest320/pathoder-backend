package co.edu.uco.pathorder.crosscutting.utilitarios;

public final class UtilPrecio {

    private static final int PRECIO_DEFECTO = 0;
    private static final UtilPrecio instancia = new UtilPrecio();

    private UtilPrecio() {
        super();
    }

    public static UtilPrecio getInstance() {
        return instancia;
    }

    public int obtenerValorDefecto(final Integer valorOriginal, final int valorDefecto) {
        return (valorOriginal == null || valorOriginal < 0) ? valorDefecto : valorOriginal;
    }

    public int obtenerValorDefecto(final Integer valorOriginal) {
        return obtenerValorDefecto(valorOriginal, obtenerValorDefecto());
    }

    public int obtenerValorDefecto() {
        return PRECIO_DEFECTO;
    }

    public boolean esValorDefecto(final Integer precio) {
        return obtenerValorDefecto(precio) == PRECIO_DEFECTO;
    }

    public int convertirTextoAPrecio(final String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException | NullPointerException e) {
            return obtenerValorDefecto();
        }
    }

    public String convertirPrecioATexto(final Integer precio) {
        return String.valueOf(obtenerValorDefecto(precio));
    }
}
