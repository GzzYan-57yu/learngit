package Dao;

import DB.DBUtil;
import Model.Recordy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordyDao {
    public void addRecordy(Recordy re) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "" + "insert into recordy " + "(game_ID,game_begintime,game_exittime,game_user1name,game_user2name,game_winner_name,game_user1cards,game_user2cards,game_max_user1cards,game_max_user2cards)" + "values(" + "?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?,'wang',?,?,?,?,?)";
        //预编译sql对象，不直接执行，调用exec方法时才执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, re.getGame_ID());
        ptmt.setString(2, re.getGame_user1name());
        ptmt.setString(3, re.getGame_winner_name());
        ptmt.setString(4, re.getGame_user1cards());
        ptmt.setString(5, re.getGame_user2cards());
        ptmt.setString(6, re.getGame_max_user1cards());
        ptmt.setString(7, re.getGame_max_user2cards());
        ptmt.execute();
    }

    public void updateRecordy(Recordy re) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "" + "update recordy " + " set game_begintime=CURRENT_TIMESTAMP,game_exittime=CURRENT_TIMESTAMP,game_user1name=?,game_user2name='wang',game_winner_name=?,game_user1cards=?,game_user2cards=?,game_max_user1cards=?,game_max_user2cards=?" + " where game_ID=? ";

        //预编译sql对象，不直接执行，调用exec方法时才执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, re.getGame_user1name());
        ptmt.setString(2, re.getGame_winner_name());
        ptmt.setString(3, re.getGame_user1cards());
        ptmt.setString(4, re.getGame_user2cards());
        ptmt.setString(5, re.getGame_max_user1cards());
        ptmt.setString(6, re.getGame_max_user2cards());
        ptmt.setInt(7, re.getGame_ID());
        ptmt.execute();
    }

    public void delRecordy(String game_user1name) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "" + " delete from recordy " + " where game_user1name=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, game_user1name);

        ptmt.execute();
    }

    //查询返回多个用户，结果集
    public List<Recordy> Query() throws Exception {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select game_ID,game_user1name,game_user2name from recordy ");

        List<Recordy> records = new ArrayList<>();
        Recordy re = null;
        //当存在下一个值的时候进入循环
        while (rs.next()) {
            re = new Recordy();
            re.setGame_ID(rs.getInt("game_ID"));
            re.setGame_user1name(rs.getString("game_user1name"));
            re.setGame_user2name(rs.getString("game_user2name"));
            records.add(re);
        }
        //返回List结果集
        return records;
    }

    //查询单个用户，返回不为空
    public Recordy get(Integer game_ID) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "" + "select * from recordy " + " where game_ID = ? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, game_ID);
        ResultSet rs = ptmt.executeQuery();

        Recordy re = null;
        //当存在下一个值的时候进入循环
        while (rs.next()) {
            re = new Recordy();
            re.setGame_ID(rs.getInt("game_ID"));
            re.setGame_begintime(rs.getTimestamp("game_begintime"));
            re.setGame_exittime(rs.getTimestamp("game_exittime"));
            re.setGame_user1name(rs.getString("game_user1name"));
            re.setGame_user2name(rs.getString("game_user2name"));
            re.setGame_winner_name(rs.getString("game_winner_name"));
            re.setGame_user1cards(rs.getString("game_user1cards"));
            re.setGame_user2cards(rs.getString("game_user2cards"));
            re.setGame_max_user1cards(rs.getString("game_max_user1cards"));
            re.setGame_max_user2cards(rs.getString("game_max_user2cards"));
        }
        return re;
    }

    //查询历史记录某一个用户
    public List<Recordy> Query(String game_user1name) throws Exception {
        Connection conn = DBUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append(" select * from recordy " );
        sb.append(" where game_user1name like ?");
        PreparedStatement ptmt =  conn.prepareStatement(sb.toString());
        ptmt.setString(1,"%"+game_user1name+"%");
        ResultSet rs = ptmt.executeQuery();

        List<Recordy> records = new ArrayList<>();
        Recordy re = null;
        //当存在下一个值的时候进入循环
        while (rs.next()) {
            re = new Recordy();
            re.setGame_ID(rs.getInt("game_ID"));
            re.setGame_begintime(rs.getTimestamp("game_begintime"));
            re.setGame_exittime(rs.getTimestamp("game_exittime"));
            re.setGame_user1name(rs.getString("game_user1name"));
            re.setGame_user2name(rs.getString("game_user2name"));
            re.setGame_winner_name(rs.getString("game_winner_name"));
            re.setGame_user1cards(rs.getString("game_user1cards"));
            re.setGame_user2cards(rs.getString("game_user2cards"));
            re.setGame_max_user1cards(rs.getString("game_max_user1cards"));
            re.setGame_max_user2cards(rs.getString("game_max_user2cards"));
            records.add(re);
        }
        //返回List结果集
        return records;

    }

    public List<Recordy> Query( Timestamp game_begintime,Timestamp game_exittime) throws Exception {
        Connection conn = DBUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append(" select * from recordy " );
        //sb.append(" order by game_begintime " );
        sb.append(" where game_begintime > ? and game_exittime < ?");
        PreparedStatement ptmt =  conn.prepareStatement(sb.toString());

        ptmt.setTimestamp(1,game_begintime);
        ptmt.setTimestamp(2,game_exittime);
        ResultSet rs = ptmt.executeQuery();

        List<Recordy> records = new ArrayList<>();
        Recordy re = null;
        //当存在下一个值的时候进入循环
        while (rs.next()) {
            re = new Recordy();
            re.setGame_ID(rs.getInt("game_ID"));
            re.setGame_begintime(rs.getTimestamp("game_begintime"));
            re.setGame_exittime(rs.getTimestamp("game_exittime"));
            re.setGame_user1name(rs.getString("game_user1name"));
            re.setGame_user2name(rs.getString("game_user2name"));
            re.setGame_winner_name(rs.getString("game_winner_name"));
            re.setGame_user1cards(rs.getString("game_user1cards"));
            re.setGame_user2cards(rs.getString("game_user2cards"));
            re.setGame_max_user1cards(rs.getString("game_max_user1cards"));
            re.setGame_max_user2cards(rs.getString("game_max_user2cards"));
            records.add(re);
        }

        //返回List结果集
        return records;
    }
}
