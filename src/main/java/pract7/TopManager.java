package pract7;

public class TopManager implements EmployeePosition{
    double income;

    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (income>10000000)
            return baseSalary+1.5*baseSalary;
        else
            return baseSalary;
    }
}
