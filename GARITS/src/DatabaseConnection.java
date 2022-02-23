// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;
// 
// public class DatabaseConnection {
//    static final String database_url = "jdbc:mysql://192.168.0.10:3308";
//    static final String user = "root";
//    static final String password = "example";
// 
//    public static void main(String[] args) {
//       // Open a connection
//       try(Connection conn = DriverManager.getConnection(database_url, user, password);
//           Statement stmt = conn.createStatement();
//       ) {
//          // Execute a query
//          System.out.println("Inserting records into the table...");
//          String sql = INSERT "INTO CustomerAccountHolder VALUES (100, 'Zara', 'Ali', 18)";
//          stmt.executeUpdate(sql);
//          System.out.println("Inserted records into the table...");
//       } catch (SQLException e) {
//          e.printStackTrace();
//       }
//    }
// }