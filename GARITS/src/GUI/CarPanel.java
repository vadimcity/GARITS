package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarPanel extends JDialog{
    private JButton backButton;
    private JButton logOutButton;
    private JTextField carIDTextField;
    private JButton removeCarButton;
    private JButton editCarButton;
    private JTextField registerNoTextField;
    private JButton addCarButton;
    private JTextField customerIDTextField;

    private JPanel carPanel;

    public CarPanel() {
        //testIDslot();

//        super(parent);
        setTitle("CarPanel");
        setContentPane(carPanel);
        setMinimumSize(new Dimension(1290, 300));
        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void main(String[] args) {
        CarPanel mycarp = new CarPanel();
    }
}
