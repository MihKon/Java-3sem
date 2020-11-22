package pract7;

public class Manager implements EmployeePosition{
    double income;

    public double getIncome() {
        this.income = Math.random()*(145000-115000)+115000;
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary+0.05*this.income;
    }
}
