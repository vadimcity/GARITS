package DB;

import javax.swing.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;

//an example of a database query would be
//String sql = "INSERT INTO useraccounts VALUES ('Samantha', 'x123', 'Roles.Mechanic')";

public class DatabaseConnection {
    static final String database_url = "jdbc:mysql://192.168.0.10:3308/t18database";
    static final String mysqlUser = "root";
    static final String mysqlPassword = "example";

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
            String sql = "INSERT INTO useraccounts VALUES ('Solomon', 'x123', 'Roles.Receptionist')";
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
            int result=stmt.executeUpdate(sql);
            System.out.println(result+" records affected");
            System.out.println("Altered the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //public static void databaseReturnString(String sql, int column){
    public static String databaseReturnIndivString(String sql, String column) {
        String s = "";
        try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs=stmt.executeQuery(sql); rs.next(); s = rs.getString(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    public static ArrayList<String> databaseReturnString(String sql, String column){
        ArrayList<String> al = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            //System.out.println("Reading the table...");
            ResultSet rs=stmt.executeQuery(sql);
            //System.out.println("Table read...");

            while(rs.next()) {
                String s = rs.getString(column);
                //System.out.println(s);
                al.add(s);
            }

            /* rs.absolute(3);
            System.out.println("hello");
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)); */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
    public static int databaseReturnIndivInt(String sql, String column){
        int x = -1;

        try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs=stmt.executeQuery(sql); rs.next(); x = rs.getInt(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }
    public static ArrayList<Integer> databaseReturnInt(String sql, String column){
        ArrayList<Integer> al = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            //System.out.println("Reading the table...");
            ResultSet rs=stmt.executeQuery(sql);
            //System.out.println("Table read...");

            while(rs.next()) {
                Integer i = rs.getInt(column);
                //System.out.println(i);
                al.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }


/*
    //send a query to the database and get a boolean in return
    //public static boolean databaseReturnBool(String sql){
    public static void databaseReturnBool(){
        String query = "SELECT * FROM useraccounts WHERE Username='James' INTO OUTFILE 'output_file.txt'";

        try (Connection conn = DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DB.DatabaseConnection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    } */


    // Importing input output java files

    /*
    // System.Main friver method
    public static void databaseReturnBool(){

        // Assigning NULL to connection object
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Jframe j = new JFrame();

        // For jdbc connection
        conn = connection.connectDB();

        // Query to display details of all customers
        String sql = "select * from cuslogin";

        try {

            ps = conn.prepareStatement(sql);

            // Result is stored in rs
            rs = ps.executeQuery();

            // Send the result to the table
            jTable1.setModel(
                    DbUtils.resultSetToTableModel(rs));

            // Here, jTable1 is name of the tablular format
        }

        // Catch block to handle if exception occured
        catch (Exception e) {

            // Display exception message in dialog block
            JOptionPane.showMessageDialog(null, e);
        }
    } */

    //send a query to the database and get a String in return
    //public static String databaseReturnString(String sql){ }

}

