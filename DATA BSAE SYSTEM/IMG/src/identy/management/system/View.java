package identy.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View extends JFrame implements ActionListener {

    JTable table;
    Choice choiceCID;
    JButton  searchbtn,print,update,back;
    View() {
        getContentPane().setBackground(new Color(193, 214, 77));
        //scarch
        JLabel Search = new JLabel("Scarch by citizen id");
        Search.setBounds(20, 20, 150, 20);
        add(Search);
        choiceCID = new Choice();
        choiceCID.setBounds(180, 20, 150, 20);
        add(choiceCID);
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from citizen");
            while (resultSet.next()) {
                choiceCID.add(resultSet.getString("citizenid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from citizen");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);
        //button
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }
       public static void main (String[]args){
            new View();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select * from citizen where citizenid = '"+choiceCID.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update){
            setVisible(false);
            new Update(choiceCID.getSelectedItem());
        } else {
            setVisible(false);
            new Main_class();
        }
    }

}
    
