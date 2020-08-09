package lk.ijse.student_management.dao.custom;

import lk.ijse.student_management.dao.CrudDAO;
import lk.ijse.student_management.entity.Batch;

import java.util.List;

public interface BatchDAO extends CrudDAO<Batch,String> {

    String getlastBatchId() throws Exception;

    public Batch getbyName(String name) throws Exception;

    public List<Batch> searchAll(String key)throws Exception;

}
