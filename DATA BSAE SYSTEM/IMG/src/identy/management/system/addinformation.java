package identy.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
public class addinformation extends JFrame {
    JTextField tname,tfname,taddress,tphone,tnid;
    JDateChooser tdob;
    addinformation(){
        getContentPane().setBackground(new Color(173,216,230));
        JLabel heading=new JLabel("Add Informormatin Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        //NAME
        JLabel name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);
        //name
        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);
        //father name
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        //texfild father
        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        //BIRTH
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);
        tdob=new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);





        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new addinformation();

    }
}
