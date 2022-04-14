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
    private JTextField yearTextField;

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
                addCar(makeTextField.getText(),modelTextField.getText(),yearTextField.getText(),colourTextField.getText(),registerNoTextField.getText(),engineTextField.getText(),chassisNoTextField.getText(),customerIDTextField.getText());
            }
        });
        editCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editCar(carIDTextField.getText(),registerNoTextField.getText(),makeTextField.getText(),modelTextField.getText(),engineTextField.getText(),chassisNoTextField.getText(),colourTextField.getText(),yearTextField.getText(),customerIDTextField.getText());
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
            DatabaseConnection.databaseAffectTemplate("DELETE FROM vehicle WHERE vehicleID='" + carID + "';");
    }
        public void addCar(String make, String model,String year, String colour, String registerNo, String engineSerial, String chassisNo, String customerID ) {
            DatabaseConnection.databaseAffectTemplate("INSERT INTO vehicle(regNumber, brand, model, engineSerial, chassisNumber, colour, year, ID)\n" +
                    "VALUES ('"+registerNo+"','"+ make +"','"+ model +"','"+engineSerial+"','"+chassisNo+"','"+colour+"','"+year+"','"+customerID+"');");
        }
        public void editCar(String carID, String registerNo, String make,String model, String engineSerial, String chassisNo, String colour,String year, String customerID)  {
            if (!registerNoTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET registerNo = '"+ registerNo +"' WHERE carID='" +carID+"';");
            }
            else if (!makeTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET brand = '"+ make +"' WHERE carID='" +carID+"';");
            }
            else if (!modelTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET model = '"+ model +"' WHERE carID='" +carID+"';");
            }
            else if (!engineTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET engineSerial = '"+ engineSerial +"' WHERE carID='" +carID+"';");
            }
            else if (!chassisNoTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET chassisNo = '"+ chassisNo +"' WHERE carID='" +carID+"';");
            }
            else if (!colourTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET colour = '"+ colour +"' WHERE carID='" +carID+"';");
            }
            else if (!yearTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET year = '"+ year +"' WHERE carID='" +carID+"';");
            }
            else if (!customerIDTextField.getText().isEmpty()) {
                DatabaseConnection.databaseAffectTemplate("UPDATE vehicle SET ID = '"+ customerID +"' WHERE carID='" +carID+"';");
            }
            else {
                System.out.println("ERROR");
            }
        }
    public static void main(String[] args) {
        CarPanel mycarp = new CarPanel();
    }
}
