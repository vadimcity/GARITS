package GUI;

import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistStockControl extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JTextField type1;
    private JTextField type2;
    private JTextField type3;
    private JButton orderPartsButton;
    private JTable table1;

    private JPanel receptionistStockControl;
    private JButton sellSpareParts;
    private JButton changePrice;
    private JTextField amount1;
    private JTextField amount2;
    private JTextField newPrice;

    public ReceptionistStockControl() {
        Main.updateMain("ReceptionistStockControl");
        //testIDslot();

//        super(parent);
        setTitle("ReceptionistStockControl");
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
        orderPartsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderParts();
            }
        });
        sellSpareParts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellSpareParts();
            }
        });
        changePrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePrice();
            }
        });

        setVisible(true);
    }

    public void orderParts(){}
    public void sellSpareParts(){}
    public void changePrice(){}

    public static void main(String[] args) {
        ReceptionistStockControl myrsc = new ReceptionistStockControl();
    }
}
