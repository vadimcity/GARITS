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
    private JComboBox comboBox1;

    private JPanel receptionistPanel;

    private StockControlSystem scs;

    public ReceptionistPanel() {
//        super(parent);
        setTitle("ReceptionistPanel");
        setContentPane(receptionistPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
//        setLocationRelativeTo(parent);
        addToPendingJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeInNewJobs(Integer.parseInt(vehicleIDTextField.getText()));
            }
        });
        setVisible(true);
    }



    public void produceInvoice(){
    }

    public void createCustomerRecord(){
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
        ArrayList<Integer> al = DatabaseConnection.databaseReturnInt("SELECT * FROM joblist", "CustomerID");

        JobID = IDSlotIn(al, 0);

        //DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + JobID + "', '" + CustomerID + "', 'NULL', 'NULL')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + JobID + "', '" + "pending" + "', 'NULL', " + vehicleID + "', 'NULL', 'NULL')");
    }
    private int IDSlotIn(ArrayList<Integer> al, int min){
        int x;
        int count = 0;
        boolean foundspace = false;
        //find a free slot
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.size(); i++) {
                if ((al.get(i)+1) == al.get(j)) { count++; }
            }
            if(count == 0){ return al.get(i)+1; }
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

    public void monitorProgressJob(){           // " (including searching for a specific job by car number, name of the customer, etc.) "    from GARITS spec
    }
    public void searchJob(){
    }

    public void stockAlertPopup () { scs.stockAlertPopUp(); }

    public void orderParts () { scs.orderParts(); }
    public void sellSpareParts () { scs.sellSpareParts(); }


    public static void main(String[] args) {
        ReceptionistPanel myrp = new ReceptionistPanel();
    }
}
