package DB;

import GUI.AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.DatabaseConnection.*;

public class BackupUI extends JDialog{
    private JButton backupButton;
    private JPanel BackupPanel;
    private JButton restoreButton;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JComboBox comboBox1;
    private JButton deleteRestorePointButton;
    private JButton adminPanelButton;


    public BackupUI () {
        setContentPane(BackupPanel);
        setMinimumSize(new Dimension(730, 220));
        setModal(true);
        try {
            boxIN();
        } catch (IOException e) {
            e.printStackTrace();
        }


        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                try {
                    Process process = Runtime.getRuntime().exec("./scripts/backup-db.sh " + textFieldUsername.getText() + " " + passwordField.getText());
//                    Process process = Runtime.getRuntime().exec("pwd");

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        JOptionPane.showMessageDialog(null, line);
//                        System.out.println(line);
                    }

                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                setVisible(true);
           }
        });
        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Process process = Runtime.getRuntime().exec("./scripts/restore-db.sh " + textFieldUsername.getText() + " " + passwordField.getText() + " " + comboBox1.getSelectedItem());

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        JOptionPane.showMessageDialog(null, line);
                    }

                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

//                labelVersion.setText((String) comboBox1.getSelectedItem());

            }
        });
        deleteRestorePointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Process process = Runtime.getRuntime().exec("./scripts/delete-restore.sh " +comboBox1.getSelectedItem());

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        JOptionPane.showMessageDialog(null, line);
                    }

                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                comboBox1.removeItem(comboBox1.getSelectedItem());

//                labelVersion.setText((String) comboBox1.getSelectedItem());

            }
        });
        adminPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                AdminPanel AP = new AdminPanel();
            }
        });

        setVisible(true);
    }
    public void boxIN() throws IOException {

        File filePath = new File("./backups/restore-point.txt");

        BufferedReader input = new BufferedReader(new FileReader(filePath));
        Object[] lines = input.lines().toArray();

        for (int i = 0; i < lines.length; i++){
            String line2 = lines[i].toString();
            comboBox1.addItem(line2);
        }
    }
}
