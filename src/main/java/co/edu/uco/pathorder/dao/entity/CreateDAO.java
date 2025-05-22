package co.edu.uco.pathorder.dao.entity;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

public interface CreateDAO <E>{


    void create (E entity) throws PathOrderException;





}
