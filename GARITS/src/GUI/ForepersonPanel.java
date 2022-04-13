package GUI;

import DB.DatabaseConnection;
import System.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForepersonPanel extends JDialog {
    private JButton backButton;
    private JButton logoutButton;
    private JTextField jobIDPending;
    private JTextField customerIDTextField;
    private JTextField detailsTextField;
    private JButton addJobToPendingButton;
    private JTextField jobIDAllocate;
    private JTextField mechanicNameTextField;
    private JTextField estimatedTimeTextField;
    private JButton allocateMechanicButton;
    private JButton viewPendingJobListButton;
    private JButton receptionistButton;
    private JButton mechanicButton;
    private JPanel forepersonPanel;

    int x = 0;

    public ForepersonPanel() {
        Main.updateMain("ForePersonPanel");
        //testIDslot();

//        super(parent);
        setTitle("ForepersonPanel");
        setContentPane(forepersonPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main.backPage();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login l = new Login();
            }
        });
        addJobToPendingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addJobToPendingList();
            }
        });
        allocateMechanicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allocateMechanic();
            }
        });
        setVisible(true);
    }


    public void allocateMechanic(){      //jobID, jobStatus, timeTaken, vehicleID, username, bookingID, details
        //convert entry for this jobID from "pending" to "active"
        DatabaseConnection.databaseAffectTemplate("UPDATE pendingjoblist SET jobStatus='active' WHERE JobID=" + jobIDAllocate);

//        int CustID; String details;
//        first read info of JobID in pendingjoblist, and copy them to CustID and details.          So for now we'll initialise them ourselves
//        CustID = DatabaseConnection.databaseReturnIndivInt(
//                "SELECT * FROM joblist WHERE JobID=" + jobIDPending, "CustomerID");
//        details = DatabaseConnection.databaseReturnIndivString(
//                "SELECT * FROM joblist WHERE JobID=" + jobIDPending, "Details");

        //DatabaseConnection.databaseAffectTemplate("DELETE FROM pendingjoblist WHERE JobID=" + JobID);
        //DatabaseConnection.databaseAffectTemplate("INSERT INTO activejoblist VALUES ('" + JobID + "', '" + CustID + "', '" + time + "', '" + Mechanic + "', '" + details + "')");

        //update the rest of the row
        DatabaseConnection.databaseAffectTemplate("UPDATE pendingjoblist SET timeTaken='" + estimatedTimeTextField + "' WHERE JobID=" + jobIDAllocate);
        DatabaseConnection.databaseAffectTemplate("UPDATE pendingjoblist SET username='" + mechanicNameTextField + "' WHERE JobID=" + jobIDAllocate);
        //DatabaseConnection.databaseAffectTemplate("UPDATE pendingjoblist SET bookingID='" + bookingIDtextfield "' WHERE JobID=" + jobIDAllocate);
    }
    public void addJobToPendingList(){      //jobID, jobStatus, timeTaken, vehicleID, username, bookingID, details
        //DatabaseConnection.databaseAffectTemplate("INSERT INTO joblist VALUES ('" + jobIDAllocate + "', 'pending', '" + estimatedTimeTextField
        //        + "', '" + vehicleID + "', 'NULL', 'NULL', 'Null')");
    }

    public static void main(String[] args) {
        ForepersonPanel myfp = new ForepersonPanel();
    }

}
