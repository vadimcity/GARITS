package GUI;

import DB.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JDialog {
    private JButton deleteAccountButton;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JTable table1;
    private JComboBox roleBox;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private JPanel adminPanel;

    public AdminPanel(JFrame parent) {
        super(parent);
        setTitle("Admin Panel");
        setContentPane(adminPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
        setLocationRelativeTo(parent);

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               JOptionPane.showMessageDialog(null, "Are use sure you want to delete " + nameField.getText());
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //
                // Use this to create user. createAccount method?
                //
                //
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        AdminPanel myAdmin = new AdminPanel(null);
    }


//    /*private*/
//    public void createAccount(String username, String password, String role) {
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
//
//    /*private*/
//    public void deleteAccount(String username) {
//        DatabaseConnection.databaseAffectTemplate(
//                "DELETE FROM useraccounts WHERE username='" + username + "'");
//    }
//
//    /*private*/
//    public void databaseRestore() {
//    }
//
//    /*private*/
//    public void databaseBackup() {
//        DatabaseConnection.databaseAffectTemplate(
//                "mysqldump –u root –p jack123 t18database > t18database_back.sql");
//    }
//
//    /*private*/
//    public void alterAccount(String username) {
//        //bring up page allowing to change details of user account in database
//        //should have 3 boxes that can be filled, for username, password and role
//        //System should deal with it such that boxes can be left blank, but depending on the situation, filled boxes update the table
//    }


}
