package com.lohithpuvvala.employeedb;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("1. Add Employee");
            System.out.println("2. List All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            int choice = in.nextInt();
            String name, role;
            switch(choice){
                case 1:
                    in.nextLine();
                    System.out.println("Enter Employee Name: ");
                    name = in.nextLine();
                    System.out.println("Enter Employee Role: ");
                    role = in.nextLine();
                    employeeDAO.addEmployee(new Employee(name, role));
                    break;
                case 2:
                    in.nextLine();
                    employeeDAO.getAllEmployees().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter Employee ID to Search: ");
                    int idToSearch = in.nextInt();
                    in.nextLine();
                    Employee employee = employeeDAO.getEmployeeById(idToSearch);
                    if(employee != null){
                        System.out.println(employee);
                    }else{
                        System.out.println("Employee with ID " + idToSearch + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee ID to Update: ");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.print("Enter Employee Name: ");
                    name = in.nextLine();
                    System.out.print("Enter Employee Role: ");
                    role = in.nextLine();
                    employeeDAO.updateEmployee(new Employee(id, name, role));
                    break;
                case 5:
                    System.out.println("Enter Employee ID to Delete: ");
                    int idToDelete = in.nextInt();
                    in.nextLine();
                    employeeDAO.deleteEmployee(idToDelete);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    in.nextLine();
                    System.out.println("Invalid Choice");

            }

            System.out.println("Do you want to continue? (y/n)");
            if(in.next().equalsIgnoreCase("n")){
                System.out.println("Thank You! Exiting...");
                break;
            }
        }
    }
}
