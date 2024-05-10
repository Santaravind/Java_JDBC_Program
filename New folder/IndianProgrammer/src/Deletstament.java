import java.sql.*;
public class Deletstament {
     public static void main(String[] args) throws SQLException{
          String url="jdbc:mysql://Localhost:3306/sant";
          String username="root";
          String password="root";
          String query="delete from employees where  id=5;";

          try {
               Class.forName("com.mysql.jdbc.Diver");
               System.out.println("Driver loaded successfully"); 
               
           
          
          } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
          }
          try {
               Connection con=DriverManager.getConnection(url, username, password);
               System.out.println("Connection Established Successfully !!");

               Statement stmt=con.createStatement();

               int rowaffected=stmt.executeUpdate(query);

               if(rowaffected>0){
                    System.out.println("Deletion successful"+rowaffected+"row(s) affected");
               }
               else{
                    System.out.println("Deletion is failed !!");
               }
               
               stmt.close();
               con.close();

          } catch (SQLException e) {
               
               System.out.println(e.getMessage());
          }
     }
}
