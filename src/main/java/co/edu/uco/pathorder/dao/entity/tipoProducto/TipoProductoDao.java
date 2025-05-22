package co.edu.uco.pathorder.dao.entity.tipoProducto;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.entity.TipoProductoEntity;

import java.util.UUID;

public interface TipoProductoDao extends CreateDAO <TipoProductoEntity>, RetrieveDAO<TipoProductoEntity, UUID> {

    // Define any additional methods specific to TipoProductoDao here
    // For example, you might want to add methods for retrieving or updating TipoProducto entities
    // public List<TipoProductoEntity> retrieveAll();
    // public void update(TipoProductoEntity entity);
    // public void delete(UUID id);
}
