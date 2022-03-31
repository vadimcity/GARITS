package GUI;

import javax.swing.*;
import java.awt.*;

public class PendingJobPanel extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JButton selectJobButton;
    private JTable table1;

    private JPanel pendingJobPanel;

    public PendingJobPanel() {
        //testIDslot();

//        super(parent);
        setTitle("PendingJobPanel");
        setContentPane(pendingJobPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }
    public static void main(String[] args) {
        PendingJobPanel mypjp = new PendingJobPanel();
    }
}
