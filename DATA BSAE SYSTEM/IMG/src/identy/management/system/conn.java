package identy.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class conn {
    public Statement statement;
    public Connection connection;


    public conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ims","root","");
            statement =connection.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
