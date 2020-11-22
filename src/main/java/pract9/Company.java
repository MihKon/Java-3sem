package pract9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void hire(Employee e) {
        employees.add(e);
    }

    public void fire(Employee e) {
        employees.remove(e);
    }

    public void hireAll(ArrayList<Employee> hireList) {
        employees.addAll(hireList);
    }

    public void EmployeesSort(EmployeesHandler handler) {
        for (Employee e : employees) {
            handler.HandleEmployees(e);
        }
    }

    public void EmployeesSecondSort(EmployeesSignal signal, EmployeesHandler handler) {
        int count = 0;
        for (Employee e : employees) {
            if (signal.isThisEmployee(e)) {
                handler.HandleEmployees(e);
                count++;
            }
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
