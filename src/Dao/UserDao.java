package Dao;

import DB.DBUtil;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gzz
 */
public class UserDao {
    public void addUser(User us) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql=""+"insert into user"+"(player_username,player_password,play_createtime)"+"values("+"?,?,CURRENT_TIMESTAMP)";

        //预编译sql对象，不直接执行，调用exec方法时才执行
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1, us.getPlayer_username());
        ptmt.setString(2, us.getPlayer_password());
        ptmt.execute();
    }


    public void updateUser(User us) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql=""+" update user "+" set player_username=?,player_password=?,play_createtime=CURRENT_TIMESTAMP "+" where id= ?";

        //预编译sql对象，不直接执行，调用exec方法时才执行
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1, us.getPlayer_username());
        ptmt.setString(2, us.getPlayer_password());
        ptmt.setInt(3,us.getId());
        ptmt.execute();
    }

    public void delUser(String player_username) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql=""+" delete from user "+" where player_username= ?";

        //预编译sql对象，不直接执行，调用exec方法时才执行
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1,player_username);

        ptmt.execute();
    }

    //查询返回多个用户，结果集
    public List<User> Query() throws Exception {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id,player_username,player_password,play_createtime from user ");

        List<User> users = new ArrayList<>();
        User us=null;
        while (rs.next()) {
            us = new User();
            us.setId(rs.getInt("id"));
            us.setPlayer_username(rs.getString("player_username"));
            us.setPlayer_password(rs.getString("player_password"));
            us.setPlay_createtime(rs.getTimestamp("play_createtime"));
            users.add(us);
        }
        return users;
    }

    //查询单个用户，返回不为空
    public User get(String player_username,String player_password) throws Exception {
        User us=null;
        Connection conn = DBUtil.getConnection();
        String sql=""+" select * from user "+" where player_username= ? and player_password =? ";

        //预编译sql对象，不直接执行，调用exec方法时才执行
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setString(1,player_username);
        ptmt.setString(2,player_password);
        ResultSet rs=ptmt.executeQuery();

        while (rs.next()){
            us=new User();
            us.setId(rs.getInt("id"));
            us.setPlayer_username(rs.getString("player_username"));
            us.setPlayer_password(rs.getString("player_password"));
            us.setPlay_createtime(rs.getTimestamp("play_createtime"));
        }

        return us;
    }


    public List<User> Query(String player_username) throws Exception {
        Connection conn = DBUtil.getConnection();
        List<User> users = new ArrayList<>();

        StringBuilder sb=new StringBuilder();
        sb.append("select * from user ");
        sb.append(" where player_username like ? ");

        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1,"%"+player_username+"%");
        ResultSet rs = ptmt.executeQuery();

        User us=null;
        while (rs.next()) {
            us = new User();
            us.setId(rs.getInt("id"));
            us.setPlayer_username(rs.getString("player_username"));
            us.setPlayer_password(rs.getString("player_password"));
            us.setPlay_createtime(rs.getTimestamp("play_createtime"));
            users.add(us);
        }
        return users;
    }
}
