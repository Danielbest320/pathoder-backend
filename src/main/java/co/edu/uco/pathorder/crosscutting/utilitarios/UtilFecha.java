package co.edu.uco.pathorder.crosscutting.utilitarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class UtilFecha {

    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final DateTimeFormatter FORMATEADOR = DateTimeFormatter.ofPattern(FORMATO_FECHA);

    // Por defecto: ahora es la fecha actual
    private static final LocalDate FECHA_DEFECTO = LocalDate.now();
    private static final UtilFecha instancia = new UtilFecha();

    private UtilFecha() {
        super();
    }

    public static UtilFecha getInstance() {
        return instancia;
    }

    public LocalDate obtenerValorDefecto(final LocalDate valorOriginal, final LocalDate valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public LocalDate obtenerValorDefecto(final LocalDate valorOriginal) {
        return obtenerValorDefecto(valorOriginal, obtenerValorDefecto());
    }
    public boolean esNula(final int valor) {
        return UtilObjeto.getInstance().esNulo(valor);
    };

    public LocalDate obtenerValorDefecto() {
        return FECHA_DEFECTO;
    public Date obtenerValorDefecto(final Date valorOriginal, final Date valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public String obtenerValorDefectoComoTexto() {
        return FECHA_DEFECTO.format(FORMATEADOR);
    }

    public boolean esValorDefecto(final LocalDate fecha) {
        return obtenerValorDefecto(fecha).isEqual(obtenerValorDefecto());
    }

    public LocalDate convertirTextoAFecha(final String fechaTexto) {
        try {
            final String texto = UtilTexto.getInstance().obtenerValorDefecto(fechaTexto, obtenerValorDefectoComoTexto());
            return LocalDate.parse(texto, FORMATEADOR);
        } catch (DateTimeParseException e) {
            return obtenerValorDefecto();
        }
    }

    public String convertirFechaATexto(final LocalDate fecha) {
        return obtenerValorDefecto(fecha).format(FORMATEADOR);
    }

    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    public String obtenerFechaActualComoTexto() {
        return obtenerFechaActual().format(FORMATEADOR);
    }
}
