package co.edu.uco.pathorder.crosscutting.utilitarios;

import java.util.regex.Pattern;

public final class UtilTexto {

    private static UtilTexto instancia = new UtilTexto();
    private static final String PATRON_SOLO_LETRAS_ESPACIOS = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$";
    public final static String VACIO = "";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    private static final Pattern PATRON_CONTRASENA = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$"
    );

    private UtilTexto (){

    }

    public static UtilTexto  getInstance() {
        return instancia;
    }

    public boolean patronEsValido(final String valor, final String patron) {
        return obtenerValorDefecto(valor).matches(obtenerValorDefecto(patron));
    }

    public boolean contieneSoloLetrasEspacios(final String valor) {
        return patronEsValido(quitarEspacioBlancoInicioFin(valor), PATRON_SOLO_LETRAS_ESPACIOS);
    }

    public boolean esNula(final String valor) {
        return UtilObjeto.getInstance().esNulo(valor);
    }

    public boolean esVacio(final String valor) {
        return VACIO.equals(quitarEspacioBlancoInicioFin(valor));
    }

    public String obtenerValorDefecto(final String valorOriginal, final String valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public String obtenerValorDefecto(final String valor) {
        return obtenerValorDefecto (valor, VACIO);
    }


    public String obtenerValorDefecto() {
        return VACIO;
    }

    public String quitarEspacioBlancoInicioFin(final String valor) {
        return obtenerValorDefecto(valor).trim();
    }


    public  boolean esValorDefecto(final String valor) {
        return obtenerValorDefecto(valor).equals(obtenerValorDefecto());
    }

    public boolean longitudValida(final String valor, int min, int max) {
        String limpio = quitarEspacioBlancoInicioFin(valor);      // ya maneja null → ""
        int len = limpio.length();
        return len >= min && len <= max;
    }


    public boolean esEmailValido(String email) {
        if (esVacio(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }


    public boolean esContrasenaValida(String contrasena) {
        if (esVacio(contrasena)) return false;
        return PATRON_CONTRASENA.matcher(contrasena.trim()).matches();
    }


}