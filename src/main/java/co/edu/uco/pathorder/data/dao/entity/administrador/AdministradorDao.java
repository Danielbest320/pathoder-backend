package co.edu.uco.pathorder.data.dao.entity.administrador;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.AdministradorEntity;

import java.util.UUID;

public interface AdministradorDao
        extends CreateDAO<AdministradorEntity>, RetrieveDAO<AdministradorEntity, UUID>, UpdateDAO<AdministradorEntity, UUID> , DeleteDAO<UUID> {



}
