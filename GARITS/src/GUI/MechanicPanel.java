package GUI;

import DB.DatabaseConnection;
import System.*;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MechanicPanel extends JDialog {
    int x = 0;
    StockControlSystem scs;
    private JPanel mechanicPanel;
    private JButton backButton;
    private JButton logOutButton;
    private JTextField jobIDTextField;
    private JTextField hoursTextField;
    private JTextField minutesTextField;
    private JTextField secondsTextField;
    private JButton changeDurationOfJobButton;
    private JButton getPartsButton;
    private JButton fillJobSheetButton;
    private JButton pickNewJobButton;
    private JTable table1;
    private JScrollPane jsp;
    private JTextField jobIDTextField1;
    private JTextField typeTextField;
    private JTextField amountTextField;

    public MechanicPanel() {
        Main.updateMain("MechanicPanel");
        //testIDslot();

//        super(parent);
        setTitle("MechanicPanel");
        setContentPane(mechanicPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
        displayTable("SELECT * FROM joblist WHERE username='John'");
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

        fillJobSheetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillJobSheet(jobIDTextField.getText());
            }
        });
        pickNewJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PendingJobPanel p = new PendingJobPanel();
            }
        });

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

    public void fillform(){
        InputStream input = null;
        System.out.println("button pressed");
        try {
            input = new FileInputStream(new File("./jobsheetForm.pdf"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try (PDDocument pdfDoc = Loader.loadPDF(input);) {
            System.out.println("loaded");
            PDDocumentCatalog docCatalog = pdfDoc.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();

            PDField hours = acroForm.getField("hours");
            String timeTaken = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist WHERE jobID='3259';","timeTaken"));
            hours.setValue(timeTaken);
            System.out.println("value set");
            /*make the final document uneditable*/
            acroForm.flatten();
            /*generate a new pdf file and save it to the given location*/
            pdfDoc.save(new File("./jobSheets/5.pdf"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fillJobSheet(String jobID){
        InputStream input = null;

        String timeTaken = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist WHERE jobID='"+jobID+"';","timeTaken"));
        String vehicleReg = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist INNER JOIN vehicle ON joblist.vehicleID=vehicle.vehicleID WHERE jobID='"+jobID+"';","regNumber"));
        String make = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist INNER JOIN vehicle ON joblist.vehicleID=vehicle.vehicleID WHERE jobID='"+jobID+"';","brand"));
        String model = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist INNER JOIN vehicle ON joblist.vehicleID=vehicle.vehicleID WHERE jobID='"+jobID+"';","model"));

        String vehicleID = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist INNER JOIN vehicle ON joblist.vehicleID=vehicle.vehicleID WHERE jobID='"+jobID+"';","vehicleID"));
        String name = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM vehicle INNER JOIN customermemberlist ON vehicle.ID=customermemberlist.ID WHERE vehicleID='"+vehicleID+"';","Name"));
        String tel = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM vehicle INNER JOIN customermemberlist ON vehicle.ID=customermemberlist.ID WHERE vehicleID='"+vehicleID+"';","TelephoneNo"));


        String dateBooked = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist INNER JOIN booking ON joblist.bookingID=booking.bookingID WHERE jobID='"+jobID+"';","dateBooked"));
        String descOfWork1 = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM joblist INNER JOIN booking ON joblist.bookingID=booking.bookingID WHERE jobID='"+jobID+"';","descriptionOfWork"));

        String partNo1 = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM Parts INNER JOIN joblist ON Parts.jobID = joblist.jobID WHERE Parts.jobID='"+jobID+"';","partNumber"));
        String part1Desc = (DatabaseConnection.databaseReturnIndivString("SELECT * FROM Parts INNER JOIN joblist ON Parts.jobID = joblist.jobID WHERE Parts.jobID='"+jobID+"';","partName"));


        try {
            input = new FileInputStream(new File("./jobsheetForm.pdf"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try (PDDocument pdfDoc = Loader.loadPDF(input);) {
            System.out.println("loaded");
            PDDocumentCatalog docCatalog = pdfDoc.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();

            PDField jobIDAcro = acroForm.getField("jobNo");
            PDField hours = acroForm.getField("hours");
            PDField vehicleRegPlate = acroForm.getField("vehicleReg");
            PDField brand = acroForm.getField("make");
            PDField modelAcro = acroForm.getField("Model");
            PDField customerName = acroForm.getField("customerName");
            PDField telAcro = acroForm.getField("telephone");



            PDField descOfWork1Acro = acroForm.getField("descOfWork1");
            PDField dateBookedAcro = acroForm.getField("dateBookedIn");

            PDField partNumber1Acro = acroForm.getField("partNo1");
            PDField partNumber1DescAcro = acroForm.getField("desc1");
            PDField qty1 = acroForm.getField("qty1");
            jobIDAcro.setValue(jobID);
            hours.setValue(timeTaken);
            vehicleRegPlate.setValue(vehicleReg);
            brand.setValue(make);
            modelAcro.setValue(model);
            dateBookedAcro.setValue(dateBooked);
            descOfWork1Acro.setValue(descOfWork1);
            customerName.setValue(name);
            telAcro.setValue(tel);

            partNumber1Acro.setValue(partNo1);
            partNumber1DescAcro.setValue(part1Desc);
            if (!partNo1.isEmpty()) {
                qty1.setValue("1");
            }









            System.out.println("value set");





            /*make the final document uneditable*/
            acroForm.flatten();
            /*generate a new pdf file and save it to the given location*/
            pdfDoc.save(new File("./jobSheets/"+jobID+".pdf"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printTheJobSheet(){
    }

    public void getParts () { scs.getParts(); }

    public void displayTable(String sql){
        String[][] s = DatabaseConnection.databaseReturnTable(sql);

        String[] columns = Main.convertToColumns(s);
        String[][] data = Main.convertToPureData(s);

        table1.setModel(new DefaultTableModel(data, columns));
    }

    public static void main(String[] args) {
        MechanicPanel mymp = new MechanicPanel();
    }
}
