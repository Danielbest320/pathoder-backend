package co.edu.uco.pathorder.dao.entity.horarioLocal;

import co.edu.uco.pathorder.data.dao.entity.CreateDAO;
import co.edu.uco.pathorder.data.dao.entity.RetrieveDAO;
import co.edu.uco.pathorder.data.dao.entity.UpdateDAO;
import co.edu.uco.pathorder.entity.HorarioLocalEntity;

import java.util.UUID;

public interface HorarioLocalDao extends CreateDAO <HorarioLocalEntity>, RetrieveDAO<HorarioLocalEntity, UUID>, UpdateDAO<HorarioLocalEntity, UUID> {
    // Define any additional methods specific to HorarioLocalDao here
    // For example, you might want to add methods for retrieving or updating HorarioLocal entities
    // public List<HorarioLocalEntity> retrieveAll();
    // public void update(HorarioLocalEntity entity);
    // public void delete(UUID id);
}
