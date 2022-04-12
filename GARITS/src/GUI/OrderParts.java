package GUI;

import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderParts  extends JDialog{
    private JTable table1;
    private JTextField textField1;
    private JButton searchButton;
    private JPanel partsPanel;
    private JButton logOutButton;
    private JButton backButton;

    public OrderParts () {
        Main.updateMain("OrderParts");
        setTitle("Parts List");
        setContentPane(partsPanel);
        setMinimumSize(new Dimension(430,620));
        setModal(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    public static void main (String[] args){
        OrderParts dbParts = new OrderParts();
    }
}
