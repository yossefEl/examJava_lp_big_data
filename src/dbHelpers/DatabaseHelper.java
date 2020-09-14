package dbHelpers;
import java.sql.*;
public class DatabaseHelper{
    private Statement statement;
    Connection con;
    public DatabaseHelper(){
        connectMysql();
    }
    public Connection getCon() {
        return con;
    }

    public void connectMysql(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java_lp_bd","root","");
            //here sonoo is database name, root is username and password

            if (con!=null){
                System.out.println("connection passed !!");
            }
            ResultSet rs=getStatement().executeQuery("SELECT * FROM employes");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        }catch(Exception e){ System.out.println(e);
        }




    }

    public Statement getStatement() throws SQLException {
        statement=con.createStatement();
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    public void closeConnection() throws SQLException {
        con.close();
    }
}