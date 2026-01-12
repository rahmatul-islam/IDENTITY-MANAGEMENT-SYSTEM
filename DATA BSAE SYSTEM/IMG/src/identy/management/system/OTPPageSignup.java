package identy.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class OTPPageSignup extends JFrame implements ActionListener {
    JTextField totp;
    JButton verify, back;
    String generatedOTP, username, email, password;

    OTPPageSignup(String username, String email, String password, String otp) {
        this.generatedOTP = otp;
        this.username = username;
        this.email = email;
        this.password = password;

        JLabel label = new JLabel("Enter OTP:");
        label.setBounds(40,20,100,30);
        add(label);

        totp = new JTextField();
        totp.setBounds(150,20,150,30);
        add(totp);

        verify = new JButton("VERIFY");
        verify.setBounds(150,70,90,30);
        verify.addActionListener(this);
        add(verify);

        back = new JButton("BACK");
        back.setBounds(250,70,90,30);
        back.addActionListener(this);
        add(back);

        setSize(400,200);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verify) {
            String enteredOTP = totp.getText();
            if (enteredOTP.equals(generatedOTP)) {
                try {
                    conn conn = new conn();
                    String query = "INSERT INTO login VALUES ('"+username+"','"+email+"','"+password+"')";
                    conn.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Signup Successful!");
                    setVisible(false);
                    new Login(); // Signup শেষে Login পেজে যাবে
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null,"Invalid OTP!");
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new SignupPage();
        }
    }
}