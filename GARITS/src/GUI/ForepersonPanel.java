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
    private JTextField jobIDTextField;
    private JTextField customerIDTextField;
    private JTextField detailsTextField;
    private JButton addJobToPendingButton;
    private JTextField jobIDTextField1;
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
        setVisible(true);
    }


    public void allocateMechanic(int JobID, String Mechanic, String time){
        int CustID; String details;
        //first read info of JobID in pendingjoblist, and copy them to CustID and details.          So for now we'll initialise them ourselves

        CustID = DatabaseConnection.databaseReturnIndivInt(
                "SELECT * FROM pendingjoblist WHERE JobID=" + JobID, "CustomerID");
        details = DatabaseConnection.databaseReturnIndivString(
                "SELECT * FROM pendingjoblist WHERE JobID=" + JobID, "Details");

        DatabaseConnection.databaseAffectTemplate("DELETE FROM pendingjoblist WHERE JobID=" + JobID);
        DatabaseConnection.databaseAffectTemplate("INSERT INTO activejoblist VALUES ('" + JobID + "', '" + CustID + "', '" + time + "', '" + Mechanic + "', '" + details + "')");
    }
    public void addJobToPendingList(){
    }

    public static void main(String[] args) {
        ForepersonPanel myfp = new ForepersonPanel();
    }

}
