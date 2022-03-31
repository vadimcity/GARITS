package GUI;

import DB.DatabaseConnection;
import System.StockControlSystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MechanicPanel extends JDialog {
    int x = 0;
    StockControlSystem scs;
    private JPanel mechanicPanel;

    public MechanicPanel() {
        //testIDslot();

//        super(parent);
        setTitle("MechanicPanel");
        setContentPane(mechanicPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }


    public void pickJob(){
        //read dropdown list of jobs (formed using databaseReturnString(String sql)) and choose one         possibly table or something else instead
        //so first, form an array of strings, or some array that's required, for the dropdown/table to implement

        ArrayList<String> al = DatabaseConnection.databaseReturnString(
                "SELECT * FROM pendingjoblist", "Details");
    }
    public void changeDurationOfJob(int JobID, int hours, int minutes, int seconds){
        DatabaseConnection.databaseAffectTemplate("UPDATE activeJoblist SET Duration = '" + hours + ":" + minutes + ":" + seconds + "' WHERE JobID='" + JobID + "'");
    }

    public void fillJobSheet(){
    }
    public void printTheJobSheet(){
    }

    public void getParts () { scs.getParts(); }

    public static void main(String[] args) {
        MechanicPanel mymp = new MechanicPanel();
    }
}
