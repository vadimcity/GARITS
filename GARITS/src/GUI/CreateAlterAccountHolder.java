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
    private JButton editCarsPanel;
    private JButton alterButton;
    private JTextField nameText;
    private JTextField postCodeText;
    private JTextField telephoneNo;
    private JTextField emailText;

    public CreateAlterAccountHolder() {
        Main.updateMain("CreateAlterAccountHolder");
        //testIDslot();

//        super(parent);
        setTitle("CreateAlterAccountHolderPanel");
        setContentPane(caaPanel);
        setMinimumSize(new Dimension(850, 300));
        setModal(true);
        disabling(alterButton);
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
        editCarsPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CarPanel l = new CarPanel();
            }
        });
        createButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disabling(createButton1);
                enabling(alterButton);
                saveButton.setText("Alter");
            }
        });
        alterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disabling(alterButton);
                enabling(createButton1);
                saveButton.setText("Create");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(createButton1.isEnabled()){ createAccountHolder(); }
                else{ alterAccountHolder(); }
            }
        });

        setVisible(true);
    }

    private void enabling(JButton b){ b.setEnabled(true); b.setFocusable(true); }
    private void disabling(JButton b){ b.setEnabled(false); b.setFocusable(false); }

    public void createAccountHolder() {
        if(testEmpty()){
            DatabaseConnection.databaseAffectTemplate("INSERT INTO customermemberlist VALUES ('" + dateTextField + "', '" + nameText + "', '" + addressTextField
                    + "', '" + postCodeText + "', '" + telephoneNo + "', '" + emailText + "', '" + comboBox1.getSelectedItem() + "')");
            System.out.println("Successfully sent");
        }
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

    public boolean testEmpty(){
        if(dateTextField.getText().isEmpty() || (dateTextField.getText().equals("Date"))){ System.out.println("Date"); return false; }
        if(nameText.getText().isEmpty() || (nameText.getText().equals("Name"))){ System.out.println("Name"); return false; }
        if(addressTextField.getText().isEmpty() || (addressTextField.getText().equals("Address"))){ System.out.println("Address"); return false; }
        if(postCodeText.getText().isEmpty() || (postCodeText.getText().equals("Postcode"))){ System.out.println("Postcode"); return false; }
        if(telephoneNo.getText().isEmpty() || (telephoneNo.getText().equals("Telephone No."))){ System.out.println("Telephone No."); return false; }
        if(emailText.getText().isEmpty() || (emailText.getText().equals("Email"))){ System.out.println("Email"); return false; }

        if(comboBox1.getSelectedIndex() == 0){ System.out.println("DiscountPlan"); return false; }
        return true;
    }

    public void alterAccountHolder(){ // alterButton customer account details
        if(customerIDTextField.getText().isEmpty() || (customerIDTextField.getText().equals("CustomerID"))){
            System.out.println("To alter an account requires the customerID box to be filled");
        }

        if(!(dateTextField.getText().isEmpty() || (dateTextField.getText().equals("Date")))){
            DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Date='" + dateTextField + "' WHERE ID='" + customerIDTextField + "'");
        }
        if(!(nameText.getText().isEmpty() || (nameText.getText().equals("Name")))){
            DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Name='" + dateTextField + "' WHERE ID='" + customerIDTextField + "'");
        }
        if(!(addressTextField.getText().isEmpty() || (addressTextField.getText().equals("Address")))){
            DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Address='" + addressTextField + "' WHERE ID='" + customerIDTextField + "'");
        }
        if(!(postCodeText.getText().isEmpty() || (postCodeText.getText().equals("Postcode")))){
            DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Postcode='" + postCodeText + "' WHERE ID='" + customerIDTextField + "'");
        }
        if(!(telephoneNo.getText().isEmpty() || (telephoneNo.getText().equals("Telephone No.")))){
            DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET TelephoneNo='" + telephoneNo + "' WHERE ID='" + customerIDTextField + "'");
        }
        if(!(emailText.getText().isEmpty() || (emailText.getText().equals("Email")))){
            DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Email='" + emailText + "' WHERE ID='" + customerIDTextField + "'");
        }

        if(comboBox1.getSelectedIndex() != 0){
            DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET discountPlan='" + comboBox1.getSelectedItem() + "' WHERE ID='" + customerIDTextField + "'");
        }
    }

    public static void main(String[] args) {
        CreateAlterAccountHolder mycaap = new CreateAlterAccountHolder();
    }
}
