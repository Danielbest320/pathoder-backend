package co.edu.uco.pathorder.dao.entity;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

public interface DeleteDAO<ID>{


    void delete (ID id) throws PathOrderException;



}
