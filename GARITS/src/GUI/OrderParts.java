package GUI;

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

    public OrderParts (JFrame parent) {
        super(parent);
        setTitle("Parts List");
        setContentPane(partsPanel);
        setMinimumSize(new Dimension(430,620));
        setModal(true);
        setLocationRelativeTo(parent);
        setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main (String[] args){
        OrderParts dbParts = new OrderParts(null);
    }
}
