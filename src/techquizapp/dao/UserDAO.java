
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

public class UserDAO {
    public static boolean validateUser(User user)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public static int changePwd(String userId, String password)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set password=? where userid=?");
        ps.setString(1, password);
        ps.setString(2, userId);
        int result = ps.executeUpdate();
        return result;
    }
    public static boolean validateUser(String userId)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where userid=?");
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public static int registerStudent(User user)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int result = ps.executeUpdate();
        return result;
    }
}
