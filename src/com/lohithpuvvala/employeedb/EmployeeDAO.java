package com.lohithpuvvala.employeedb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final Connection connection;

    public EmployeeDAO() {
        connection = DBConnection.getConnection();
    }

    public void addEmployee(Employee employee) {
        if (employee.getName() == null || employee.getRole() == null || employee.getName().isEmpty() || employee.getRole().isEmpty()) {
            System.out.println("Invalid employee data. Name and role must not be empty.");
            return;
        }
        try {
            String sql = "INSERT INTO employees (name, role) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getRole());
            statement.executeUpdate();
            System.out.println("Employee added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                employees.add(new Employee(id, name, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID provided.");
            return null;
        }
        try {
            String sql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("role"));
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        if (employee.getId() <= 0 || employee.getName() == null || employee.getRole() == null
                || employee.getName().isEmpty() || employee.getRole().isEmpty()) {
            System.out.println("Invalid employee data. Please check ID, name, and role.");
            return;
        }
        try {
            String sql = "UPDATE employees SET name = ?, role = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getRole());
            statement.setInt(3, employee.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully");
            } else {
                System.out.println("No employee found with ID " + employee.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID. Must be greater than 0.");
            return;
        }
        try {
            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("No employee found with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}