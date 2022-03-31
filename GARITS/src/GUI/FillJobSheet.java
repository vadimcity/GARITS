package GUI;

import javax.swing.*;
import java.awt.*;

public class FillJobSheet extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JButton addDescriptionButton;
    private JTextField lineNoTextField;
    private JButton viewJobSheetButton;
    private JTextArea textArea1;

    private JPanel fjPanel;

    public FillJobSheet() {
        //testIDslot();

//        super(parent);
        setTitle("FillJobSheetPanel");
        setContentPane(fjPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void main(String[] args) {
        FillJobSheet mycarp = new FillJobSheet();
    }
}
