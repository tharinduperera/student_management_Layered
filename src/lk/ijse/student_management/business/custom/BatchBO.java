package lk.ijse.student_management.business.custom;

import lk.ijse.student_management.business.SuperBO;
import lk.ijse.student_management.util.BatchTM;
import lk.ijse.student_management.util.CourseTM;

import java.util.List;

public interface BatchBO extends SuperBO {

    public String getBatchId() throws Exception;

    public List<BatchTM> getAllBatches() throws Exception;

    public boolean saveBatch(BatchTM batchTM) throws Exception;

    public boolean deleteBatch(String bid) throws Exception;

    public boolean updateBatch(BatchTM batchTM) throws Exception;

    public BatchTM get(String bid)throws Exception;

    public BatchTM getbyName(String name)throws Exception;

    public List<BatchTM> searchAll(String key)throws Exception;

}
