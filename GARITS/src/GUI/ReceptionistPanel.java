package GUI;

import DB.DatabaseConnection;
import System.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReceptionistPanel extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JTextField jobIDTextField;
    private JTextField vehicleIDTextField;
    private JTextField detailsTextField;
    private JButton addToPendingJobButton;
    private JButton produceInvoiceButton;
    private JTextField dateTextField;
    private JTextField addressTextField;
    private JButton createButton;
    private JComboBox DPcomboBox;
    private JPanel receptionistPanel;
    private JTextField firstNameTextField;
    private JTextField postcodeTextField;
    private JTextField telephoneNoTextField;
    private JTextField emailTextField;
    private JTextField custIDTextField;
    private JTextField surnameTextField;

    private StockControlSystem scs;

    public ReceptionistPanel() {
        Main.updateMain("ReceptionistPanel");
        //testIDslot();

//        super(parent);
        setTitle("ReceptionistPanel");
        setContentPane(receptionistPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        addToPendingJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeInNewJobs(Integer.parseInt(vehicleIDTextField.getText()));
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCustomerRecord();
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

    public void testIDslot(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0); al.add(1); al.add(2); al.add(3); al.add(4); al.add(5);
        System.out.println(IDSlotIn(al, 0));
    }


    public void produceInvoice(){
    }

    public void createCustomerRecord(){
        //ID, Date, firstName, Surname, Address, Postcode, Telephone No, Email, DiscountPlan
        String sql = "INSERT INTO customermemberlist VALUES ("
                + custIDTextField.getText() + "," + dateTextField.getText() + "," + firstNameTextField.getText() + "," +
                surnameTextField.getText() + "," + addressTextField.getText() + "," + postcodeTextField.getText() + "," +
                Integer.parseInt(telephoneNoTextField.getText()) + "," + emailTextField.getText() + "," +
                (String)DPcomboBox.getSelectedItem() + ")";
        DatabaseConnection.databaseAffectTemplate(sql);
    }

    //Attributes of job table:
//    jobID		int(10)
//    jobStatus	str
//    timeTaken	int(10)						N
//    VehicleID	int(10)		taken from vehicle table
//    username	str		taken from user table		N
//    bookingID	int(10)		taken from booking table	N
    public void takeInNewJobs(int vehicleID){
        int JobID = 2468;
        //for now use this random JobID number      but later, implement a method that reads from current job ids, and adds 1 to the greatest one to create a new ID
        // at 10,000, which this function should never reach, this function starts over again at 1

        //ArrayList<Integer> alpending = DatabaseConnection.databaseReturnInt("SELECT * FROM pendingjoblist", "CustomerID");
        //ArrayList<Integer> alactive = DatabaseConnection.databaseReturnInt("SELECT * FROM activejoblist", "CustomerID");
        //alpending.addAll(alactive);
        ArrayList<Integer> al = DatabaseConnection.databaseReturnInt("SELECT * FROM joblist", "jobID");

        JobID = IDSlotIn(al, 0);

        //DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + JobID + "', '" + CustomerID + "', 'NULL', 'NULL')");
        //DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + JobID + "', '" + "pending" + "', 'NULL', " + vehicleID + "', 'NULL', 'NULL')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO joblist VALUES (" + JobID + ", 'pending', NULL, " + vehicleID + ", NULL, NULL)");
        //INSERT INTO joblist VALUES (4321, 'pending', NULL, 5432, NULL, NULL)
    }
    private int IDSlotIn(ArrayList<Integer> al, int min){
        int x;
        int count = 0;
        boolean foundspace = false;
        //find a free slot
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.size(); j++) {
                if ((al.get(i)+1) == al.get(j)) { count++; }
            }
            if(count == 0){ return al.get(i)+1; }
            count = 0;
        }
        //no slots, so add 1 to maximum
        x = IDmax(al,0) + 1;
        //if >= 10000, then we don't want an ID of that size. If there are both no slots AND max+1 >= 10000, then that means all IDs are bunched up near the top, leaving 0 free
        // if they were bunched at the top and bottom, even if al.get(al.size()) were about 3, 4 would be considered a free slot
        if(x >= 10000){ x = 0; }
        return x;
    }
    private int IDmax(ArrayList<Integer> al, int min){
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i) > min){ min = al.get(i); }
        }
        return min;
    }

    public void stockAlertPopup () { scs.stockAlertPopUp(); }

    public void orderParts () { scs.orderParts(); }
    public void sellSpareParts () { scs.sellSpareParts(); }


    public static void main(String[] args) {
        ReceptionistPanel myrp = new ReceptionistPanel();
    }
}
