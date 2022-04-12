package GUI;

import javax.swing.*;
import java.awt.*;

public class FranchiseePanel extends JDialog{
    private JTable table1;
    private JButton createAlterAccountHolderButton;
    private JButton forepsersonButton;
    private JButton logOutButton;
    private JTextField customerIDTextField;
    private JComboBox comboBox1;

    private JPanel franchiseePanel;

    public FranchiseePanel() {
        //testIDslot();

//        super(parent);
        setTitle("CarPanel");
        setContentPane(franchiseePanel);
        setMinimumSize(new Dimension(650, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void main(String[] args) {
        FranchiseePanel myfp = new FranchiseePanel();
    }
}
