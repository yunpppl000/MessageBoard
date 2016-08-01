package Util;

/**
 * Created with IntelliJ IDEA.
 * User: YEN
 * Date: 2016/7/31
 * Time: 14:20
 */


import Model.Message;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 操作留言信息类
 */
public class MessageDAO {

    /**
     * 获取所有留言信息
     * @return List<Message>
     */
    public List<Message> getAllMessage(){
        List<Message> list=new ArrayList<Message>();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select * from tb_message order by id desc";

        try {
            conn=ConnectionFactory.getConnection();
            stmt=conn.createStatement();
            rs= stmt.executeQuery(sql);

            //读取留言信息
            while (rs.next()){
                Message msg=new Message();
                msg.setId(rs.getInt("id"));
                msg.setAuthor(rs.getString("author"));
                msg.setContext(rs.getString("context"));
                msg.setDate(rs.getString("msgdate"));
                list.add(msg);
            }
            //关闭连接对象
            DbClose.close(rs,stmt,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获得单条留言信息
     * @param id
     * @return Message
     */
    public Message getOneMessage(int id){
        Message msg=new Message();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select * from tb_message where id=?";

        try {
            conn=ConnectionFactory.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setInt(1,id);
            rs=pst.executeQuery(sql);
            if(rs.next()){
                msg.setId(rs.getInt("id"));
                msg.setAuthor(rs.getString("author"));
                msg.setContext(rs.getString("context"));
                msg.setDate(rs.getString("msgdate"));
            }
            DbClose.close(rs,pst,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 获得某个用户的留言信息
     * @param author
     * @return List<Message>
     */
    public List<Message> selectByAuthor(String author){
        List<Message> list=new ArrayList<Message>();
        Connection conn=null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn=ConnectionFactory.getConnection();
            String s=author.trim();
            String sql = "SELECT * FROM tb_message WHERE author= '"+s+"' ORDER BY id DESC";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){   //如果有该用户的留言信息
                while(rs.next()) {
                    Message msg = new Message();
                    msg.setId( rs.getInt("id"));
                    msg.setAuthor(rs.getString("author"));
                    msg.setContext(rs.getString("context"));
                    msg.setDate( rs.getString("messageDate"));
                    list.add(msg);
                }
                DbClose.close(rs, st, conn);
            }
            else{       //如果没有该用户的留言信息 则返回所有留言
                list=(new MessageDAO()).getAllMessage();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 删除单条留言信息
     * @param id
     * @return boolean
     */
    public boolean deleteMessage(int id){
        ControlDB cd=new ControlDB();
        boolean flag=false;
        String sql="delete from tb_message where id='"+id+"'";
        try {
            flag=cd.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 更新某条留言信息
     * @param id
     * @param context
     * @return boolean
     */
    public boolean updateMessage(int id,String context){
        ControlDB cd=new ControlDB();
        String sql="update tb_message set context = '"+context+"' where id='"+id+"'";
        boolean flag=false;
        try {
            flag=cd.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 新增留言信息
     * @param author
     * @param context
     * @return boolean
     */
    public boolean insertMessage(String author, String context) {
        ControlDB cd=new ControlDB();
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String sql="insert into tb_message(author,context,msgdate) values('"+author+"','"+context+"','"+nowTime+"')";
        boolean flag=false;
        try {
            flag=cd.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
