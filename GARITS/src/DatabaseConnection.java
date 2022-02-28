import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    static final String database_url = "jdbc:mysql://localhost:3306/t18database";
    static final String mysqlUser = "root";
    static final String mysqlPassword = "jack123";

    //send a query to the database in the form of the string.
    public static void databaseAffectTemplate(String sql){
        try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Altering the table...");
            stmt.executeUpdate(sql);
            System.out.println("Altered the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    //send a query to the database and get a boolean in return
    //public static boolean databaseReturnBool(String sql){ }
    
    //send a query to the database and get a boolean in return
    //public static boolean databaseReturnBool(String sql){
    public static void databaseReturnBool(){
        String query = "SELECT * FROM useraccounts";

        try (Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DatabaseConnection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    /*
    //send a query to the database and get a String in return
    public static String databaseReturnString(String sql){ }
    */
}
