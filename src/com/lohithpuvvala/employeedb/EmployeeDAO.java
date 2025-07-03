package com.lohithpuvvala.employeedb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(){
        connection = DBConnection.getConnection();
    }

    public void addEmployee(Employee employee){
        try{
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

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        try{
            String sql = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                employees.add(new Employee(id, name, role));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    public void updateEmployee(Employee employee){
        try{
            String sql = "UPDATE employees SET name = ?, role = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getRole());
            statement.setInt(3, employee.getId());
            statement.executeUpdate();
            System.out.println("Employee updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id){
        try{
            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Employee deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
