package pract9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Employee {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private String location;
    private String phoneNumber;
    private double baseSalary;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Employee(String name, String surname, LocalDate dateOfBirth, String location, String phoneNumber, double baseSalary) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", dateOfBirth = " + dtf.format(dateOfBirth) +
                ", location = '" + location + '\'' +
                ", phoneNumber = '" + phoneNumber + '\'' +
                ", baseSalary = " + baseSalary +
                '}';
    }
}
