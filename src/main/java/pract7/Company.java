package pract7;

import java.util.ArrayList;
import java.util.List;

public class Company {
    ArrayList<Employee> list = new ArrayList<Employee>();
    double income1 = 0;

    public void hire(Employee employee){
        list.add(employee);
    }
    public void hireAll(ArrayList <Employee> hireList){
        list.addAll(hireList);
        for (Employee e: list) {
            if (e.employeePosition instanceof Manager)
                income1 += ((Manager) e.employeePosition).getIncome();
        }
        for (Employee e: list) {
            if (e.employeePosition instanceof TopManager)
                ((TopManager) e.employeePosition).setIncome(income1);
        }
    }
    public void fire(Employee employee){
        list.remove(employee);
    }
    public double getIncome(){
        for (Employee e: list){
            if (e.employeePosition instanceof Manager)
                income1+=((Manager) e.employeePosition).getIncome();
        }
        return income1;
    }
    public List<Employee> getTopSalaryStaff(int count){
        ArrayList<Employee> topList = list;
        for (int i=0; i<topList.size()-1; i++){
            for (int j=i+1; j<topList.size(); j++){
                if (topList.get(i).getEmployeePosition().calcSalary(topList.get(i).getConstSalary())<topList.get(j).getEmployeePosition().calcSalary(topList.get(j).getConstSalary())){
                    Employee e = topList.get(j);
                    topList.set(j, topList.get(i));
                    topList.set(i, e);
                }
            }
        }
        if (count<0)
            System.out.println("Error");
        if (count>list.size())
            return topList.subList(0, list.size());
        else
            return topList.subList(0, count);
    }
    public List<Employee> getLowestSalaryStaff(int count){
        ArrayList<Employee> lowList = list;
        for (int i=0; i<lowList.size()-1; i++){
            for (int j=i+1; j<lowList.size(); j++){
                if (lowList.get(i).getEmployeePosition().calcSalary(lowList.get(i).getConstSalary())>lowList.get(j).getEmployeePosition().calcSalary(lowList.get(j).getConstSalary())){
                    Employee e = lowList.get(j);
                    lowList.set(j, lowList.get(i));
                    lowList.set(i, e);
                }
            }
        }
        if (count<0)
            System.out.println("Error");
        if (count>list.size())
            return lowList.subList(0, list.size());
        else
            return lowList.subList(0, count);
    }

    public double getIncome1() {
        return income1;
    }
    public void printList(List<Employee> employeeArrayList){
        for (Employee e: employeeArrayList){
            System.out.println(e.getName()+" "+e.getSurname()+" "+e.getEmployeePosition().getJobTitle()+" "+e.getEmployeePosition().calcSalary(e.getConstSalary())+" руб.");
        }
    }
}
