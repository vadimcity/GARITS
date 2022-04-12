package GUI;

import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenericPage extends JDialog {
    private JButton deleteAccountButton;
    private JTextField nameField;
    private JTextField surnameField;
    private JTable table1;
    private JComboBox roleBox;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private JButton alterUserAccountButton;
    private JPasswordField passwordField1;
    private JScrollBar scrollBar1;
    private JPanel genericPage;
    private JButton logOutButton;
    private JButton backButton;

    public GenericPage() {
        setTitle("Generic Panel");
        setContentPane(genericPage);
        setMinimumSize(new Dimension(1000, 400));
        setModal(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main.backPage();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
            }
        });
        setVisible(true);
    }


    public static void main(String[] args) {
        GenericPage AP = new GenericPage();
    }
}

