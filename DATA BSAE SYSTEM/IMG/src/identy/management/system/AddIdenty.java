package identy.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddIdenty extends JFrame implements ActionListener {
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JTextField tname,tfname,tmname,taddress,tphone,tnidnumber,tpostcode;

    JLabel tcitizeid;

    JDateChooser tdob;

    JButton add,back;

    JComboBox bloodgroup,genderbox;
    AddIdenty(){
        getContentPane().setBackground(new Color(53,90,153));

        //level
        JLabel heading =new JLabel("ADD IDENTY");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
      //name
        JLabel name =new JLabel("NAME");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);
        //gardian
        JLabel fname =new JLabel("Father Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);
        //dob
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob=new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);
        //mother
        JLabel mname =new JLabel("Mother Name");
        mname.setBounds(400,200,150,30);
        mname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(mname);

        tmname=new JTextField();
        tmname.setBounds(600,200,150,30);
        tmname.setBackground(new Color(177,252,197));
        add(tmname);
        //adress
        JLabel address =new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        //phone
        JLabel phone =new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);
        //post
        Label post = new Label("Post code");//ভুল হতে পারে
        post.setBounds(50,300,150,30);
        post.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(post);

        tpostcode=new JTextField();
        tpostcode.setBounds(200,300,150,30);
        tpostcode.setBackground(new Color(177,252,197));
        add(tpostcode);

        //blood
        JLabel blood =new JLabel("Blood Group");
        blood.setBounds(400,300,150,30);
        blood.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(blood);

        String items[]={"A+","A-","O+","O-","AB+","AB-"};
        bloodgroup=new JComboBox(items);
        bloodgroup.setBackground(new Color(177,252,197));
        bloodgroup.setBounds(600,300,150,30);
        add(bloodgroup);
        //gender
        JLabel gender =new JLabel("Gender");
        gender.setBounds(50,350,150,30);
        gender.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(gender);
        String items2[]={"Male","Female","Other"};
        genderbox=new JComboBox(items2);
        genderbox.setBackground(new Color(177,252,197));
        genderbox.setBounds(200,350,150,30);
        add(genderbox);
        //nid
        JLabel nid =new JLabel("Citizen ID");
        nid.setBounds(50,400,150,30);
        nid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(nid);

        tnidnumber=new JTextField();
        tnidnumber.setBounds(600,350,150,30);
        tnidnumber.setBackground(new Color(177,252,197));
        add(tnidnumber);
        //id
        JLabel citzenID =new JLabel("NID Number");
        citzenID.setBounds(400,350,150,30);
        citzenID.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(citzenID);

        tcitizeid= new JLabel(""+number);
        tcitizeid.setBounds(200,400,150,30);
        tcitizeid.setFont(new Font("SAN SARIF",Font.BOLD,20));
        tcitizeid.setForeground(Color.RED);
        add(tcitizeid);
        //button
        //add
        add=new JButton("ADD");
        add.setBounds(450,550,150,40);
        setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        //back
        back=new JButton("BACK");
        back.setBounds(250,550,150,40);
        setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);










        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String mname=tmname.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String blood=(String) bloodgroup.getSelectedItem();
            String gender=(String) genderbox.getSelectedItem();
            String nid=tnidnumber.getText();
            String citizenid=tcitizeid.getText();
            String postcode=tpostcode.getText();

            try {
                conn c=new conn();
                String query ="insert into citizen values('"+name+"','"+fname+"','"+dob+"','"+mname+"','"+address+"','"+phone+"','"+blood+"','"+gender+"','"+nid+"','"+citizenid+"','"+postcode+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Succesfully");
                setVisible(false);
                new Main_class();
            }
            catch (Exception E){
                E.printStackTrace();
            }

        }
        else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddIdenty();


    }
}
