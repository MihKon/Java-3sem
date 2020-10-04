package pract7;

import java.util.Comparator;

public class Employee {
    String surname, name, job;
    double constSalary;
    EmployeePosition employeePosition;

    public Employee(String name, String surname, EmployeePosition employeePosition) {
        if (employeePosition instanceof Operator) {
            this.constSalary = 20000;
        }
        if (employeePosition instanceof Manager) {
            this.constSalary = 60000;
        }
        if (employeePosition instanceof TopManager) {
            this.constSalary = 85000;
        }
        this.name = name;
        this.surname = surname;
        this.job = employeePosition.getJobTitle();
        this.employeePosition = employeePosition;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
        this.job = employeePosition.getJobTitle();
    }

    public double getConstSalary() {
        return constSalary;
    }

    public void setConstSalary(double constSalary) {
        this.constSalary = constSalary;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }
}
