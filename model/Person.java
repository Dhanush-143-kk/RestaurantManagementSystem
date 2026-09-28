package model;

public abstract class Person {

    // Private fields demonstrate encapsulation
    private int id;
    private String name;
    private String phone;

    // Static variable - shared by all Person objects
    private static int personCount = 0;

    // Final constant
    public static final String COUNTRY_CODE = "+91";

    // Default constructor
    public Person() {
        this(0, "Unknown", "Not Provided");
    }

    // Parameterized constructor
    public Person(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;

        personCount++;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Abstract method
    public abstract void displayRole();

    // Final method
    // Final because every person must use the same greeting format.
    public final void greet() {
        System.out.println("Welcome to our restaurant, " + name + "!");
    }

    // Method overloading - version 1
    public void updatePhone(String phone) {
        this.phone = phone;
    }

    // Method overloading - version 2
    public void updatePhone(String countryCode, String phone) {
        this.phone = countryCode + " " + phone;
    }

    // Static method
    public static int getPersonCount() {
        return personCount;
    }

    // Overriding Object's toString()
    @Override
    public String toString() {
        return String.format(
                "ID: %d | Name: %s | Phone: %s",
                id, name, phone
        );
    }
}