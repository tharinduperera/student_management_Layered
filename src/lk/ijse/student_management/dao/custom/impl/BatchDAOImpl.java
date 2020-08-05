package lk.ijse.student_management.dao.custom.impl;

import lk.ijse.student_management.dao.CrudUtil;
import lk.ijse.student_management.dao.custom.BatchDAO;
import lk.ijse.student_management.db.DBConnection;
import lk.ijse.student_management.entity.Batch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BatchDAOImpl implements BatchDAO {

    Connection connection = DBConnection.getInstance().getConnection();
    @Override
    public List<Batch> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM BATCH");
        List<Batch>batches = new ArrayList<>();
        while (resultSet.next()){
            batches.add(new Batch(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5)));
        }
        return batches;
    }

    @Override
    public Batch find(String key) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM BATCH WHERE bid = ?",key);
        if(resultSet.next()){
            return new Batch(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5));
        }
        return null;
    }

    @Override
    public boolean save(Batch entity) throws Exception {
        return CrudUtil.execute("INSERT INTO Batch VALUES (?,?,?,?,?)", entity.getBid(), entity.getBname(), entity.getCid(), entity.getCname(), entity.getStartdate());
    }

    @Override
    public boolean update(Batch entity) throws Exception {
        return CrudUtil.execute("UPDATE Batch SET bname=?,startdate=? WHERE bid=?",entity.getBname(),entity.getStartdate(),entity.getBid());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Batch WHERE bid = ?",key);
    }
}
