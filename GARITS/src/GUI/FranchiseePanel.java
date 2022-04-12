package GUI;

import DB.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FranchiseePanel extends JDialog{
    private JTable table1;
    private JButton createAlterAccountHolderButton;
    private JButton forepsersonButton;
    private JButton logOutButton;
    private JTextField customerIDTextField;
    private JComboBox comboBox1;

    private JPanel franchiseePanel;
    private JButton applyButton;

    public FranchiseePanel() {
        //testIDslot();

//        super(parent);
        setTitle("FranchiseePanel");
        setContentPane(franchiseePanel);
        setMinimumSize(new Dimension(650, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login l = new Login();
            }
        });
        createAlterAccountHolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CreateAlterAccountHolder c = new CreateAlterAccountHolder();
            }
        });
        forepsersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ForepersonPanel f = new ForepersonPanel();
            }
        });
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apply();
            }
        });

        setVisible(true);
    }

    public void apply(){

    }

    public static void main(String[] args) {
        FranchiseePanel myfp = new FranchiseePanel();
    }
}
