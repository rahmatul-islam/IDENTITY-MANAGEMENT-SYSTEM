package identy.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignupPage extends JFrame implements ActionListener {
    JTextField tusername, temail;
    JPasswordField tpassword;
    JButton signup,back;

    SignupPage() {
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel email = new JLabel("Email");
        email.setBounds(40,70,100,30);
        add(email);

        temail = new JTextField();
        temail.setBounds(150,70,150,30);
        add(temail);

        JLabel password = new JLabel("Password");
        password.setBounds(40,120,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,120,150,30);
        add(tpassword);

        signup = new JButton("SIGNUP");
        signup.setBounds(150,180,150,30);
        signup.addActionListener(this);
        add(signup);

        back = new JButton("BACK");
        back.setBounds(150,220,150,30);
        back.addActionListener(this);
        add(back);




        setSize(400,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signup){
            String username = tusername.getText();
            String email = temail.getText();
            String password = tpassword.getText();

            //  OTP Generate
           String otp = OTPGenerator.generateOTP(6);

            // OTP Email পাঠানো
          SendEmail.sendOTP(email, otp);

            //  OTP Page ওপেন করা
           new OTPPageSignup(username, email, password, otp);
            setVisible(false);
        }
        else if (e.getSource()==back) {
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new SignupPage();
    }
}