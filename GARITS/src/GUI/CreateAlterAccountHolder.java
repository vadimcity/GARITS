package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateAlterAccountHolder extends JDialog{
    private JButton backButton;
    private JTextField dateTextField;
    private JTextField addressTextField;
    private JButton saveButton;
    private JComboBox comboBox1;
    private JButton logOutButton;
    private JButton createButton1;
    private JTextField customerIDTextField;

    private JPanel caaPanel;

    public CreateAlterAccountHolder() {
        //testIDslot();

//        super(parent);
        setTitle("CreateAlterAccountHolderPanel");
        setContentPane(caaPanel);
        setMinimumSize(new Dimension(700, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void main(String[] args) {
        CreateAlterAccountHolder mycaap = new CreateAlterAccountHolder();
    }
}
