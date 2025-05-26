package co.edu.uco.pathorder.data.dao.entity.historialPrecio;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.HistorialPrecioEntity;

import java.util.UUID;

public interface HistorialPrecioDao extends CreateDAO <HistorialPrecioEntity>, RetrieveDAO<HistorialPrecioEntity, UUID>, UpdateDAO<HistorialPrecioEntity, UUID> {

}
