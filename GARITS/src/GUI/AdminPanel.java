package GUI;

import DB.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JDialog {

    private JButton deleteAccountButton;
    private JComboBox roleBox;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private JButton alterUserAccountButton;
    private JPanel adminPanel;
    private JTextField textFieldUsername;
    private JTextField textFieldEmail;
    private JPasswordField passwordField;
    private JTable table1;
    private JButton logoutButton;

    public AdminPanel() {
//        super(parent);
        setTitle("Admin Panel");
        setContentPane(adminPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
//        setLocationRelativeTo(parent);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                Login login = new Login();
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createAccount(textFieldUsername.getText(), passwordField.getPassword(), roleBox.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Sending Account Details...");
            }
        });
        alterUserAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Altering Account Details...");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
//        AdminPanel AP = new AdminPanel();
    }


    public void createAccount(String username, char[] password, Object role) {
//        String sql = "INSERT INTO useraccounts VALUES ('Samantha', 'x123', 'Mechanic')";
//        String sql = "INSERT INTO useraccounts VALUES ('" + username + "', '" + password + "', '" + role + "')";
//        return sql;

        //if(!Main.checkRole(role)){ return; }              //should also output a popup saying "not a role", possibly replace with a dropdown menu
        //if(!Main.checkUsername(username)){ return; }      //should also output a popup saying "username already in use"

        System.out.println("About to send.");
        DatabaseConnection.databaseAffectTemplate(
                "INSERT INTO useraccounts VALUES ('" + username + "', NULL, NULL, '" + password + "', NULL,  '" + role + "')");
        System.out.println("Sent.");
    }
}
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
