package co.edu.uco.pathorder.data.dao.entity.ingredienteProducto;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.IngredienteProductoEntity;

import java.util.UUID;

public interface IngredienteProductoDao extends CreateDAO<IngredienteProductoEntity>, RetrieveDAO<IngredienteProductoEntity, UUID>, UpdateDAO<IngredienteProductoEntity, UUID>, DeleteDAO<UUID> {
    // Define any additional methods specific to IngredienteProductoDao here
    // For example, you might want to add methods for retrieving or updating IngredienteProducto entities
    // public List<IngredienteProductoEntity> retrieveAll();
    // public void update(IngredienteProductoEntity entity);
    // public void delete(UUID id);
}
