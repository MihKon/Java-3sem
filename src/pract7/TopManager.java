package pract7;

public class TopManager implements EmployeePosition{
    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if ()
            return baseSalary+1.5*baseSalary;
        else
            return baseSalary;
    }
}
