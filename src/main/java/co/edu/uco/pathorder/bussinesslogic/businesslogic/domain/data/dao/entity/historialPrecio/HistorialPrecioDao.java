package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.data.dao.entity.historialPrecio;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.entity.HistorialPrecioEntity;

import java.util.UUID;

public interface HistorialPrecioDao extends CreateDAO <HistorialPrecioEntity>, RetrieveDAO<HistorialPrecioEntity, UUID> {
    // Define any additional methods specific to HistorialPrecioDao here
    // For example, you might want to add methods for retrieving or updating HistorialPrecio entities
    // public List<HistorialPrecioEntity> retrieveAll();
    // public void update(HistorialPrecioEntity entity);
    // public void delete(UUID id);
}
