package GUI;

import DB.DatabaseConnection;
import System.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ClosedSelectorException;
import java.sql.*;

public class Login extends JDialog {
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JPanel loginPanel;

    public Login() {
//        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
//        setLocationRelativeTo(parent);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        setVisible(true);
    }

    private void loginUser() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.0.10:3308/t18database", "root", "example");
            String sql = "SELECT * FROM useraccounts WHERE username=? AND user_password=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,  textField1.getText());
            pst.setString(2, passwordField1.getText());
            ResultSet rs = pst.executeQuery();
            sql = "SELECT * FROM useraccounts WHERE username=\"" + textField1.getText() +"\" AND user_password=\"" + passwordField1.getText() + "\"";
            if (rs.next()) {
//                JOptionPane.showMessageDialog(null, "Logging In");
                Main.setRole(DatabaseConnection.databaseReturnIndivString(sql, "user_role"));
                System.out.println("Login role = " + DatabaseConnection.databaseReturnIndivString(sql, "user_role"));
                System.out.println("Login role Main = " + Main.getRole());
                this.dispose();
//                Main.newpanel();
                //AdminPanel AP = new AdminPanel();
                MainPanel mp = new MainPanel();
            } else {
                JOptionPane.showMessageDialog(null, "Username or Password incorrect");
                textField1.setText("");
                passwordField1.setText("");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main (String[] args){
        Login myLogin = new Login();

    }
}
