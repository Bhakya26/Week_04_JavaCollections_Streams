package java8;
import java.util.*;
import java.util.stream.*;

public class EmployeeDataProcessing {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice",       "Engineering", 90000),
            new Employee(2, "Bob",         "Engineering", 85000),
            new Employee(3, "Charlie",     "HR",          70000),
            new Employee(4, "David",       "Engineering", 95000),
            new Employee(5, "Eve",         "Marketing",   82000),
            new Employee(6, "Frank",       "Engineering", 78000)
        );

        Map<String, Double> avgByDept = process(employees);

        avgByDept.forEach((dept, avg) ->
            System.out.printf("%s → average salary = %.2f%n", dept, avg)
        );
    }

    
    public static Map<String, Double> process(List<Employee> list) {
        return list.stream()
            .filter(e -> "Engineering".equals(e.getDepartment()) && e.getSalary() > 80_000)
            .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
    }

    static class Employee {
        private final int id;
        private final String name;
        private final String department;
        private final int salary;
        public Employee(int id, String name, String department, int salary) {
            this.id = id; this.name = name;
            this.department = department; this.salary = salary;
        }
        public int    getId()         { return id; }
        public String getName()       { return name; }
        public String getDepartment() { return department; }
        public int    getSalary()     { return salary; }
    }
}

