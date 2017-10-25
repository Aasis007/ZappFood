package zappfood;


import java.sql.*;
import javax.swing.*;

public class JavaConnect {
    Connection conn=null;
    public static Connection connector1(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
               //Connection con = DriverManager.getConnection("Jdbc:mysql://27.34.78.82:3306//roshanp_b", "posakya","edyhupyry");
//            JOptionPane.showMessageDialog(null, "Connection Established");
Connection con = DriverManager.getConnection("Jdbc:mysql://10.42.0.1:3306/roshanp_appy", "rohan","puja123");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
            
        }
    }
    
/*
  Connection c=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Roshan Posakya\\Documents\\NetBeansProjects\\Registration\\Registration.sqlite");
            JOptionPane.showMessageDialog(null, "Connection Established");
            return c;
*/
