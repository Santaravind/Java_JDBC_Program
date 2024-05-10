import java.sql.*;
public class Updatedata {
     public static void main(String[] args) {
          String url="jdbc:mysql://Localhost:3306/sant";
          String username="root";
          String password="root";
          String query="UPDATE  employees\n"+
          " SET job_title='Full Stack Developer' , salary=84000.00\n"+
           " WHERE id=5;";

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
                    System.out.println("Updation successful"+rowaffected+"row(s) affected");
               }
               else{
                    System.out.println("Updation is failed !!");
               }
               
               stmt.close();
               con.close();

          } catch (SQLException e) {
               
               System.out.println(e.getMessage());
          }

     }
}
