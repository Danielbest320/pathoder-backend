package co.edu.uco.pathorder.data.dao.entity.cliente.impl.postgresql;

import co.edu.uco.pathorder.crosscutting.excepciones.DataPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.pathorder.data.dao.entity.cliente.ClienteDao;
import co.edu.uco.pathorder.entity.ClienteEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientePostgreSQLDAO implements ClienteDao {

    private final Connection conexion;

    public ClientePostgreSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(ClienteEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Cliente(id, di, nombre, apellido, correo, telefono, contrasena,confirmacion_correo, confirmacion_telefono, estado_cuenta) VALUES(?,?,?,?,?,?,?,?,?,?);");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getDi());
            sentenciaPreparada.setObject(3, entity.getNombre());
            sentenciaPreparada.setObject(4, entity.getApellido());
            sentenciaPreparada.setObject(5, entity.getCorreo());
            sentenciaPreparada.setObject(6, entity.getTelefono());
            sentenciaPreparada.setObject(7, entity.getContrasena());
            sentenciaPreparada.setObject(8, entity.isConfirmacionCorreo());
            sentenciaPreparada.setObject(9, entity.isConfirmacionTelefono());
            sentenciaPreparada.setObject(10, entity.isEstadoCuenta());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al registrar un nuevo cliente.";
            var mensajeUsuario = "No se pudo registrar el cliente.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al registrar un nuevo cliente.";
            var mensajeUsuario = "Ocurrió un error inesperado al registrar el cliente.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void delete(UUID uuid) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Cliente WHERE id = ?");
        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al eliminar un cliente.";
            var mensajeUsuario = "No se pudo eliminar el cliente.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al eliminar un cliente.";
            var mensajeUsuario = "Ocurrió un error inesperado al eliminar el cliente.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public List<ClienteEntity> listByFilter(ClienteEntity entity) throws PathOrderException {
        var listaClientes = new ArrayList<ClienteEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, di, nombre, apellido, correo, telefono, contrasena,confirmacion_correo, confirmacion_telefono, estado_cuenta FROM Cliente WHERE 1=1");

        var filtrarId = entity != null && entity.getId() != null;
        var filtrarCorreo = entity != null && entity.getCorreo() != null && !entity.getCorreo().isBlank();

        if (filtrarId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarCorreo) {
            sentenciaSQL.append(" AND correo LIKE ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            var parametroIndex = 1;

            if (filtrarId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarCorreo) {
                sentenciaPreparada.setObject(parametroIndex++, "%" + entity.getCorreo().trim() + "%");
            }

            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                while (cursorResultado.next()) {
                    var cliente = new ClienteEntity();
                    cliente.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    cliente.setDi(cursorResultado.getString("di"));
                    cliente.setNombre(cursorResultado.getString("nombre"));
                    cliente.setApellido(cursorResultado.getString("apellido"));
                    cliente.setCorreo(cursorResultado.getString("correo"));
                    cliente.setTelefono(cursorResultado.getString("telefono"));
                    cliente.setContrasena(cursorResultado.getString("contrasena"));
                    cliente.setConfirmacionCorreo(cursorResultado.getBoolean("confirmacion_correo"));
                    cliente.setConfirmacionTelefono(cursorResultado.getBoolean("confirmacion_telefono"));
                    cliente.setEstadoCuenta(cursorResultado.getBoolean("estado_cuenta"));
                    listaClientes.add(cliente);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al consultar clientes filtrados.";
            var mensajeUsuario = "No se pudo consultar la lista de clientes.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar clientes filtrados.";
            var mensajeUsuario = "Ocurrió un error inesperado al consultar clientes.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaClientes;
    }

    @Override
    public List<ClienteEntity> listAll() throws PathOrderException {
        var listaClientes = new ArrayList<ClienteEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, di, nombre, apellido, correo, telefono, contrasena,confirmacion_correo, confirmacion_telefono, estado_cuenta FROM Cliente");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursorResultado = sentenciaPreparada.executeQuery()) {
            while (cursorResultado.next()) {
                var cliente = new ClienteEntity();
                cliente.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                cliente.setDi(cursorResultado.getString("di"));
                cliente.setNombre(cursorResultado.getString("nombre"));
                cliente.setApellido(cursorResultado.getString("apellido"));
                cliente.setCorreo(cursorResultado.getString("correo"));
                cliente.setTelefono(cursorResultado.getString("telefono"));
                cliente.setContrasena(cursorResultado.getString("contrasena"));
                cliente.setConfirmacionCorreo(cursorResultado.getBoolean("confirmacion_correo"));
                cliente.setConfirmacionTelefono(cursorResultado.getBoolean("confirmacion_telefono"));
                cliente.setEstadoCuenta(cursorResultado.getBoolean("estado_cuenta"));
                listaClientes.add(cliente);
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al listar todos los clientes.";
            var mensajeUsuario = "No se pudo obtener la lista de clientes.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al listar todos los clientes.";
            var mensajeUsuario = "Ocurrió un error inesperado al listar clientes.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaClientes;
    }

    @Override
    public ClienteEntity listById(UUID uuid) throws PathOrderException {
        var clienteEntityRetorno = new ClienteEntity();
        var sentenciaSQL =new  StringBuilder();
        sentenciaSQL.append("SELECT id, di, nombre, apellido, correo, telefono, contrasena,confirmacion_correo, confirmacion_telefono, estado_cuenta FROM Cliente WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, uuid);
            try (var cursorResultado = sentenciaPreparada.executeQuery()) {
                if (cursorResultado.next()) {
                    clienteEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultado.getString("id")));
                    clienteEntityRetorno.setDi(cursorResultado.getString("di"));
                    clienteEntityRetorno.setNombre(cursorResultado.getString("nombre"));
                    clienteEntityRetorno.setApellido(cursorResultado.getString("apellido"));
                    clienteEntityRetorno.setCorreo(cursorResultado.getString("correo"));
                    clienteEntityRetorno.setTelefono(cursorResultado.getString("telefono"));
                    clienteEntityRetorno.setContrasena(cursorResultado.getString("contrasena"));
                    clienteEntityRetorno.setConfirmacionCorreo(cursorResultado.getBoolean("confirmacion_correo"));
                    clienteEntityRetorno.setConfirmacionTelefono(cursorResultado.getBoolean("confirmacion_telefono"));
                    clienteEntityRetorno.setEstadoCuenta(cursorResultado.getBoolean("estado_cuenta"));
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al consultar cliente por ID.";
            var mensajeUsuario = "No se pudo obtener el cliente solicitado.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al consultar cliente por ID.";
            var mensajeUsuario = "Ocurrió un error inesperado al obtener el cliente.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return clienteEntityRetorno;
    }

    @Override
    public void update(UUID uuid, ClienteEntity entity) throws PathOrderException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Cliente SET di = ?, nombre = ?, apellido = ?, correo = ?, telefono = ?,contrasena = ?, confirmacion_correo = ?, confirmacion_telefono = ?, estado_cuenta = ? WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, entity.getDi());
            sentenciaPreparada.setObject(2, entity.getNombre());
            sentenciaPreparada.setObject(3, entity.getApellido());
            sentenciaPreparada.setObject(4, entity.getCorreo());
            sentenciaPreparada.setObject(5, entity.getTelefono());
            sentenciaPreparada.setObject(6, entity.getContrasena());
            sentenciaPreparada.setObject(7, entity.isConfirmacionCorreo());
            sentenciaPreparada.setObject(8, entity.isConfirmacionTelefono());
            sentenciaPreparada.setObject(9, entity.isEstadoCuenta());
            sentenciaPreparada.setObject(10, uuid);
            sentenciaPreparada.executeUpdate();
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una SQLException al actualizar un cliente.";
            var mensajeUsuario = "No se pudo actualizar el cliente.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA al actualizar un cliente.";
            var mensajeUsuario = "Ocurrió un error inesperado al actualizar el cliente.";
            throw DataPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }
}
