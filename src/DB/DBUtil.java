package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/test";
    private static final String USER="root";
    private static final String PASSWORD="123456";

    private static Connection conn=null;

    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= java.sql.DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public synchronized static Connection getConnection() {
        return conn;
    }

    public static void main(String []args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        conn= java.sql.DriverManager.getConnection(URL,USER,PASSWORD);
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select id,player_username from user ");

        while(rs.next()){
            System.out.println(rs.getInt("id")+","+rs.getString("player_username"));
        }
    }
}

