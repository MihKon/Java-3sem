package pract9;

import java.util.ArrayList;

public class EmployeesSelector implements EmployeesHandler {
    private int year;
    private int count = 0;

    public EmployeesSelector(int year) {
        this.year = year;
    }

    @Override
    public void HandleEmployees(Employee employee) {
        if (employee.getDateOfBirth().getYear() < year) {
            count++;
            System.out.println(employee);
        }
    }
}
