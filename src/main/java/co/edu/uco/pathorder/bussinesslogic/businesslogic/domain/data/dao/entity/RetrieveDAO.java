package co.edu.uco.pathorder.bussinesslogic.businesslogic.domain.data.dao.entity;

import java.util.List;

public interface RetrieveDAO<E, ID>{


    List<E> listByFilter(E entity);

    List<E> listAll();

    E listById(ID id);






}
