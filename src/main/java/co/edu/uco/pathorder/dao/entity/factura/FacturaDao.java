package co.edu.uco.pathorder.dao.entity.factura;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.FacturaEntity;

import java.util.UUID;

public interface FacturaDao extends CreateDAO<FacturaEntity>, RetrieveDAO<FacturaEntity, UUID>, UpdateDAO<FacturaEntity, UUID>, DeleteDAO<UUID> {
}
