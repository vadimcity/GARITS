package GUI;

import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PendingJobPanel extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JButton selectJobButton;
    private JTable table1;

    private JPanel pendingJobPanel;

    public PendingJobPanel() {
        Main.updateMain("PendingJobPanel");
        //testIDslot();

//        super(parent);
        setTitle("PendingJobPanel");
        setContentPane(pendingJobPanel);
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
        PendingJobPanel mypjp = new PendingJobPanel();
    }
}
