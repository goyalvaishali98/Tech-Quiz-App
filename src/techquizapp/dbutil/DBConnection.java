package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection conn;//static because only one tim we create connection
    static{
         try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-QPG3CBC:1521/xe","onlineexam","student");
             System.out.println("Connection opened!");
             JOptionPane.showMessageDialog(null, "Connected successfully with database");
         }
         catch(Exception ex){
              JOptionPane.showMessageDialog(null,"DB Error in opening connection in DBConnection","Error!",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
              System.exit(1);       //To terminate with failure
         }
    }
   public static Connection getConnection() {
       return conn;
   }     
   public static void closeConnection(){
        if(conn!=null){
            try{
                conn.close();
                JOptionPane.showMessageDialog(null, "Disconnected successfully with database");
                System.out.println("Connection closed");
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"DB Error in closing connection in DBConnection","Error!",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
   }
}
