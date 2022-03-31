package GUI;

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
    private JButton signOutButton;

    public GenericPage(JFrame parent) {
        super(parent);
        setTitle("Admin Panel");
        setContentPane(genericPage);
        setMinimumSize(new Dimension(1000, 400));
        setModal(true);
        setLocationRelativeTo(parent);
        setVisible(true);
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signOut();
            }
        });
    }

    private void signOut(){ }

    public static void main(String[] args) {
        GenericPage AP = new GenericPage(null);
    }
}

