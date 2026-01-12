package identy.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update extends JFrame implements ActionListener {

    JTextField tfname, tmname, taddress, tphone, tnidnumber, tpostcode;
    JLabel tname, tdob, tcitizenid;
    JComboBox bloodgroup, genderbox;

    JButton update, back;
    String citizenId;

    Update(String citizenId) {

        this.citizenId = citizenId;
        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Update Citizen Details");
        heading.setBounds(300, 30, 500, 40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 120, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(name);

        tname = new JLabel();
        tname.setBounds(200, 120, 200, 30);
        add(tname);

        // Father
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(50, 170, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(200, 170, 200, 30);
        add(tfname);

        // Mother
        JLabel mname = new JLabel("Mother Name");
        mname.setBounds(50, 220, 150, 30);
        mname.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(mname);

        tmname = new JTextField();
        tmname.setBounds(200, 220, 200, 30);
        add(tmname);

        // DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 270, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 270, 200, 30);
        add(tdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(450, 120, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(600, 120, 200, 30);
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(450, 170, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 170, 200, 30);
        add(tphone);

        // Postcode
        JLabel post = new JLabel("Post Code");
        post.setBounds(450, 220, 150, 30);
        post.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(post);

        tpostcode = new JTextField();
        tpostcode.setBounds(600, 220, 200, 30);
        add(tpostcode);

        // Blood
        JLabel blood = new JLabel("Blood Group");
        blood.setBounds(450, 270, 150, 30);
        blood.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(blood);

        String[] bloodItems = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        bloodgroup = new JComboBox<>(bloodItems);
        bloodgroup.setBounds(600, 270, 200, 30);
        add(bloodgroup);

        // Gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 320, 150, 30);
        gender.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(gender);

        String[] genderItems = {"Male","Female","Other"};
        genderbox = new JComboBox<>(genderItems);
        genderbox.setBounds(200, 320, 200, 30);
        add(genderbox);

        // NID
        JLabel nid = new JLabel("NID Number");
        nid.setBounds(450, 320, 150, 30);
        nid.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(nid);

        tnidnumber = new JTextField();
        tnidnumber.setBounds(600, 320, 200, 30);
        add(tnidnumber);

        // Citizen ID
        JLabel cid = new JLabel("Citizen ID");
        cid.setBounds(50, 370, 150, 30);
        cid.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        add(cid);

        tcitizenid = new JLabel();
        tcitizenid.setBounds(200, 370, 200, 30);
        tcitizenid.setForeground(Color.RED);
        add(tcitizenid);

        // DB Load
        try {
            conn c = new conn();
            String query = "select * from citizen where citizenid = '"+citizenId+"'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tmname.setText(rs.getString("mname"));
                tdob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                tpostcode.setText(rs.getString("postcode"));
                bloodgroup.setSelectedItem(rs.getString("blood"));
                genderbox.setSelectedItem(rs.getString("gender"));
                tnidnumber.setText(rs.getString("nid"));
                tcitizenid.setText(rs.getString("citizenid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("UPDATE");
        update.setBounds(450, 550, 150, 40);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {

            try {
                conn c = new conn();
                String query =
                        "update citizen set " +
                                "fname='"+tfname.getText()+"', " +
                                "mname='"+tmname.getText()+"', " +
                                "address='"+taddress.getText()+"', " +
                                "phone='"+tphone.getText()+"', " +
                                "postcode='"+tpostcode.getText()+"', " +
                                "blood='"+bloodgroup.getSelectedItem()+"', " +
                                "gender='"+genderbox.getSelectedItem()+"', " +
                                "nid='"+tnidnumber.getText()+"' " +
                                "where citizenid='"+citizenId+"'";

                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Citizen Updated Successfully");
                setVisible(false);
                new View();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new View();
        }
    }
}