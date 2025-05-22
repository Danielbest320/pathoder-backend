package co.edu.uco.pathorder.dao.entity.reservaproducto;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.ReservaProductoEntity;

import java.util.UUID;

public interface ReservaProductoDao extends CreateDAO<ReservaProductoEntity>, RetrieveDAO<ReservaProductoEntity, UUID>, UpdateDAO<ReservaProductoEntity, UUID>, DeleteDAO<UUID> {
}
