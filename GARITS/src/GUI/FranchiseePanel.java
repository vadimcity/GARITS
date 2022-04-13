package GUI;

import DB.DatabaseConnection;
import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FranchiseePanel extends JDialog{
    private JTable table1;
    private JButton createAlterAccountHolderButton;
    private JButton forepsersonButton;
    private JButton logOutButton;
    private JTextField customerIDTextField;
    private JComboBox comboBox1;

    private JPanel franchiseePanel;
    private JButton applyButton;
    private JButton backButton;
    private JRadioButton payLate;

    public FranchiseePanel() {
        Main.updateMain("FranchiseePanel");
        //testIDslot();

//        super(parent);
        setTitle("FranchiseePanel");
        setContentPane(franchiseePanel);
        setMinimumSize(new Dimension(650, 300));
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
        if(comboBox1.getSelectedIndex() != 0){ alterDiscountPlan();}
        if(payLate.isSelected()){
            payLateOption(true);
        }
    }

    //setDiscountPlan was subsumed by alterDiscountPlan
    public void alterDiscountPlan(){
        //can be fixed, variable or flexible
        DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Discountplan='" + comboBox1.getSelectedItem() + "' WHERE ID='" + customerIDTextField + "'");
    }

    public void payLateOption(boolean plo){ // customer account holders can have a pay late option. Set it to true or false
        // update pay late option to plo
        DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Discountplan='" + plo + "' WHERE ID='" + customerIDTextField + "'");
    }

    public static void main(String[] args) {
        FranchiseePanel myfp = new FranchiseePanel();
    }
}
