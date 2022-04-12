package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
    private JLabel navigate;
    public static ImageIcon image = new ImageIcon("GUI/logo/final-logo.png");

    private int roleno;

    public MainPanel() {
//        super(parent);
        setTitle("MainPanel");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(500, 220));
        //setIconImage(image.getImage());
        //getContentPane().setBackground(new Color(51, 172, 159));
        //getContentPane().setBackground(Color.CYAN);

        //n.setIcon(image);

        navigate.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        navigate.setHorizontalAlignment(JLabel.CENTER);

        allButtons();
        calculateRole();
        setup();
        logoutButton.setEnabled(true);

        setModal(true);
//        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void allButtons(){
        dampenButton(adminPanelButton); dampenButton(forepersonPanelButton); dampenButton(franchiseePanelButton); dampenButton(mechanicPanelButton); dampenButton(receptionistPanelButton); dampenButton(logoutButton);
    }
    private void dampenButton(JButton b){
        b.setEnabled(false);
        b.setFocusable(false);
    }

    private void calculateRole(){
        if(Main.getRole().equals("Admin")){ roleno = 1; }
        else if(Main.getRole().equals("Foreperson")){ roleno = 2; }
        else if(Main.getRole().equals("Franchisee")){ roleno = 3; }
        else if(Main.getRole().equals("Mechanic")){ roleno = 4; }
        else if(Main.getRole().equals("Receptionist")){ roleno = 5; }
        else{
            System.out.println("Role not correct, role = " + Main.getRole() + " roleno = " + roleno);
        }
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
            adminPanelButton.setEnabled(true);
        }
        if((roleno == 2) || (roleno == 3)) {
            forepersonPanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    ForepersonPanel fp = new ForepersonPanel();
                }
            });
            forepersonPanelButton.setEnabled(true);
        }
        if((roleno == 3)) {
            franchiseePanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    FranchiseePanel frp = new FranchiseePanel();
                }
            });
            franchiseePanelButton.setEnabled(true);
        }
        if((roleno == 2) || (roleno == 3) || (roleno == 4)) {
            mechanicPanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    MechanicPanel mp = new MechanicPanel();
                }
            });
            mechanicPanelButton.setEnabled(true);
        }
        if((roleno == 2) || (roleno == 3) || (roleno == 5)) {
            receptionistPanelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    ReceptionistPanel rp = new ReceptionistPanel();
                }
            });
            receptionistPanelButton.setEnabled(true);
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

