package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.data.dao.entity.categoria;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.CategoriaEntity;

import java.util.UUID;

public interface CategoriaDao extends CreateDAO<CategoriaEntity>, RetrieveDAO<CategoriaEntity, UUID>, UpdateDAO<CategoriaEntity, UUID>, DeleteDAO<UUID> {
    // No additional methods are needed here as it inherits from the base interfaces


}
