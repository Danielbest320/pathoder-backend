package co.edu.uco.pathorder.data.dao.entity;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.util.List;

public interface RetrieveDAO<E, ID>{


    List<E> listByFilter(E entity) throws PathOrderException;

    List<E> listAll() throws PathOrderException;

    E listById(ID id) throws PathOrderException;






}
