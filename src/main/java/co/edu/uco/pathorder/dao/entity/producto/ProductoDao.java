package co.edu.uco.pathorder.dao.entity.producto;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.ProductoEntity;

import java.util.UUID;

public interface ProductoDao extends CreateDAO <ProductoEntity>, RetrieveDAO<ProductoEntity, UUID>, UpdateDAO<ProductoEntity, UUID>, DeleteDAO<UUID> {
    // Define any additional methods specific to ProductoDao here
    // For example, you might want to add methods for retrieving or updating Producto entities
    // public List<ProductoEntity> retrieveAll();
    // public void update(ProductoEntity entity);
    // public void delete(UUID id);
}
