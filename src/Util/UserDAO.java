package Util;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 14:20
 */

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *操作用户类
 */
public class UserDAO {

    /**
     * 获取登录用户的信息
     * @param loginName
     * @param password
     * @return
     */
    public User loginSelect(String loginName, String password){
        User user=new User();
        String sql="select * from tb_user where name='"+loginName+"' and password='"+password+"' ";
        try{
            Connection conn=ConnectionFactory.getConnection();
           Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setLimit(rs.getInt("limit"));
                user.setTag(rs.getInt("tag"));
            }
            DbClose.close(rs,st,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }



    /**
     * 修改密码
     * @param id
     * @param psw
     * @param psw1
     * @return
     */
    public boolean changePassword(int id,String psw,String psw1){
        ControlDB cd=new ControlDB();
        String sql="update tb_user set password='"+psw1+"'where id='"+id+"' and password='"+psw+"'";
        boolean flag=false;
        try {
            flag=cd.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }



    /**
     * 获得所有用户
     * @return
     */
    public List<User> getAllUser(){
        List<User> list=new ArrayList<User>();
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        conn=ConnectionFactory.getConnection();
        try {
            st=conn.createStatement();
            String sql="select * from tb_user where tag=0";
            rs=st.executeQuery(sql);
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setLimit(rs.getInt("limit"));
                list.add(user);
            }
            DbClose.close(rs,st,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 根据姓名查找用户
     * @param name
     * @return
     */
    public List<User> selectUser(String name){
        List<User> list=new ArrayList<User>();
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String sql="select * from tb_user where tag=0 and name='"+name+"'";
        try {
            st=conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){     //有用户 则返回
                do{
                    User user=new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setLimit(rs.getInt("limit"));
                    list.add(user);
                }while (rs.next());
                DbClose.close(rs,st,conn);
            }else{   //否则返回所有用户
                list=(new UserDAO()).getAllUser();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }


    /**
     * 设置用户权限
     * @param id
     * @param type
     * @return
     */
    public boolean setUserLimit(int id,int type){
        ControlDB cd=new ControlDB();
        String sql="update tb_user set limit='"+type+"'where id='"+id+"'";
        boolean flag=false;
        try {
            flag=cd.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 获得用户权限
     * @param id
     * @return
     */
    public int getUserLimit(int id){
        Connection conn=null;
        conn=ConnectionFactory.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        int limit=0;
        String sql="select * from tb_user where id=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,id);
            rs=pst.executeQuery();
            if(rs.next()){
                limit=rs.getInt("limit");
                DbClose.close(rs,pst,conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return limit;
    }



    /**
     * 增加用户
     * @param name
     * @param psw
     * @return
     */
    public boolean insertUser(String name,String psw) {
        ControlDB cd=new ControlDB();
        String sql="insert into tb_user(name,password,limit,tag) values('"+name+"','"+psw+"','"+1+"','"+0+"')";
        boolean flag=false;
        try {
            flag=cd.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }



    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean deleteUser(int id){
        ControlDB cd=new ControlDB();
        String sql="delete from tb_user where id='"+id+"'";
        boolean flag=false;
        try {
            flag=cd.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


}
