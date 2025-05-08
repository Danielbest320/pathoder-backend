package co.edu.uco.pathorder.crosscutting.utilitarios;

import java.time.LocalDateTime;

public final class UtilFecha {
    //Voy a cambiar esto para que ponga la fecha actual por defecto
    private static UtilFecha instancia = new UtilFecha();
    public final static LocalDateTime fecha = LocalDateTime.of(2025, 10, 15, 10, 30);

    private UtilFecha (){
        super();
    }

    public static UtilFecha  getInstance() {
        return instancia;
    }

    public boolean esNula(final int valor) {
        return UtilObjeto.getIntance().esNulo(valor);
    };

    public Date obtenerValorDefecto(final Date valorOriginal, final Date valorDefecto) {
        return UtilObjeto.getIntance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public Date obtenerValorDefecto(final Date valor) {
        return obtenerValorDefecto (valor, fecha);
    }

    public Date obtenerValorDefecto() {
        return fecha;
    }

}
