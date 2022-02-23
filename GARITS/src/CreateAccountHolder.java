import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountHolder {
    static final String database_url = "jdbc:mysql://192.168.0.10:3308/CustomerAccountHolder";
    static final String mysqlUser = "jack123";
    static final String mysqlPassword = "jack123";

    public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO CustomerHolder VALUES ('aflkj', 'DF3Fd', 'The car is bent.', 12)";
         stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table...");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
