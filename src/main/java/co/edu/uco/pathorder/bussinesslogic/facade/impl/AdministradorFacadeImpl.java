package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.AdminisntradorBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.AdministradorFacade;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.AdministradorDTO;

import java.util.List;
import java.util.UUID;

public class AdministradorFacadeImpl  implements AdministradorFacade {

    private final DAOFactory daoFactory;
    private final AdministradorBusinessLogic administradorBusinessLogic;

    public AdministradorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        administradorBusinessLogic = new AdminisntradorBusinessLogicImpl(daoFactory);
    }



    @Override
    public void registrarNuevoAdministrador(AdministradorDTO administrador) {

    }

    @Override
    public void modificarAdministradorExistente(UUID id, AdministradorDTO administrador) {

    }

    @Override
    public void darbajaDefinitivamenteAdministradorExistente(UUID id) {

    }

    @Override
    public AdministradorDTO consultarAdministradorPorId(UUID id) {
        return null;
    }

    @Override
    public List<AdministradorDTO> consultarAdministradores(AdministradorDTO filtro) {
        return null;
    }
}
