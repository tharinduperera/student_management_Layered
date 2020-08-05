package lk.ijse.student_management.dao;

import lk.ijse.student_management.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudUtil {

    public static <T> T execute(String sql,Object... params)throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement =connection.prepareStatement(sql);
        int i =0;
        for (Object param : params) {
            i++;
            statement.setObject(i,param);
        }
        if(sql.startsWith("SELECT")){
            return (T) statement.executeQuery();
        }
        return (T) ((Boolean) (statement.executeUpdate()>0));
    }

}
