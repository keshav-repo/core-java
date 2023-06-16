package org.learning.oop;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String department;

    public Employee() {
    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    // Constructors, getters, setters, and other methods omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }

    public static void main(String[] args) {
        Employee employee = new Employee(1,"name", "dept");

        Employee employee_copy = new Employee(1,"name", "dept");

        System.out.println(employee_copy.equals(employee_copy));
        System.out.println(employee.hashCode());
        System.out.println(employee_copy.hashCode());

    }
}
