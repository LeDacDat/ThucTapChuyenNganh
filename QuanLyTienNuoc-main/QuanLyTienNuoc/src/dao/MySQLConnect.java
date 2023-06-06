
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author duato
 */
public class MySQLConnect {
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_NAME = "quanlytiennuoc";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ledat@2002";
    
    private static Connection cons = null;
    
    public static Connection getConnection() {
        
        try {
            Class.forName(DATABASE_DRIVER);
            cons = DriverManager.getConnection(
                    DATABASE_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connect failed");
        }
        return cons;
    }
    
    public static void disconnect() {
        if (cons != null) {
            try {
                cons.close();
                cons = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
