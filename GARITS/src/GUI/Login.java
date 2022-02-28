package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog{
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JPanel loginPanel;

    public Login (JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(430,220));
        setModal(true);
        setLocationRelativeTo(parent);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();

            }
        });

        setVisible(true);

    }

    private void loginUser() {

        
    }

    public static void main (String[] args){
        Login myLogin = new Login (null);

    }
}
