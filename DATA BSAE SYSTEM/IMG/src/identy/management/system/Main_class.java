package identy.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/home1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);
        JLabel heading =new JLabel("National Identity Management ");
        heading.setBounds(340,155,500,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add (heading);

        JButton add=new JButton("Add Information");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.CYAN);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddIdenty();
                setVisible(false);

            }
        });
        img.add(add);

        JButton view=new JButton("View");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.BLACK);
        view.setBackground(Color.CYAN);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View();
                setVisible(false);

            }
        });
        img.add(view);

        JButton rem=new JButton("Remove");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.BLACK);
        rem.setBackground(Color.blue);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveCitizen();

            }
        });
        img.add(rem);


        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Main_class();

    }
}
