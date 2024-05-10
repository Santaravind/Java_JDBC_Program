import java.sql.*;

public class Databases {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sant";
        String username = "root";
        String password = "root";
        String query = "SELECT * FROM employees;";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully.");

            // Create statement
            Statement stmt = con.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

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

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
