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

    public SearchJob() {
        //testIDslot();

//        super(parent);
        setTitle("SearchJobPanel");
        setContentPane(searchJobPane);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
        searchJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchingJob();
            }
        });
    }

    public void searchingJob(){
    }

    public static void main(String[] args) {
        SearchJob mysjp = new SearchJob();
    }
}
