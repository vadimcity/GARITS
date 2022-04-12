package GUI;

import DB.DatabaseConnection;
import System.StockControlSystem;
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
    private JButton jobIDButton;
    private JButton typeButton;
    private JButton amountButton;
    private JButton getPartsButton;
    private JButton fillJobSheetButton;
    private JButton pickNewJobButton;
    private JTable table1;

    public MechanicPanel() {
        //testIDslot();

//        super(parent);
        setTitle("MechanicPanel");
        setContentPane(mechanicPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "button pressed");
                fillform();
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

            PDField jobNo = acroForm.getField("jobNo");
            jobNo.setValue("7862");
            System.out.println("value set");
            /*make the final document uneditable*/
            acroForm.flatten();
            /*generate a new pdf file and save it to the given location*/
            pdfDoc.save(new File("./jobSheets/3.pdf"));

        } catch (IOException e) {
            e.printStackTrace();
        }
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
