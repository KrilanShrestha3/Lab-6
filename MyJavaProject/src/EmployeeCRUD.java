import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeCRUD {
    public void insertEmployee(String name, double salary, String department) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Employee (Ename, Salary, Department) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, salary);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, String name, double salary, String department) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Employee SET Ename = ?, Salary = ?, Department = ? WHERE Eid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, salary);
            pstmt.setString(3, department);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Employee WHERE Eid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayEmployees() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Employee";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Eid"));
                System.out.println("Name: " + rs.getString("Ename"));
                System.out.println("Salary: " + rs.getDouble("Salary"));
                System.out.println("Department: " + rs.getString("Department"));
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
