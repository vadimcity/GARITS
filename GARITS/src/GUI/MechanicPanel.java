package GUI;

import javax.swing.*;
import java.awt.*;

public class MechanicPanel extends JDialog {
    private JButton backButton;
    private JButton logOutButton;
    private JTextField jobIDTextField;
    private JTextField hoursTextField;
    private JTextField minutesTextField;
    private JTextField secondsTextField;
    private JTextField jobIDTextField1;
    private JTextField typeTextField;
    private JTextField amountTextField;
    private JButton changeDurationOfJobButton;
    private JButton orderPartsButton;
    private JTable table1;
    private JButton pickNewJobButton;
    private JButton fillJobSheetButton;
    private JPanel mechanicPanel;


    public MechanicPanel() {
//        super(parent);
        setTitle("Mechanic");
        setContentPane(mechanicPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
    }
}