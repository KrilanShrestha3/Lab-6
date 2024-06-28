import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
private DBConnection() {
// Private constructor to prevent instantiation
}    private static final String URL = "jdbc:postgresql://icy-pup-5170.7s5.aws-ap-south-1.cockroachlabs.cloud:26257/Company?sslmode=verify-full";
    private static final String USER = "krilan"; 

    private static final String USER = "krilan";
    private static final String PASSWORD = "NEW_SECURE_PASSWORD";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }







    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, "NEW_SECURE_PASSWORD");
    }
}
