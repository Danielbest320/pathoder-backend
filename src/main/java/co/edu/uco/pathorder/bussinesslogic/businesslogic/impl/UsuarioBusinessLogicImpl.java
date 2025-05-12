package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.UsuarioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.UsuarioDomain;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.UsuarioEntity;

import java.util.List;
import java.util.UUID;

public class UsuarioBusinessLogicImpl implements UsuarioBusinessLogic {

    private final DAOFactory factory;

    public UsuarioBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoUsuario(UsuarioDomain usuario) {
        UsuarioEntity usuarioEntity = null;
        factory.getUsuarioDAO().create(usuarioEntity);
    }

    @Override
    public void modificarUsuarioExistente(UUID id, UsuarioDomain usuario) {
        UsuarioEntity usuarioEntity = null;
        factory.getUsuarioDAO().update(id, usuarioEntity);
    }

    @Override
    public void darbajaDefinitivamenteUsuarioExistente(UUID id) {
        factory.getUsuarioDAO().delete(id);
    }

    @Override
    public UsuarioDomain consultarUsuarioPorId(UUID id) {
        return null;
    }

    @Override
    public List<UsuarioDomain> consultarUsuarios(UsuarioDomain filtro) {
        UsuarioEntity usuarioFilter = null;
        List<UsuarioEntity> usuarioEntities = factory.getUsuarioDAO().listByFilter(usuarioFilter);
        List<UsuarioDomain> datosARetornar = null;

        return datosARetornar;
    }
}
