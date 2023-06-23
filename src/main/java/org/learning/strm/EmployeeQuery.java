package org.learning.strm;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeQuery {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeCollection.employeeList;

        // How many male and female employees are there in the organization
        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderCount);

        //  Print the name of all departments in the organization?
        List<String> departmentList = employees.stream().map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(departmentList);

        // What is the average age of male and female employees?
        Map<String, Double> avgAgeGenderWise = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        avgAgeGenderWise.forEach((gender, avgAge) -> {
            System.out.println("gender: " + gender + " " + decimalFormat.format(avgAge));
        });

        //  Get the details of highest paid employee in the organization?
        Employee maxSalaryEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("No employee found"));
        System.out.println(maxSalaryEmployee);

        //  Get the names of all employees who have joined after 2015?
        List<Employee> employeeJoinedAfter1015 = employees.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .collect(Collectors.toList());
        System.out.println(employeeJoinedAfter1015);

        // Count the number of employees in each department?
        Map<String, Long> employeeCountPerDepartment =  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(employeeCountPerDepartment);

        // Get the details of youngest male employee in the each department ?
        Map<String, Employee> youngestMaleEmployeesByDepartment = employees.stream()
                .filter(employee -> employee.getGender() == "Male")
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getAge))))
                .entrySet().stream()
                .filter(entry -> entry.getValue().isPresent())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));

        System.out.println(youngestMaleEmployeesByDepartment);

        //

    }
}
