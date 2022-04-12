package GUI;

import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistStockControl extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JTextField typeTextField;
    private JTextField typeTextField1;
    private JTextField typeTextField2;
    private JButton orderPartsButton;
    private JTable table1;

    private JPanel receptionistStockControl;

    public ReceptionistStockControl() {
        Main.updateMain("ReceptionistStockControl");
        //testIDslot();

//        super(parent);
        setTitle("CarPanel");
        setContentPane(receptionistStockControl);
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
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login l = new Login();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        ReceptionistStockControl myrsc = new ReceptionistStockControl();
    }
}
