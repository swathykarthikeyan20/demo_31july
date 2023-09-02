package com.firstname;

class Employee {
    String name;
    String ssn;
    String dept;
    int salary;

    public Employee(String name, String ssn, String dept, int salary) {
        this.name = name;
        this.ssn = ssn;
        this.dept = dept;
        this.salary = salary;
    }
}

class EmployeeImplementation {
    public Employee getEmployeeInfo(String str) {
        String[] parts = str.split("@|-|#");
        String name = parts[0];
        String ssn = parts[1];
        String dept = parts[2];
        int salary = Integer.parseInt(parts[3]);
        return new Employee(name, ssn, dept, salary);
    }

    public String getEmployeeDept(Employee e) {
        int lastThreeDigits = Integer.parseInt(e.ssn.substring(e.ssn.length() - 3));
        if (lastThreeDigits >= 1 && lastThreeDigits <= 60) {
            return "L1";
        } else if (lastThreeDigits >= 61 && lastThreeDigits <= 120) {
            return "L2";
        } else if (lastThreeDigits >= 121 && lastThreeDigits <= 180) {
            return "L3";
        } else {
            return "L4";
        }
    }
}

public class EmployeeInformation {
    public static void main(String[] args) {
        String inputString = "Rakesh RaJ@1PC16CS046-SDE#8";

        EmployeeImplementation empImpl = new EmployeeImplementation();
        Employee employee = empImpl.getEmployeeInfo(inputString);

        System.out.println("Employee Name: " + employee.name);
        System.out.println("Employee SSN: " + employee.ssn);
        System.out.println("Employee Dept: " + employee.dept);
        System.out.println("Employee Salary: " + employee.salary);

        String employeeDept = empImpl.getEmployeeDept(employee);
        System.out.println("Employee Dept Level: " + employeeDept);
    }
}