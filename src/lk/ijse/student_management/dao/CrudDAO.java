package lk.ijse.student_management.dao;

import lk.ijse.student_management.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO <T extends SuperEntity,ID extends Serializable>extends SuperDAO{

    List<T> getAll() throws Exception;

    T find(ID key) throws Exception;

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID key) throws Exception;

}
