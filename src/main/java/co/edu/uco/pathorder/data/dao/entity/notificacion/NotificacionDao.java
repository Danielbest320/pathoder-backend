package co.edu.uco.pathorder.data.dao.entity.notificacion;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.DeleteDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.UsuarioEntity;

import java.util.UUID;

public interface NotificacionDao extends CreateDAO<UsuarioEntity>, RetrieveDAO<UsuarioEntity, UUID>, UpdateDAO<UsuarioEntity, UUID>, DeleteDAO<UUID> {
}
