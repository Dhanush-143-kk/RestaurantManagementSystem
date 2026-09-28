package app;

import java.util.Scanner;

import model.Customer;
import model.Person;
import service.RestaurantService;

public class Main {

    private static int choice;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RestaurantService restaurant = new RestaurantService();

        // Add sample customers
        Customer customer1 = new Customer(
                1,
                "Arjun",
                "9988776655",
                120,
                "Gold"
        );

        Customer customer2 = new Customer(
                2,
                "Priya",
                "8877665544",
                50,
                "Regular"
        );

        restaurant.addCustomer(customer1);
        restaurant.addCustomer(customer2);

        // Demonstrate polymorphism
        restaurant.demonstratePolymorphism();

        // Demonstrate String methods
        demonstrateStringMethods();

        boolean running = true;

        while (running) {

            displayMainMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    restaurant.displayMenu();
                    break;

                case 2:
                    scanner.nextLine();

                    System.out.print("Enter food name to search: ");
                    String keyword = scanner.nextLine();

                    restaurant.searchMenu(keyword);
                    break;

                case 3:
                    addNewCustomer(scanner, restaurant);
                    break;

                case 4:
                    restaurant.placeOrder(scanner);
                    break;

                case 5:
                    restaurant.displayEmployees();
                    break;

                case 6:
                    displaySystemInformation();
                    break;

                case 0:

                    running = false;

                    System.out.println();
                    System.out.println(
                            "Thank you for using "
                            + "Restaurant Management System!"
                    );

                    break;

                default:

                    System.out.println();
                    System.out.println(
                            "Invalid choice. Please enter "
                            + "a number from 0 to 6."
                    );
            }
        }

        scanner.close();
    }

    public static void displayMainMenu() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       RESTAURANT MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        System.out.println("1. Display Menu");
        System.out.println("2. Search Menu");
        System.out.println("3. Add Customer");
        System.out.println("4. Place Order");
        System.out.println("5. Display Employees");
        System.out.println("6. Display System Information");
        System.out.println("0. Exit");

        System.out.println("==============================================");
    }

    public static void addNewCustomer(
            Scanner scanner,
            RestaurantService restaurant) {

        scanner.nextLine();

        System.out.println();
        System.out.println("============= ADD CUSTOMER =============");

        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Loyalty Points: ");
        int points = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Membership Type: ");
        String membership = scanner.nextLine();

        Customer customer = new Customer(
                id,
                name,
                phone,
                points,
                membership
        );

        restaurant.addCustomer(customer);
    }

    public static void demonstrateStringMethods() {

        System.out.println();
        System.out.println(
                "========= STRING METHODS DEMO ========="
        );

        String input = "   restaurant management   ";

        System.out.println(
                "Original String: [" + input + "]"
        );

        String trimmed = input.trim();

        System.out.println(
                "After trim(): [" + trimmed + "]"
        );

        String lowerCase = trimmed.toLowerCase();

        System.out.println(
                "After toLowerCase(): " + lowerCase
        );

        System.out.println(
                "Contains 'management': "
                        + lowerCase.contains("management")
        );

        String[] words = trimmed.split(" ");

        System.out.println(
                "Number of words using split(): "
                        + words.length
        );

        System.out.println(
                "equals(\"restaurant management\"): "
                        + lowerCase.equals(
                        "restaurant management"
                )
        );

        System.out.println(
                "String length: " + trimmed.length()
        );
    }

    public static void displaySystemInformation() {

        System.out.println();
        System.out.println(
                "========= SYSTEM INFORMATION ========="
        );

        System.out.println(
                "Total Person Objects Created: "
                        + Person.getPersonCount()
        );

        System.out.println(
                "Restaurant Country Code: "
                        + Person.COUNTRY_CODE
        );

        System.out.println(
                "Application: Restaurant Management System"
        );

        System.out.println(
                "Language: Java"
        );

        System.out.println(
                "Architecture: App - Service - Model"
        );
    }
}