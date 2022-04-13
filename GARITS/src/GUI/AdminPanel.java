package GUI;

import DB.BackupUI;
import DB.DatabaseConnection;
import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import static DB.DatabaseConnection.*;

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
    private JButton databaseButton;
    private JButton updatedButton;
    private JButton backButton;
    private JLabel dateField;
    private JTextField textField1;
    private JButton backupButton;

    public AdminPanel() {
        Main.updateMain("AdminPanel");
//        super(parent);
        setTitle("Admin Panel");
        setContentPane(adminPanel);
        setMinimumSize(new Dimension(720, 400));
        setModal(true);
        try {
            tableIN();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        setLocationRelativeTo(parent);
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
                //IF USERNAME IS LEFT BLANK
                if (textFieldUsername.getText().isEmpty()) {
                    System.out.println("ENTER USERNAME");
                }
                else
                alterAccount(textFieldUsername.getText(),textFieldEmail.getText(),passwordField.toString(),roleBox.getSelectedItem());
            }
        });
        databaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Process process = Runtime.getRuntime().exec("./scripts/ping.sh");

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        JOptionPane.showMessageDialog(null, line);
                    }

                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                dispose();
                BackupUI backupUI = new BackupUI();

            }
        });
        updatedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updatedButton.setText("NEWDATE"); //Update list and update button text to show date.
            }
        });
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAccount(textFieldUsername.getText());
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login l = new Login();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main.backPage();
            }
        });
        setVisible(true);
    }

    private void tableIN() throws FileNotFoundException {

        File filePath = new File("./users/users.txt");

        BufferedReader input = new BufferedReader(new FileReader(filePath));
        Object[] lines = input.lines().toArray();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].toString();
//            table1.addColumn(line);
        }
    }

    public static void main(String[] args) {
        AdminPanel AP = new AdminPanel();
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

    public void alterAccount(String username,String email,String password, Object role){
        String x = String.valueOf(role);
        if(!textFieldEmail.getText().isEmpty()) {
            DatabaseConnection.databaseAffectTemplate("UPDATE useraccounts SET email ='"+ email + "' WHERE username='" +username+"';");
            //SQL STATEMENT TO CHANGE EMAIL ADDRESS
        }
        else if(!(passwordField.getPassword().length == 0)) {
            DatabaseConnection.databaseAffectTemplate("UPDATE useraccounts SET password = '"+ password +"' WHERE username='" +username+"';");
            //SQL STATEMENT TO CHANGE PASSWORD
        }
        else if (!Objects.equals(role, "ChooseRole")) {
            DatabaseConnection.databaseAffectTemplate("UPDATE useraccounts SET user_role = '"+ x +"' WHERE username='" +username+"';");
            //SQL STATEMENT TO CHANGE ROLE
        }
        else {
            System.out.println("ERROR");
        }
   }

    public void deleteAccount(String username){
        DatabaseConnection.databaseAffectTemplate("DELETE FROM useraccounts WHERE username='" + username + "';");
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
