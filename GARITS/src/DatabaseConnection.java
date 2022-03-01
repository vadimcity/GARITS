import java.sql.*;

import java.util.ArrayList;

import java.io.*;

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
            int result=stmt.executeUpdate(sql);
            System.out.println(result+" records affected");
            System.out.println("Altered the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //public static void databaseReturnString(String sql, int column){
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
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
}
