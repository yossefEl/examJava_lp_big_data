package dbHelpers;
import java.sql.*;
public class DatabaseHelper{

    public void connectMysql(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java_lp_bd","root","");
//here sonoo is database name, root is username and password

            if (con!=null){
                System.out.println("connection passed !!");
            }
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM employes");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);
        }

    }
}