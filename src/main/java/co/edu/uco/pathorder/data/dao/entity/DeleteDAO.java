package co.edu.uco.pathorder.data.dao.entity;

import co.edu.uco.pathorder.crosscutting.excepciones.PathOrderException;

import java.sql.SQLException;

public interface DeleteDAO<ID>{


    void delete (ID id) throws PathOrderException;



}
