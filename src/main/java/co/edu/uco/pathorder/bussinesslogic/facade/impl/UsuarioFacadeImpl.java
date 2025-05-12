package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.UsuarioBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.UsuarioBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.UsuarioFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.UsuarioDTO;

import java.util.List;
import java.util.UUID;

public class UsuarioFacadeImpl  implements UsuarioFacade {

    private DAOFactory daoFactory;
    private UsuarioBusinessLogic usuarioBusinessLogic;


    public UsuarioFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        usuarioBusinessLogic = new UsuarioBusinessLogicImpl(daoFactory);

    }


    @Override
    public void registrarNuevoUsuario(UsuarioDTO usuario) {

    }

    @Override
    public void modificarUsuarioExistente(UUID id, UsuarioDTO usuario) {

    }

    @Override
    public void darbajaDefinitivamenteUsuarioExistente(UUID id) {

    }

    @Override
    public UsuarioDTO consultarUsuarioPorId(UUID id) {
        return null;
    }

    @Override
    public List<UsuarioDTO> consultarUsuarios(UsuarioDTO filtro) {
        return null;
    }
}
