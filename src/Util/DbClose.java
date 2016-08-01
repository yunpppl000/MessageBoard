package Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 14:07
 */


/**
 * 关闭连接对象
 */
public class DbClose {

    public static void close(Connection conn) {
        if(null != conn) {
            try {
                conn.close();
                conn=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if(null != stmt) {
            try {
                stmt.close();
                stmt=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if(null != rs) {
            try {
                rs.close();
                rs=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        close(rs);
        close(stmt);
        close(conn);
    }

    public static void close(Statement stmt, Connection conn) {
        close(stmt);
        close(conn);
    }
}
