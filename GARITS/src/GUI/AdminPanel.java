package GUI;

import DB.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultTextUI;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminPanel extends JDialog {

    private JButton deleteAccountButton;
    private JTextField nameField;
    private JTextField surnameField;
    private JComboBox roleBox;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private JButton alterUserAccountButton;
    private JPasswordField passwordField1;
    private JPanel adminPanel;
    private JTextField textField1;
    private JTable table1;

    public AdminPanel(JFrame parent) {
        super(parent);
        setTitle("Admin Panel");
        setContentPane(adminPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
        setLocationRelativeTo(parent);

        String[] colName = {"Username", "Firstname", "Surname", "Role"};
        Object[][] data = new Object[][] {{1, "John", 40.0, false },{2, "Rambo", 70.0, false },{3, "Zorro", 60.0, true }};
        table1 = new JTable(data, colName);
        //add the table to the frame
        add(new JScrollPane(table1));
        setTitle("Table Example");
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        AdminPanel AP = new AdminPanel(null);
    }
}

//    /*private*/ public void createAccount(String username, String password, String role){
//        /* String sql = "INSERT INTO useraccounts VALUES ('Samantha', 'x123', 'Mechanic')";
//        String sql = "INSERT INTO useraccounts VALUES ('" + username + "', '" + password + "', '" + role + "')";
//        return sql; */
//
//        //if(!Main.checkRole(role)){ return; }              //should also output a popup saying "not a role", possibly replace with a dropdown menu
//        //if(!Main.checkUsername(username)){ return; }      //should also output a popup saying "username already in use"
//
//        DatabaseConnection.databaseAffectTemplate(
//                "INSERT INTO useraccounts VALUES ('" + username + "', '" + password + "', '" + role + "')");
//    }
//    /*private*/ public void deleteAccount(String username){
//        DatabaseConnection.databaseAffectTemplate(
//                "DELETE FROM useraccounts WHERE username='" + username + "'");
//    }
//
//    /*private*/ public void databaseRestore(){
//    }
//
//    /*private*/ public void databaseBackup(){
//        DatabaseConnection.databaseAffectTemplate(
//                "mysqldump –u root –p jack123 t18database > t18database_back.sql");
//    }
//
//    /*private*/ public void alterAccount(String username){
//        //bring up page allowing to change details of user account in database
//        //should have 3 boxes that can be filled, for username, password and role
//        //System should deal with it such that boxes can be left blank, but depending on the situation, filled boxes update the table
//    }

//    public static void main(String[] args) {
//        AdminPanel AP = new AdminPanel();
//        AP.databaseBackup();
//    }
