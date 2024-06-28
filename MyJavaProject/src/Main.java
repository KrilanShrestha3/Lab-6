import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static EmployeeCRUD employeeCRUD = new EmployeeCRUD();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee CRUD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel salaryLabel = new JLabel("Salary:");
        JTextField salaryField = new JTextField();
        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentField = new JTextField();
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();

        JButton insertButton = new JButton("Insert");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton displayButton = new JButton("Display");

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                String department = departmentField.getText();
                employeeCRUD.insertEmployee(name, salary, department);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                String department = departmentField.getText();
                employeeCRUD.updateEmployee(id, name, salary, department);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                employeeCRUD.deleteEmployee(id);
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeCRUD.displayEmployees();
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(departmentLabel);
        panel.add(departmentField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(insertButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(displayButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
