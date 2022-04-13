package GUI;

import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAlterAccountHolder extends JDialog{
    private JButton backButton;
    private JTextField dateTextField;
    private JTextField addressTextField;
    private JButton saveButton;
    private JComboBox comboBox1;
    private JButton logOutButton;
    private JButton createButton1;
    private JTextField customerIDTextField;

    private JPanel caaPanel;

    public CreateAlterAccountHolder() {
        Main.updateMain("CreateAlterAccountHolder");
        //testIDslot();

//        super(parent);
        setTitle("CreateAlterAccountHolderPanel");
        setContentPane(caaPanel);
        setMinimumSize(new Dimension(700, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
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
                Login l = new Login();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        CreateAlterAccountHolder mycaap = new CreateAlterAccountHolder();
    }
}
