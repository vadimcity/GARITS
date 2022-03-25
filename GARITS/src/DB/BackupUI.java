package DB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static DB.DatabaseConnection.*;

public class BackupUI extends JDialog{
    private JButton backupButton;
    private JPanel BackupPanel;
    private JButton restoreButton;


    public BackupUI () {
//        super(parent);
        setContentPane(BackupPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
//        setLocationRelativeTo(parent);

        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    DriverManager.getConnection(database_url, mysqlUser, mysqlPassword);
                    Process process = Runtime.getRuntime().exec("lsblk");

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }

                    reader.close();

                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
           }
        });
        setVisible(true);
    }
}
