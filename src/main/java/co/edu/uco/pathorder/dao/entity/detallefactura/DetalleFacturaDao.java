package co.edu.uco.pathorder.dao.entity.detallefactura;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.DetalleFacturaEntity;

import java.util.UUID;

public interface DetalleFacturaDao extends CreateDAO<DetalleFacturaEntity>, RetrieveDAO<DetalleFacturaEntity, UUID>, UpdateDAO<DetalleFacturaEntity, UUID>, DeleteDAO<UUID> {
}
