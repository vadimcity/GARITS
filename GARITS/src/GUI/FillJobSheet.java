package GUI;

import System.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FillJobSheet extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JButton addDescriptionButton;
    private JTextField lineNoTextField;
    private JButton viewJobSheetButton;
    private JTextArea textArea1;

    private JPanel fjPanel;

    public FillJobSheet() {
        Main.updateMain("FillJobSheet");
        //testIDslot();

//        super(parent);
        setTitle("FillJobSheetPanel");
        setContentPane(fjPanel);
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
        FillJobSheet mycarp = new FillJobSheet();
    }
}
