import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }
}

public class EmployeeManagerTextFile {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "Engineering", 70000));
        employees.add(new Employee(3, "Charlie", "Marketing", 60000));

        saveEmployeesToTextFile(employees);
        readEmployeesFromTextFile();
    }

    public static void saveEmployeesToTextFile(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : employees) {
                writer.write(emp.toString());
                writer.newLine();
            }
            System.out.println("Employees saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public static void readEmployeesFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nEmployees from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading employees: " + e.getMessage());
        }
    }
}
