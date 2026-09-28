package model;

public class Employee extends Person {

    private double salary;
    private String designation;

    public Employee() {

        super();

        this.salary = 0.0;
        this.designation = "Staff";
    }

    public Employee(
            int id,
            String name,
            String phone,
            double salary,
            String designation) {

        super(id, name, phone);

        this.salary = salary;
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(
            String designation) {

        this.designation = designation;
    }

    @Override
    public void displayRole() {

        System.out.println(
                "Role: Employee - " + designation
        );
    }

    public double calculateAnnualSalary() {

        return salary * 12;
    }

    @Override
    public String toString() {

        return super.toString()
                + String.format(
                " | Salary: Rs. %.2f | Designation: %s",
                salary,
                designation
        );
    }
}