package org.learning.strm;

import java.util.Comparator;
import java.util.List;

public class EmployeeComparatorBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(),o2.getSalary());
    }

    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeCollection.employeeList;
        employeeList.sort(new EmployeeComparatorBySalary());
        employeeList.stream().forEach(employee -> {
            System.out.println(employee.getName()+" - "+employee.getSalary());
        });
    }
}
