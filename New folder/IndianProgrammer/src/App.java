import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
//import java.lang.Exception;

public class App {
    public static void main(String[] args)  {
        //String url="jdbc:mysql://localhost:3306/mysql";
        String url="jdbc:mysql://Localhost:3306/sant";
        String username="root";
        String password="root";

        //for print the eployees table data in here;
        String querys="SELECT * FROM EMPLOYEES;";

        //For create a now row in data employees table;
        String query="INSERT INTO  employees(id ,name,job_title,salary)values(06,'Navin','React Developer',550000.00);";
        try{
        Class.forName("com.mysql.jdbc.Diver");
        System.out.println("Driver loaded successfully");
        }
        catch(ClassNotFoundException e){

            System.out.println(e.getMessage());

        } 
        try{
            //@SuppressWarnings("unused")
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("connection estavlished Successfully !!");

            Statement stmt=con.createStatement();
         
             // Execute query
            ResultSet rs = stmt.executeQuery(querys);

            // Process results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println("================================");
                System.out.println("Id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Job Title: " + job_title);
                System.out.println("Salary: " + salary);
            }

            //executeUpdate(query) update the database;
            int rowaffected=stmt.executeUpdate(query);

            if(rowaffected>0){
                System.out.println("row affected");
            }
            else{
                System.out.println("Row not affected");
            }

             stmt.close();
             rs.close();
             con.close();

        }catch(SQLException e){
                System.out.println(e.getMessage());
        } 
       
    }
}
