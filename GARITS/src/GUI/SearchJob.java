package GUI;

import javax.swing.*;
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
    private int Carnumber;

    public SearchJob() {
        //testIDslot();

//        super(parent);
        setTitle("SearchJobPanel");
        setContentPane(searchJobPane);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        System.out.println("Heydiddledee");
        searchJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchingJob();
                //test();
            }
        });
        setVisible(true);
    }

    public void searchingJob(){ // " (including searching for a specific job by car number, name of the customer, etc.) "    from GARITS spec
        String sql = "";
        //test whether Carno is a number
        if(!(Carno.getText() == "")) {
            try { int Carnumber = Integer.parseInt(Carno.getText()); System.out.println("Success");
            } catch (Exception e) { System.out.println("Not a number bro"); }
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

    public void displayTable(String sql){ }

    public static void main(String[] args) {
        SearchJob mysjp = new SearchJob();
        System.out.println("Heydiddledee");
    }
}
