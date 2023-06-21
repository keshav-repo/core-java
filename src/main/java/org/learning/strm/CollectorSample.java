package org.learning.strm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorSample {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeCollection.employeeList;

        // group by property , Get the employee list with their date of joining
        Map<Integer, List<Employee>> employeeWithYearofjoining = employees.stream()
                .collect(Collectors.groupingBy(Employee::getYearOfJoining));
        System.out.println(employeeWithYearofjoining);

        // group by property, Get the employee name list with their year of joining
        Map<Integer, List<String>> namesWithYearOfJoining = employees.stream()
                .collect(Collectors.groupingBy(Employee::getYearOfJoining, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(namesWithYearOfJoining);

        // Grouping by a Calculation Result: Seperate even and odd number in a number list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<String, List<Integer>> numberGroup = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD"));
        System.out.println(numberGroup);

        // Grouping and Counting: get number of employee joining per years
        Map<Integer, Long> employeeYearWise = employees.stream()
                .collect(Collectors.groupingBy(e -> e.yearOfJoining, Collectors.counting()));
        System.out.println(employeeYearWise);

        // Grouping and Counting: get Average salary for each department
        Map<String, Double> avgSalaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(e -> e.salary)));
        // or
        Map<String, Double> avgSalaryPerDept2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryPerDept);

        // Grouping and Summing, Get the salary sum given per department
        Map<String, Double> totalSalryPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println(totalSalryPerDept);

        // Collectors.mapping, return the list having the length of each word
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Emma", "Mike", "Sarah");
        List<Integer> nameLengths = names.stream()
                .collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println(nameLengths);

    }
}
