package co.edu.uco.pathorder.crosscutting.utilitarios;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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

    public LocalDate obtenerValorDefecto() {
        return FECHA_DEFECTO;
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

    public Date obtenerValorDefectoComoDate() {
        return Date.from(obtenerValorDefecto().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    public Date obtenerValorDefectoComoDate(final Date valorOriginal) {
        return (valorOriginal == null) ? obtenerValorDefectoComoDate() : valorOriginal;
    }
}