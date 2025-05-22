package co.edu.uco.pathorder.dao.entity.tiponotificacion;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.TipoNotificacionEntity;

import java.util.UUID;

public interface TipoNotificacionDao extends CreateDAO<TipoNotificacionEntity>, RetrieveDAO<TipoNotificacionEntity, UUID>, UpdateDAO<TipoNotificacionEntity, UUID>, DeleteDAO<UUID> {
}
