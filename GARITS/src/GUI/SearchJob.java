package GUI;

import DB.DatabaseConnection;
import System.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchJob extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JTextField carNoTextField;
    private JButton searchJobButton;
    private JTable table1;
    private JButton produceInvoiceButton;

    private JPanel searchJobPane;
    private JTextField Custno;
    private JTextField Mechno;
    private JTextField Carno;
    private JScrollPane jsp;
    private int Carnumber;

    public SearchJob() {
        Main.updateMain("SearchJob");
        //testIDslot();

//        super(parent);
        setTitle("SearchJobPanel");
        setContentPane(searchJobPane);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        displayTable("SELECT * FROM joblist WHERE jobstatus='active'");
        searchJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchingJob();
                //test();
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

    public void searchingJob(){ // " (including searching for a specific job by car number, name of the customer, etc.) "    from GARITS spec
        String sql = "";
        //test whether Carno is a number
        if(!(Carno.getText() == "")) {
            try { int Carnumber = Integer.parseInt(Carno.getText()); System.out.println("Success");
            } catch (Exception e) { System.out.println("Not a number"); }
        }
        //decide which sql method to use
        if(!Carno.getText().isEmpty()){
            //int c = Integer.parseInt(Carno.getText());
            if(!Custno.getText().isEmpty()){
                if(!Mechno.getText().isEmpty()){ sql = searchingJobCarCustomerMechanic(); }
                else{ sql = searchingJobCarCustomer(); }
            }
            else if(!Mechno.getText().isEmpty()){ sql = searchingJobCarMechanic(); }
            else{ sql = searchingJobCar(); }
        }
        else{
            if(!Custno.getText().isEmpty()){
                if(!Mechno.getText().isEmpty()){ sql = searchingJobCustomerMechanic(); }
                else{ sql = searchingJobCustomer(); }
            }
            else if(!Mechno.getText().isEmpty()){ sql = searchingJobMechanic(); }
        }
        //display the table by using the sql String
        displayTable(sql);
    }

    public String searchingJobCar(){ return ""; }
    public String searchingJobCustomer(){ return ""; }
    public String searchingJobMechanic(){ return ""; }

    public String searchingJobCarCustomer(){ return ""; }
    public String searchingJobCarMechanic(){ return ""; }
    public String searchingJobCustomerMechanic(){ return ""; }
    public String searchingJobCarCustomerMechanic(){ return ""; } //String sql = SELECT * FROM Joblist WHERE active=true, carID=x, customerID=y, mechanic=z;

    public void displayTable(String sql){
        //String[][] s = DatabaseConnection.databaseReturnTable(sql);
        String[][] s =
                {{"Name", "Age", "Sex"},
                        {"Daisy", "19", "Female"},
                        {"Jim", "20", "Male"},
                        {"Johann", "21", "Male"},
                        {"Johanna", "30", "FeMale"},
                        {"Tabatha", "16", "FeMale"},
                        {"Mary", "62", "FeMale"},
                        {"Anton", "93", "Male"}};

        String[] columns = Main.convertToColumns(s);
        String[][] data = Main.convertToPureData(s);

        table1.setModel(new DefaultTableModel(data, columns));
    }

    public static void main(String[] args) {
        SearchJob mysjp = new SearchJob();
    }
}



/*    String[][] s =
            {{"Name", "Age", "Sex"},
                    {"Daisy", "19", "Female"},
                    {"Jim", "20", "Male"},
                    {"Johann", "21", "Male"}};

    //i = row, j = column

    //columns holds names of columns, from the first row            s.length = rows, s[0].length = columns
    //data = data excluding column names
    String[] columns = new String[s[0].length];
    String[][] data = new String[s[0].length][s.length - 1];

        System.out.println("data: " + s[1][2] + " and s.length = " + s.length);

                for (int i = 0; i < s[0].length; i++){  columns[i] = s[0][i];  System.out.println(columns[i]);  }
        for (int i = 1; i < s.length; i++){
        for (int j = 0; j < s[0].length; j++){
        data[i-1][j] = s[i][j];
        System.out.println(data[i-1][j]);
        }
        }
        System.out.println("data: " + data); */
