package service;

import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.MenuItem;
import model.Order;
import model.OrderStatus;
import model.Person;
import model.Chef;

public class RestaurantService {

    private MenuItem[] menu;
    private Customer[] customers;
    private Employee[] employees;

    private int menuCount;
    private int customerCount;
    private int employeeCount;

    public RestaurantService() {

        menu = new MenuItem[20];
        customers = new Customer[20];
        employees = new Employee[20];

        menuCount = 0;
        customerCount = 0;
        employeeCount = 0;

        loadSampleData();
    }

    private void loadSampleData() {

        addMenuItem(new MenuItem(
                1,
                "Paneer Butter Masala",
                220.00,
                true
        ));

        addMenuItem(new MenuItem(
                2,
                "Veg Biryani",
                180.00,
                true
        ));

        addMenuItem(new MenuItem(
                3,
                "Masala Dosa",
                100.00,
                true
        ));

        addMenuItem(new MenuItem(
                4,
                "Fresh Lime Soda",
                60.00,
                true
        ));

        addMenuItem(new MenuItem(
                5,
                "Chocolate Brownie",
                120.00,
                true
        ));

        addEmployee(new Chef(
                101,
                "Rahul",
                "9876543210",
                35000.00,
                "Indian Cuisine"
        ));
    }

    public void addMenuItem(MenuItem item) {

        if (item == null) {
            return;
        }

        if (menuCount >= menu.length) {

            System.out.println(
                    "Menu is full."
            );

            return;
        }

        menu[menuCount] = item;
        menuCount++;
    }

    public void addCustomer(Customer customer) {

        if (customer == null) {
            return;
        }

        if (customerCount >= customers.length) {

            System.out.println(
                    "Customer list is full."
            );

            return;
        }

        customers[customerCount] = customer;
        customerCount++;

        System.out.println(
                "Customer added successfully."
        );
    }

    public void addEmployee(Employee employee) {

        if (employee == null) {
            return;
        }

        if (employeeCount >= employees.length) {

            System.out.println(
                    "Employee list is full."
            );

            return;
        }

        employees[employeeCount] = employee;
        employeeCount++;
    }

    public void displayMenu() {

        System.out.println();
        System.out.println(
                "=============================================="
        );

        System.out.println(
                "              RESTAURANT MENU"
        );

        System.out.println(
                "=============================================="
        );

        System.out.printf(
                "%-5s %-25s %-12s %-15s%n",
                "ID",
                "ITEM",
                "PRICE",
                "STATUS"
        );

        System.out.println(
                "----------------------------------------------"
        );

        for (int i = 0; i < menuCount; i++) {

            System.out.printf(
                    "%-5d %-25s Rs. %-8.2f %-15s%n",
                    menu[i].getItemId(),
                    menu[i].getItemName(),
                    menu[i].getPrice(),
                    menu[i].isAvailable()
                            ? "Available"
                            : "Unavailable"
            );
        }
    }

    public MenuItem findMenuItem(int id) {

        for (int i = 0; i < menuCount; i++) {

            if (menu[i].getItemId() == id) {

                return menu[i];
            }
        }

        return null;
    }

    public Customer findCustomer(int id) {

        for (int i = 0; i < customerCount; i++) {

            if (customers[i].getId() == id) {

                return customers[i];
            }
        }

        return null;
    }

    public void searchMenu(String keyword) {

        if (keyword == null) {
            System.out.println(
                    "Search keyword cannot be empty."
            );
            return;
        }

        keyword = keyword.trim().toLowerCase();

        if (keyword.isEmpty()) {

            System.out.println(
                    "Search keyword cannot be empty."
            );

            return;
        }

        boolean found = false;

        System.out.println();
        System.out.println(
                "Search results for: " + keyword
        );

        System.out.println(
                "----------------------------------------------"
        );

        for (int i = 0; i < menuCount; i++) {

            String itemName =
                    menu[i].getItemName().toLowerCase();

            if (itemName.contains(keyword)) {

                System.out.println(menu[i]);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No matching food item found."
            );
        }
    }

    public void displayEmployees() {

        System.out.println();

        System.out.println(
                "=============================================="
        );

        System.out.println(
                "                 EMPLOYEES"
        );

        System.out.println(
                "=============================================="
        );

        for (int i = 0; i < employeeCount; i++) {

            Person person = employees[i];

            person.displayRole();

            System.out.println(person);

            System.out.println();
        }
    }

    public void placeOrder(Scanner scanner) {

        System.out.println();

        System.out.println(
                "=============================================="
        );

        System.out.println(
                "                 PLACE ORDER"
        );

        System.out.println(
                "=============================================="
        );

        System.out.print(
                "Enter Customer ID: "
        );

        int customerId = scanner.nextInt();

        scanner.nextLine();

        Customer customer =
                findCustomer(customerId);

        if (customer == null) {

            System.out.println(
                    "Customer not found."
            );

            return;
        }

        int orderId = 1000 + customerId;

        Order order = new Order(
                orderId,
                customer,
                10
        );

        boolean ordering = true;

        while (ordering) {

            displayMenu();

            System.out.print(
                    "\nEnter Item ID (0 to finish): "
            );

            int itemId = scanner.nextInt();

            if (itemId == 0) {
                break;
            }

            MenuItem item =
                    findMenuItem(itemId);

            if (item == null) {

                System.out.println(
                        "Invalid Item ID. Please try again."
                );

                continue;
            }

            order.addItem(item);

            scanner.nextLine();

            System.out.print(
                    "Do you want to add another item? (yes/no): "
            );

            String answer = scanner.nextLine()
                    .trim()
                    .toLowerCase();

            if (answer.equals("no")) {

                ordering = false;
            }
        }

        // Check whether any item was added
        if (order.getItemCount() == 0) {

            System.out.println(
                    "No items were added to the order."
            );

            return;
        }

        order.setStatus(
                OrderStatus.PREPARING
        );

        System.out.println();

        System.out.println(
                "Order placed successfully."
        );

        System.out.println(order);

        order.printPaymentMessage();

        System.out.printf(
                "Rounded Bill: Rs. %d%n",
                order.getRoundedBill()
        );

        order.setStatus(
                OrderStatus.READY
        );

        System.out.println(
                "Order Status: " + order.getStatus()
        );
    }

    // Demonstrate polymorphism / dynamic binding
    public void demonstratePolymorphism() {

        System.out.println();

        System.out.println(
                "========= POLYMORPHISM DEMO ========="
        );

        for (int i = 0; i < employeeCount; i++) {

            Person person = employees[i];

            // Dynamic method dispatch
            person.displayRole();

            System.out.println(
                    "Object: "
                    + person.getClass().getSimpleName()
            );

            System.out.println();
        }
    }
}