package co.edu.uco.pathorder.dao.entity.reserva;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.ReservaEntity;

import java.util.UUID;

public interface ReservaDao  extends CreateDAO<ReservaEntity>, RetrieveDAO<ReservaEntity, UUID> , UpdateDAO<ReservaEntity,UUID>, DeleteDAO<UUID> {

}
