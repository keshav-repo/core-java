package org.learning.strm;

import java.text.DecimalFormat;
import java.util.*;
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
        Map<String, Long> employeeCountPerDepartment = employees.stream()
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

        // Employee most working experience in the organization
        Employee employeeWithMostExp = employees.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .orElseThrow(() -> new RuntimeException("No employee found"));
        System.out.println(employeeWithMostExp);

        // How many male and female employees are there in the sales and marketing team
        Map<String, Long> genderCountInMarketingSales = employees.stream()
                .filter(employee -> employee.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderCountInMarketingSales);

        // List down the names of all employees in each department?
        Map<String, List<String>> employeesPerdepart = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(employeesPerdepart);

        // What is the average salary and total salary of the whole organization?
        var salaryAvg = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println(salaryAvg);

        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);

        // Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        List<Employee> employeesWithAgeLessThan25 = employees.stream()
                .filter(employee -> employee.getAge() <= 25)
                .collect(Collectors.toList());
        System.out.println(employeesWithAgeLessThan25);

        // Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
        System.out.println(oldestEmployee);

        // Increase the salary of each employee by 100
        employees = employees.stream()
                .map(employee -> new Employee(employee.id, employee.name, employee.age, employee.gender, employee.department, employee.yearOfJoining, employee.getSalary() + 100))
                .collect(Collectors.toList());


        // get a employee
       Optional<Employee> employeeSearch = employees.stream()
                .filter(employee -> employee.getId() == 111)
                .findFirst();




    }
}
