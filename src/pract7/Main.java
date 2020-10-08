package pract7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Company company = new Company();
        Manager manager = new Manager();
        TopManager topManager = new TopManager();
        Operator operator = new Operator();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int i=0;
        for (i=0; i<180; i++){
            //String name = scan.next();
            //String surname = scan.next();
            String name = "Tom";
            String surname = "Riddle";
            Employee e = new Employee(name, surname, operator);
            employees.add(e);
        }
        for (i=0; i<80; i++){
            //String name = scan.next();
            //String surname = scan.next();
            String name = "Albus";
            String surname = "Dambledore";
            Employee e = new Employee(name, surname, manager);
            employees.add(e);
        }
        for (i=0; i<10; i++){
            //String name = scan.next();
            //String surname = scan.next();
            String name = "Severus";
            String surname = "Snape";
            Employee e = new Employee(name, surname, topManager);
            employees.add(e);
        }
        company.hireAll(employees);
        company.printList(company.getTopSalaryStaff(15));
        System.out.println();
        company.printList(company.getLowestSalaryStaff(30));
        int j = employees.size();
        while (i<employees.size()/2 && j>0){
            int k = (int) Math.random()*j;
            company.fire(employees.get(k));
        }
        System.out.println();
        company.printList(company.getTopSalaryStaff(10));
        System.out.println();
        company.printList(company.getLowestSalaryStaff(30));
    }
}
