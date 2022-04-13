package GUI;

import DB.DatabaseConnection;
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

    public void createAccountHolder(String date, String name, String address, String postcode, int telephoneNumber, String email,
                                    String regno, String make, String model, String eng_serial, String chassisNumber, String colour,
                                    String discountplan) {
        //create customer account,
        // line 1 of parameters contains account details
        // line 2 contains the details of the first car on that account (must at least have 1)
        // line 3 contains the discountplan

        //add account with line 1 and line 3 details to the customeraccount table
        // also add "no_of_cars = 1" to the customeraccount table
        // add car with line 2 details and a customerID from this customer
    }
    public void payLateOption(boolean plo){ // customer account holders can have a pay late option. Set it to true or false
        // update pay late option to plo
        DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Discountplan='" + plo + "' WHERE ID='" + customerIDTextField + "'");
    }

    public void alterAccountHolder(){ // alter customer account details
    }

    public static void main(String[] args) {
        CreateAlterAccountHolder mycaap = new CreateAlterAccountHolder();
    }
}
