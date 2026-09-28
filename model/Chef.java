package model;

public class Chef extends Employee {

    private String specialization;

    public Chef() {

        super();

        this.specialization = "General";
    }

    public Chef(
            int id,
            String name,
            String phone,
            double salary,
            String specialization) {

        super(
                id,
                name,
                phone,
                salary,
                "Chef"
        );

        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(
            String specialization) {

        this.specialization = specialization;
    }

    @Override
    public void displayRole() {

        super.displayRole();

        System.out.println(
                "Specialization: " + specialization
        );
    }

    @Override
    public String toString() {

        return super.toString()
                + " | Specialization: "
                + specialization;
    }
}