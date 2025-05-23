package co.edu.uco.pathorder.bussinesslogic.businesslogic.impl;

import co.edu.uco.pathorder.bussinesslogic.businesslogic.AdministradorBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.AdministradorDomain;
import co.edu.uco.pathorder.bussinesslogic.mapper.AdministradorMapper;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.entity.AdministradorEntity;

import java.util.List;
import java.util.UUID;

public class AdminisntradorBusinessLogicImpl  implements AdministradorBusinessLogic {

    private final DAOFactory factory;

    public AdminisntradorBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;

    }


    @Override
    public void registrarNuevoAdministrador(AdministradorDomain administrador) throws PathOrderException {
        AdministradorEntity administradorEntity = AdministradorMapper.toEntity(administrador);
        factory.getAdministradorDAO().create(administradorEntity);



    }

    @Override
    public void modificarAdministradorExistente(UUID id, AdministradorDomain administrador) throws PathOrderException {
        AdministradorEntity administradorEntity = AdministradorMapper.toEntity(administrador);
        factory.getAdministradorDAO().update(id,administradorEntity);

    }

    @Override
    public void darbajaDefinitivamenteAdministradorExistente(UUID id) throws PathOrderException {
        factory.getAdministradorDAO().delete(id);

    }

    @Override
    public AdministradorDomain consultarAdministradorPorId(UUID id) throws PathOrderException {
        return null;
    }

    @Override
    public List<AdministradorDomain> consultarAdministradores(AdministradorDomain filtro) throws PathOrderException {
        AdministradorEntity administradorFilter = AdministradorMapper.toEntity(filtro);
        List<AdministradorEntity> AdministradorEntities = factory.getAdministradorDAO().listByFilter(administradorFilter);
        List<AdministradorDomain> datosARetornar = AdministradorMapper.toDomainList(AdministradorEntities);

        return datosARetornar;
    }
}
