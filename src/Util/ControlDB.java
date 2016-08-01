package Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 14:10
 */

/**
* sql语句执行影响行数是否为 1
*/

public class ControlDB {
    public boolean executeUpdate(String sql) throws SQLException {
        Connection conn=null;
        Statement stmt=null;
        boolean flag=false;
        try {
            conn=ConnectionFactory.getConnection();
            stmt=conn.createStatement();
            int result=stmt.executeUpdate(sql);
            if(1==result) flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
            stmt.close();
            stmt=null;
            conn=null;
        }
        return flag;
    }
}
