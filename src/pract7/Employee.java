package pract7;

import java.util.Comparator;

public class Employee {
    String surname, name, job;
    double constSalary;
    EmployeePosition employeePosition;

    public Employee(String surname, String name, String job, EmployeePosition employeePosition) {
        if (job == "operator") {
            this.constSalary = 20000;
            this.name = name;
            this.surname = surname;
        }
        if (job == "manager") {
            this.constSalary = 60000;
            this.name = name;
            this.surname = surname;
        }
        if (job == "topManager") {
            this.constSalary = 85000;
            this.name = name;
            this.surname = surname;
        }
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

    public void setJob(String job) {
        this.job = job;
    }

    public double getConstSalary() {
        return constSalary;
    }

    public void setConstSalary(double constSalary) {
        this.constSalary = constSalary;
    }

    public void setManager(String surname, String name, String job, double constSalary) {

    }

    public void setTopManager(String surname, String name, String job, double constSalary) {

    }

    public void setOperator(String surname, String name, String job, double constSalary) {

    }
}
