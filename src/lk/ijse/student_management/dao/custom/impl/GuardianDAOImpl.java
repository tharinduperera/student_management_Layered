package lk.ijse.student_management.dao.custom.impl;

import lk.ijse.student_management.dao.CrudUtil;
import lk.ijse.student_management.dao.custom.GuardianDAO;
import lk.ijse.student_management.entity.Guardian;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuardianDAOImpl implements GuardianDAO {
    @Override
    public List<Guardian> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Guardian");
        List<Guardian> guardians = new ArrayList<>();
        while (resultSet.next()){
            guardians.add(new Guardian(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)));
        }
        return guardians;
    }

    @Override
    public Guardian find(String key) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Guardian WHERE sdnic = ?",key);
        if(resultSet.next()){
            return new Guardian(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8));
        }
        return null;
    }

    @Override
    public boolean save(Guardian entity) throws Exception {
        return CrudUtil.execute("INSERT INTO Guardian VALUES(?,?,?,?,?,?,?,?)",entity.getSdnic(),entity.getGid(),entity.getGname(),entity.getGaddress(),entity.getGtel(),entity.getGemail(),entity.getDesignation(),entity.getWorkplace());
    }

    @Override
    public boolean update(Guardian entity) throws Exception {
        return CrudUtil.execute("UPDATE guardian SET gname=?,gaddress=?,gtel=?,gemail=?,designation=?,workplace=? WHERE gid=?",entity.getGid(),entity.getGname(),entity.getGaddress(),entity.getGtel(),entity.getGemail(),entity.getDesignation(),entity.getWorkplace(),entity.getSdnic());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Guardian WHERE sdnic = ?",key);
    }

    @Override
    public String getlastGuardianId() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Guardian ORDER BY gid DESC LIMIT 1");
        if (!resultSet.next()) {
            return null;
        } else {
            return resultSet.getString(1);
        }
    }
}
