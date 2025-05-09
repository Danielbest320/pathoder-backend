package co.edu.uco.pathorder.crosscutting.utilitarios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class UtilFechaHora {

    private static final String FORMATO_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter FORMATEADOR = DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA);

    private static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.now();
    private static final UtilFechaHora instancia = new UtilFechaHora();

    private UtilFechaHora() {
        super();
    }

    public static UtilFechaHora getInstance() {
        return instancia;
    }

    public LocalDateTime obtenerValorDefecto(final LocalDateTime valorOriginal, final LocalDateTime valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public LocalDateTime obtenerValorDefecto(final LocalDateTime valorOriginal) {
        return obtenerValorDefecto(valorOriginal, obtenerValorDefecto());
    }

    public LocalDateTime obtenerValorDefecto() {
        return FECHA_HORA_DEFECTO;
    }

    public String obtenerValorDefectoComoTexto() {
        return FECHA_HORA_DEFECTO.format(FORMATEADOR);
    }

    public boolean esValorDefecto(final LocalDateTime fechaHora) {
        return obtenerValorDefecto(fechaHora).isEqual(obtenerValorDefecto());
    }

    public LocalDateTime convertirTextoAFechaHora(final String fechaHoraTexto) {
        try {
            final String texto = UtilTexto.getInstance().obtenerValorDefecto(fechaHoraTexto, obtenerValorDefectoComoTexto());
            return LocalDateTime.parse(texto, FORMATEADOR);
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
