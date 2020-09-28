package pract7;

public class Manager implements EmployeePosition{
    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary+0.05*(Math.random()*(145000-115000)+115000);
    }
}
