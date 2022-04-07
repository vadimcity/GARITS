package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import System.*;

public class MainPanel extends JDialog {
    private JPanel mainPanel;
    private JButton receptionistPanelButton;
    private JButton mechanicPanelButton;
    private JButton adminPanelButton;
    private JButton logoutButton;
    private JButton franchiseePanelButton;
    private JButton forepersonPanelButton;
    private JLabel n;
    private JLabel n2;
    public static ImageIcon image = new ImageIcon("GUI/logo/final-logo.png");

    private int roleno;

    public MainPanel() {
//        super(parent);
        setTitle("MainPanel");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(430, 220));
        //setIconImage(image.getImage());
        //getContentPane().setBackground(new Color(51, 172, 159));
        //getContentPane().setBackground(Color.CYAN);

        //n.setIcon(image);

        calculateRole();
        setup();

        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void calculateRole(){
        if(Main.getRole() == "Admin"){ roleno = 1; }
        if(Main.getRole() == "Foreperson"){ roleno = 2; }
        if(Main.getRole() == "Franchisee"){ roleno = 3; }
        if(Main.getRole() == "Mechanic"){ roleno = 4; }
        if(Main.getRole() == "Receptionist"){ roleno = 5; }
    }

    private void setup(){
        if((roleno == 1)) {
            adminPanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    AdminPanel ap = new AdminPanel();
                }
            });
        }
        if((roleno == 2) || (roleno == 3)) {
            forepersonPanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    ForepersonPanel fp = new ForepersonPanel();
                }
            });
        }
        if((roleno == 3)) {
            franchiseePanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    FranchiseePanel frp = new FranchiseePanel();
                }
            });
        }
        if((roleno == 2) || (roleno == 3) || (roleno == 4)) {
            mechanicPanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    MechanicPanel mp = new MechanicPanel();
                }
            });
        }
        if((roleno == 2) || (roleno == 3) || (roleno == 5)) {
            receptionistPanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    ReceptionistPanel rp = new ReceptionistPanel();
                }
            });
        }
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
            }
        });
    }

    public static void main (String[] args){
        MainPanel mp = new MainPanel();
        //mp.setIconImage(image.getImage());
    }
}

