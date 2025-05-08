package co.edu.uco.pathorder.entity;

import jdk.jfr.Timestamp;

import java.util.UUID;

public final class FacturaEntity {

    private UUID id;
    private AdministradorEntity administrador;
    private Timestamp fecha;
    private int total;

    public static FacturaEntity obtenerValorDefecto(FacturaEntity factura) {

    }
}
