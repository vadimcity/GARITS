package GUI;

import DB.DatabaseConnection;

import javax.swing.*;

public class ForepersonPanel {
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

    int x = 0;

    public Foreperson(String un, String pw, StockControlSystem scs){
        super("Roles.Foreperson", un,pw, scs);
    }
    public Foreperson(String role, String un, String pw, StockControlSystem scs){
        super(role, un,pw, scs);
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

}
