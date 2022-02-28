import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

//an example of a database query would be
//String sql = "INSERT INTO useraccounts VALUES ('Samantha', 'x123', 'Mechanic')";

public class DatabaseConnection {
    static final String database_url = "jdbc:mysql://localhost:3306/t18database";
    static final String mysqlUser = "root";
    static final String mysqlPassword = "jack123";

/*
    public static void main(String[] args) {
        // Open a connection

//        try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
//            Statement stmt = conn.createStatement();
//        ) {
//            // Execute a query
//            System.out.println("Inserting records into the table...");
//            String sql = "INSERT INTO useraccounts VALUES ('Samantha')";
//            stmt.executeUpdate(sql);
//            System.out.println("Inserted records into the table...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        userAccountsInsert();
    }

    public static void userAccountsInsert(){
        try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO useraccounts VALUES ('Solomon', 'x123', 'Receptionist')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 */


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

    //send a query to the database and get a String in return
    //public static String databaseReturnString(String sql){ }

}
