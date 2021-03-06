package lk.ijse.student_management.dao.custom.impl;

import lk.ijse.student_management.dao.CrudUtil;
import lk.ijse.student_management.dao.custom.RegistrationDAO;
import lk.ijse.student_management.entity.Batch;
import lk.ijse.student_management.entity.BatchRegistrationPK;
import lk.ijse.student_management.entity.Registration;
import lk.ijse.student_management.util.RegistrationTM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public List<Registration> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Registration");
        List<Registration>registrations = new ArrayList<>();
        while (resultSet.next()){
            registrations.add(new Registration(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getBigDecimal(5)));
        }
        return registrations;
    }

    @Override
    public Registration find(BatchRegistrationPK key) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Registration WHERE rid = ? AND bid = ?",key.getRid(),key.getBid());
        if(resultSet.next()){
            return new Registration(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getBigDecimal(5));
        }
        return null;
    }

    @Override
    public boolean save(Registration entity) throws Exception {
        return CrudUtil.execute("INSERT INTO Registration VALUES(?,?,?,?,?)",entity.getBatchRegistrationPK().getRid(),entity.getBatchRegistrationPK().getBid(),entity.getNic(),entity.getRdate(),entity.getRfee());
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return CrudUtil.execute("UPDATE registration SET rdate=?,rfee=? WHERE rid=? AND bid = ?",entity.getRdate(),entity.getRfee(),entity.getBatchRegistrationPK().getRid(),entity.getBatchRegistrationPK().getBid());
    }

    @Override
    public boolean delete(BatchRegistrationPK key) throws Exception {
        return CrudUtil.execute("DELETE FROM Registration WHERE rid=? AND bid = ?",key.getRid(),key.getBid());
    }

    @Override
    public String getlastRegistrationId() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Registration ORDER BY rid DESC LIMIT 1");
        if (!resultSet.next()) {
            return null;
        } else {
            return resultSet.getString(1);
        }
    }

    @Override
    public Registration findbyRID(String rid) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Registration WHERE rid = ? ",rid);
        if(resultSet.next()){
            return new Registration(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getBigDecimal(5));
        }
        return null;
    }

    @Override
    public List<Registration> searchAll(String key) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Registration WHERE rid LIKE '%" + key + "%' OR bid LIKE '%" + key + "%' OR nic LIKE '%" + key + "%' OR rdate LIKE '%" + key + "%' OR rfee LIKE '%" + key + "%' GROUP BY rid,bid,nic,rdate,rfee");
        List<Registration> registrations = new ArrayList<>();
        while (resultSet.next()) {
            registrations.add(new Registration(resultSet.getString("rid"),
                    resultSet.getString("bid"),
                    resultSet.getString("nic"),
                    resultSet.getDate("rdate"),
                    resultSet.getBigDecimal("rfee")));
        }
        return registrations;
    }
}
