package GUI;

import javax.swing.*;
import java.awt.*;

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
        //testIDslot();

//        super(parent);
        setTitle("CarPanel");
        setContentPane(receptionistStockControl);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void main(String[] args) {
        ReceptionistStockControl myrsc = new ReceptionistStockControl();
    }
}
