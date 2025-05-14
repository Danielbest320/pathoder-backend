package co.edu.uco.pathorder.data.dao.entity.inventario;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.InventarioEntity;

import java.util.UUID;

public interface InventarioDao extends CreateDAO <InventarioEntity>, RetrieveDAO<InventarioEntity, UUID>,UpdateDAO<InventarioEntity, UUID>, DeleteDAO<UUID> {
    // Define any additional methods specific to InventarioDao here
    // For example, you might want to add methods for retrieving or updating Inventario entities
    // public List<InventarioEntity> retrieveAll();
    // public void update(InventarioEntity entity);
    // public void delete(UUID id);
}
