package GUI;

import DB.DatabaseConnection;
import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarPanel extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JTextField carIDTextField;
    private JButton removeCarButton;
    private JButton editCarButton;
    private JTextField registerNoTextField;
    private JButton addCarButton;
    private JTextField customerIDTextField;

    private JPanel carPanel;
    private JTextField makeTextField;
    private JTextField engineTextField;
    private JTextField chassisNoTextField;
    private JTextField modelTextField;
    private JTextField colourTextField;

    public CarPanel() {
        Main.updateMain("CarPanel");
//        testIDslot();

//        super(parent);
        setTitle("CarPanel");
        setContentPane(carPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar(carIDTextField.getText());
            }
        });
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar(registerNoTextField.getText(),makeTextField.getText(),engineTextField.getText(),chassisNoTextField.getText(),colourTextField.getText(),customerIDTextField.getText());
            }
        });
        editCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editCar(carIDTextField.getText(),registerNoTextField.getText(),makeTextField.getText(),engineTextField.getText(),chassisNoTextField.getText(),colourTextField.getText(),customerIDTextField.getText());
            }
        });
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
        public void removeCar(String carID) {
            DatabaseConnection.databaseAffectTemplate("DELETE FROM vehicles WHERE vehicleID='" + carID + "';");
    }
        public void addCar(String registerNo, String make, String engineSerial, String chassisNo, String colour, String customerID ) {
            DatabaseConnection.databaseAffectTemplate("INSERT INTO vehicles(registerNo, make, engineSerial, chassisNo, colour, customerID)\n" +
                    "VALUES ('"+registerNo+"','"+ make +"','"+engineSerial+"','"+chassisNo+"','"+colour+"','"+customerID+"');");
        }
        public void editCar(String carID, String registerNo, String make, String engineSerial, String chassisNo, String colour, String customerID)  {
            if (!registerNoTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicles SET registerNo = '"+ registerNo +"' WHERE carID='" +carID+"';");
            }
            if (!makeTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicles SET make = '"+ make +"' WHERE carID='" +carID+"';");
            }
            if (!engineTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicles SET engineSerial = '"+ engineSerial +"' WHERE carID='" +carID+"';");
            }
            if (!chassisNoTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicles SET chassisNo = '"+ chassisNo +"' WHERE carID='" +carID+"';");
            }
            if (!colourTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicles SET colour = '"+ colour +"' WHERE carID='" +carID+"';");
            }
            if (!customerIDTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicles SET customerID = '"+ customerID +"' WHERE carID='" +carID+"';");
            }
            else {
                System.out.println("ERROR");
            }
        }
    public static void main(String[] args) {
        CarPanel mycarp = new CarPanel();
    }
}
