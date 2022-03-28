package DB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;

import static DB.DatabaseConnection.*;

public class BackupUI extends JDialog{
    private JButton backupButton;
    private JPanel BackupPanel;
    private JButton restoreButton;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JComboBox comboBox1;
    private JButton deleteRestorePointButton;


    public BackupUI () {
//        super(parent);
        setContentPane(BackupPanel);
        setMinimumSize(new Dimension(730, 220));
        setModal(true);
//        setLocationRelativeTo(parent);

        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
                    Process process = Runtime.getRuntime().exec("./scripts/backup-db.sh " + textFieldUsername.getText() + " " + passwordField.getText());

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        JOptionPane.showMessageDialog(null, line);
                    }

                    reader.close();

                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
           }
        });
        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        deleteRestorePointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        setVisible(true);
    }
}
