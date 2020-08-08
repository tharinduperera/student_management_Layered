package lk.ijse.student_management.business.custom.impl;

import lk.ijse.student_management.business.custom.BatchBO;
import lk.ijse.student_management.dao.DAOFactory;
import lk.ijse.student_management.dao.DAOTypes;
import lk.ijse.student_management.dao.custom.BatchDAO;
import lk.ijse.student_management.entity.Batch;
import lk.ijse.student_management.util.BatchTM;

import java.util.ArrayList;
import java.util.List;

public class BatchBOImpl implements BatchBO {

    BatchDAO batchDAO = DAOFactory.getInstance().getDAO(DAOTypes.BATCH);

    @Override
    public String getBatchId() throws Exception {
        String lastBatchId = batchDAO.getlastBatchId();
        if (lastBatchId == null) {
            return "B001";
        } else {
            int maxId = Integer.parseInt(lastBatchId.replace("B", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "B00" + maxId;
            } else if (maxId < 100) {
                id = "B0" + maxId;
            } else {
                id = "B" + maxId;
            }
            return id;
        }
    }

    @Override
    public List<BatchTM> getAllBatches() throws Exception {
        List<Batch> allbBatches = batchDAO.getAll();
        List<BatchTM> batchTMS = new ArrayList<>();
        for (Batch batch : allbBatches) {
            batchTMS.add(new BatchTM(batch.getBid(),batch.getBname(),batch.getCid(),batch.getCname(),batch.getStartdate()));
        }
        return batchTMS;
    }

    @Override
    public boolean saveBatch(BatchTM batchTM) throws Exception {
        return batchDAO.save(new Batch(batchTM.getBid(),batchTM.getBname(),batchTM.getCid(),batchTM.getCname(),batchTM.getStartdate()));
    }

    @Override
    public boolean deleteBatch(String bid) throws Exception {
        return batchDAO.delete(bid);
    }

    @Override
    public boolean updateBatch(BatchTM batchTM) throws Exception {
        return batchDAO.update(new Batch(batchTM.getBid(),batchTM.getBname(),batchTM.getCid(),batchTM.getCname(),batchTM.getStartdate()));
    }
}
