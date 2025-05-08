package co.edu.uco.pathorder.crosscutting.utilitarios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class UtilFechaHora {

    private static final String FORMATO_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter FORMATEADOR = DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA);
    private static final String FECHA_HORA_DEFECTO_TEXTO = "2000-01-01 00:00:00";

    private static UtilFechaHora instancia = new UtilFechaHora();

    private UtilFechaHora() {
        super();
    }

    public static UtilFechaHora getInstance() {
        return instancia;
    }

    public LocalDateTime obtenerValorDefecto(final LocalDateTime original, final LocalDateTime defecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(original, defecto);
    }

    public LocalDateTime obtenerValorDefecto(final LocalDateTime original) {
        return obtenerValorDefecto(original, obtenerValorDefecto());
    }

    public LocalDateTime obtenerValorDefecto() {
        return LocalDateTime.parse(FECHA_HORA_DEFECTO_TEXTO, FORMATEADOR);
    }

    public String obtenerValorDefectoComoTexto() {
        return FECHA_HORA_DEFECTO_TEXTO;
    }

    public boolean esValorDefecto(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora).isEqual(obtenerValorDefecto());
    }

    public LocalDateTime convertirTextoAFechaHora(final String texto) {
        try {
            final String valorTexto = UtilTexto.getInstance().obtenerValorDefecto(texto, FECHA_HORA_DEFECTO_TEXTO);
            return LocalDateTime.parse(valorTexto, FORMATEADOR);
        } catch (DateTimeParseException e) {
            return obtenerValorDefecto();
        }
    }

    public String convertirFechaHoraATexto(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora).format(FORMATEADOR);
    }

    public LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    public String obtenerFechaHoraActualComoTexto() {
        return obtenerFechaHoraActual().format(FORMATEADOR);
    }
}

