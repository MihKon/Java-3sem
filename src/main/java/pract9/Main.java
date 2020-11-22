package pract9;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int i = 0;

        for (i = 0; i < 53; i++) {
            company.hire(new Employee(
                    "Thor",
                    "Oddinson",
                    LocalDate.of(random.nextInt(42) + 1960, random.nextInt(11) + 1, random.nextInt(28) + 1),
                    "MOSCOW, VO RTU MIREA",
                    "8-925-***-**-**",
                    random.nextInt(80_000) + 20_000));
        }

        System.out.println("sort by Year");
        company.EmployeesSort(new EmployeesSelector(1976));

        System.out.println("sort by Salary");
        company.EmployeesSort(new EmployeesHandler() {
            private int count = 0;

            @Override
            public void HandleEmployees(Employee employee) {
                if (employee.getBaseSalary() > 65_000) {
                    System.out.println(employee);
                    count++;
                }
            }
        });

        System.out.println("sort by Month");
        company.EmployeesSecondSort(
                e -> e.getDateOfBirth().getMonthValue() == 2 || e.getDateOfBirth().getMonthValue() == 10,
                e -> System.out.println(e));
    }
}
