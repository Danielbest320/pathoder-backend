package co.edu.uco.pathorder.bussinesslogic.facade.impl;

import co.edu.uco.pathorder.bussinesslogic.assembler.horarioLocal.dto.HorarioLocalDTOAssembler;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.HorarioLocalBusinessLogic;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.HorarioLocalDomain;
import co.edu.uco.pathorder.bussinesslogic.businesslogic.impl.HorarioLocalBusinessLogicImpl;
import co.edu.uco.pathorder.bussinesslogic.facade.HorarioLocalFacade;
import co.edu.uco.pathorder.crosscutting.excepciones.BusinessLogicPathOrderException;
import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;
import co.edu.uco.pathorder.data.dao.factory.DAOFactory;
import co.edu.uco.pathorder.data.dao.factory.Factory;
import co.edu.uco.pathorder.dto.HorarioLocalDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HorarioLocalFacadeImpl implements HorarioLocalFacade {

    private DAOFactory daoFactory;
    private HorarioLocalBusinessLogic horarioLocalBusinessLogic;


    public HorarioLocalFacadeImpl() throws PathOrderException {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRES_SQL);
        horarioLocalBusinessLogic = new HorarioLocalBusinessLogicImpl(daoFactory);

    }

    @Override
    public void registrarHorarioLocal(HorarioLocalDTO horarioLocal) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            HorarioLocalDomain domain = HorarioLocalDTOAssembler.getInstance().toDomain(horarioLocal);
            horarioLocalBusinessLogic.registrarHorarioLocal(domain);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un error inesperado al registrar el horario del local.";
            var mensajeTecnico = "Excepción no controlada al registrar horario local.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void modificarHorarioLocal(HorarioLocalDTO horarioLocal, UUID id) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            HorarioLocalDomain domain = HorarioLocalDTOAssembler.getInstance().toDomain(horarioLocal);
            horarioLocalBusinessLogic.modificarHorarioLocal(domain, id);

            daoFactory.confirmartransaccion();
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un error inesperado al modificar el horario del local.";
            var mensajeTecnico = "Excepción no controlada al modificar horario local.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public List<HorarioLocalDTO> consultarDisponibilidadHorario(HorarioLocalDTO filtro) throws PathOrderException {
        try {
            daoFactory.iniciartransaccion();

            HorarioLocalDomain domain = HorarioLocalDTOAssembler.getInstance().toDomain(filtro);
            List<HorarioLocalDomain> resultado = horarioLocalBusinessLogic.consultarDisponibilidadHorario(domain);

            daoFactory.confirmartransaccion();
            return HorarioLocalDTOAssembler.getInstance().toDTOs(resultado);
        } catch (final PathOrderException exception) {
            daoFactory.cancelartransaccion();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeUsuario = "Se presentó un error inesperado al consultar la disponibilidad de horario.";
            var mensajeTecnico = "Excepción no controlada al consultar disponibilidad de horario del local.";
            throw BusinessLogicPathOrderException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
