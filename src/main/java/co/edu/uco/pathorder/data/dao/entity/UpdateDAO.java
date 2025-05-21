package co.edu.uco.pathorder.data.dao.entity;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

public interface UpdateDAO<E, ID>{


    void update (ID id, E entity) throws PathOrderException;





}
