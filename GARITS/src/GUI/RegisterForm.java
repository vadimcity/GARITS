package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JDialog{
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldMobile;
    private JTextField textFieldAddress;
    private JButton submitButton;
    private JButton clearButton;
    private JPanel registerPanel;


    public RegisterForm(JFrame parent) {
        super(parent);
        setTitle("Register Form");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(430, 220));
        setModal(true);
        setLocationRelativeTo(parent);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldAddress.setText("");
                textFieldSurname.setText("");
                textFieldMobile.setText("");
                textFieldName.setText("");

            }
        });
        setVisible(true);

    }

    private void submitForm() {
    }

    public static void main (String[] args){
            RegisterForm reg = new RegisterForm (null);

        }

}
