package lk.ijse.student_management.dao.custom;

import lk.ijse.student_management.dao.CrudDAO;
import lk.ijse.student_management.entity.Batch;

public interface BatchDAO extends CrudDAO<Batch,String> {

    String getlastBatchId() throws Exception;

}
