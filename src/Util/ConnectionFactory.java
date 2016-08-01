package Util;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 13:58
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接
 */

public class ConnectionFactory {

    private static final String DB_DRIVER="com.mysql.jdbc.Driver";      //数据库驱动
    private static final String DB_URL = "jdbc:mysql://localhost:3306/messagedb?useUnicode=true&characterEncoding=UTF-8";//连接数据库的URL地址
    private static final String DB_USERNAME = "root";                   //数据库的用户名
    private static final String DB_PASSWORD ="admin";                   //数据库的密码



    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);//反射机制
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

   /*
    private static Connection conn=null;    //采用单例模式


    static {
        try {
            Class.forName(DB_DRIVER);       //反射机制
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //单例模式返回数据库连接对象
    public static Connection getConnection(){

        if(null==conn){
            synchronized (ConnectionFactory.class){
                if(null==conn){             //双重判断锁机制以防多线程造成的问题
                    try {
                        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return conn;
    }

    */

}
