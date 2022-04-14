package GUI;

import DB.DatabaseConnection;
import System.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PendingJobPanel extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JButton selectJobButton;
    private JTable table1;

    private JPanel pendingJobPanel;
    private JScrollPane jsp;

    public PendingJobPanel() {
        Main.updateMain("PendingJobPanel");
        //testIDslot();

//        super(parent);
        setTitle("PendingJobPanel");
        setContentPane(pendingJobPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
        //displayTable("SELECT * FROM joblist WHERE jobstatus='inactive'");
        displayTable("SELECT * FROM useraccounts");
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
        selectJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectJob();
            }
        });

        setVisible(true);
    }

    public void selectJob(){
        int selectedRow = table1.getSelectedRow();
        System.out.println("Row = " + selectedRow);
        System.out.println("Selected = " + table1.getValueAt(selectedRow,0));
        //get jobid of selected row
        table1.getValueAt(selectedRow,0);
    }

    public void displayTable(String sql){
        String[][] s = DatabaseConnection.databaseReturnTable(sql);

        String[] columns = Main.convertToColumns(s);
        String[][] data = Main.convertToPureData(s);

        table1.setModel(new DefaultTableModel(data, columns));
    }

    public static void main(String[] args) {
        PendingJobPanel mypjp = new PendingJobPanel();
    }
}
