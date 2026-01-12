package identy.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveCitizen extends JFrame implements ActionListener {

    Choice choiceCitizenID;
    JButton delete, back;

    JLabel textName, textPhone, textNid;

    public RemoveCitizen() {

        getContentPane().setBackground(new Color(210, 230, 255));



        JLabel label = new JLabel("Citizen ID");
        label.setBounds(50,50,120,30);
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        add(label);

        choiceCitizenID = new Choice();
        choiceCitizenID.setBounds(200,50,150,30);
        add(choiceCitizenID);

        // Load Citizen IDs
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select citizenid from citizen");
            while (rs.next()) {
                choiceCitizenID.add(rs.getString("citizenid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelName);

        textName = new JLabel();
        textName.setBounds(200,100,200,30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelPhone);

        textPhone = new JLabel();
        textPhone.setBounds(200,150,200,30);
        add(textPhone);

        JLabel labelNid = new JLabel("NID Number");
        labelNid.setBounds(50,200,120,30);
        labelNid.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelNid);

        textNid = new JLabel();
        textNid.setBounds(200,200,200,30);
        add(textNid);

        // Load first selected citizen
        loadCitizenDetails();

        // Change listener
        choiceCitizenID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                loadCitizenDetails();
            }
        });

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/delete.png")
        );
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(600,80,200,200);
        add(img);



        setSize(900,450);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);

        delete = new JButton("DELETE");
        delete.setBounds(80,300,120,35);
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(230,300,120,35);
        back.addActionListener(this);
        add(back);

        // 1️⃣ Background Image
        ImageIcon bgIcon = new ImageIcon(
                ClassLoader.getSystemResource("icons/rback.png")
        );
        Image bgImg = bgIcon.getImage().getScaledInstance(900,450,Image.SCALE_DEFAULT);
        bgIcon = new ImageIcon(bgImg);
        JLabel background = new JLabel(bgIcon);
        background.setBounds(0,0,900,450);
        add(background);



        setSize(900,450);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);

    }

    // Load Citizen Data
    private void loadCitizenDetails() {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(
                    "select name, phone, nid from citizen where citizenid = '"
                            + choiceCitizenID.getSelectedItem() + "'"
            );
            while (rs.next()) {
                textName.setText(rs.getString("name"));
                textPhone.setText(rs.getString("phone"));
                textNid.setText(rs.getString("nid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                conn c = new conn();
                String query =
                        "delete from citizen where citizenid = '"
                                + choiceCitizenID.getSelectedItem() + "'";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Citizen Deleted Successfully");
                setVisible(false);
                new Main_class();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveCitizen();
    }
}