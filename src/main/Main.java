package main;

import business.Clothing;
import business.Customer;
import observer.VD;
import service.OrderService;

import builder.PantsBuilder;
import builder.TShirtBuilder;
import builder.SkirtBuilder;

import command.Command;
import command.FitCommand;
import command.LengthCommand;
import command.NeckCommand;
import command.SleevesCommand;
import command.PatternCommand;
import command.WaistlineCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static int customerIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = OrderService.getInstance();

        VD ceo = new VD("Boss Lady");
        orderService.addObserver(ceo);

        boolean continueAddingOrders = true;

        while (continueAddingOrders) {
            System.out.println("Select the type of clothing:");
            System.out.println("1. Pants");
            System.out.println("2. TShirt");
            System.out.println("3. Skirt");
            System.out.println("Enter the number (or 'exit' to quit and print receipt):");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            int clothingType;
            try {
                clothingType = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (clothingType < 1 || clothingType > 3) {
                System.out.println("Invalid selection. Please enter a number between 1 and 3.");
                continue;
            }

            Customer customer = getCustomerInfo(scanner);

            switch (clothingType) {
                case 1:
                    createPantsOrder(scanner, orderService, customer);
                    break;
                case 2:
                    createTShirtOrder(scanner, orderService, customer);
                    break;
                case 3:
                    createSkirtOrder(scanner, orderService, customer);
                    break;
                default:
                    System.out.println("Invalid selection.");
                    continue;
            }

            System.out.println("Do you want to add another order? (yes/no)");
            String addAnother = scanner.nextLine().toLowerCase();

            if (!addAnother.equals("yes")) {
                continueAddingOrders = false;
            }
        }

        // Print the receipt
        orderService.printReceipt();

        scanner.close();
    }

    private static Customer getCustomerInfo(Scanner scanner) {
        System.out.println("Enter customer ID (if new customer, enter 0):");
        int customerId = Integer.parseInt(scanner.nextLine());

        Customer customer;
        if (customerId == 0) {
            customer = createNewCustomer(scanner);
            customers.put(customer.getId(), customer);
        } else {
            customer = customers.get(customerId);
            if (customer == null) {
                System.out.println("Customer not found. Creating a new customer.");
                customer = createNewCustomer(scanner);
                customers.put(customer.getId(), customer);
            }
        }

        return customer;
    }

    private static Customer createNewCustomer(Scanner scanner) {
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();

        System.out.println("Enter customer address:");
        String address = scanner.nextLine();

        System.out.println("Enter customer email:");
        String email = scanner.nextLine();

        Customer customer = new Customer(customerIdCounter++, name, address, email);
        System.out.println("New customer created with ID: " + customer.getId());
        return customer;
    }

    private static void createPantsOrder(Scanner scanner, OrderService orderService, Customer customer) {
        System.out.println("Enter size:");
        String size = scanner.nextLine();

        System.out.println("Enter material:");
        String material = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter fit:");
        String fit = scanner.nextLine();

        System.out.println("Enter length:");
        String length = scanner.nextLine();

        Clothing pants = new PantsBuilder()
                .setSize(size)
                .setMaterial(material)
                .setColor(color)
                .setFit(fit)
                .setLength(length)
                .build();

        //COMMANDS
        applyPantsCommands(scanner, pants);

        orderService.addOrder(pants, customer);
    }

    private static void applyPantsCommands(Scanner scanner, Clothing pants) {
        boolean continueApplyingCommands = true;
        Command command;

        while (continueApplyingCommands) {
            System.out.println("Select command to apply:");
            System.out.println("1. Adjust Fit");
            System.out.println("2. Adjust Length");
            System.out.println("3. Finish");
            System.out.println("Enter the number:");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Enter new fit:");
                    String newFit = scanner.nextLine();
                    command = new FitCommand(newFit);
                    command.execute(pants);
                    break;
                case "2":
                    System.out.println("Enter new length:");
                    String newLength = scanner.nextLine();
                    command = new LengthCommand(newLength);
                    command.execute(pants);
                    break;
                case "3":
                    continueApplyingCommands = false;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void createTShirtOrder(Scanner scanner, OrderService orderService, Customer customer) {
        System.out.println("Enter size:");
        String size = scanner.nextLine();

        System.out.println("Enter material:");
        String material = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter sleeves:");
        String sleeves = scanner.nextLine();

        System.out.println("Enter neck:");
        String neck = scanner.nextLine();

        Clothing tshirt = new TShirtBuilder()
                .setSize(size)
                .setMaterial(material)
                .setColor(color)
                .setSleeves(sleeves)
                .setNeck(neck)
                .build();

        applyTshirtCommands(scanner, tshirt);

        orderService.addOrder(tshirt, customer);
    }

    private static void applyTshirtCommands(Scanner scanner, Clothing tshirt) {
        boolean continueApplyingCommands = true;
        Command command;

        while (continueApplyingCommands) {
            System.out.println("Select command to apply:");
            System.out.println("1. Adjust Sleeves");
            System.out.println("2. Adjust Neck");
            System.out.println("3. Finish");
            System.out.println("Enter the number:");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Enter new sleeves:");
                    String newSleeves = scanner.nextLine();
                    command = new SleevesCommand(newSleeves);
                    command.execute(tshirt);
                    break;
                case "2":
                    System.out.println("Enter new neck:");
                    String newNeck = scanner.nextLine();
                    command = new NeckCommand(newNeck);
                    command.execute(tshirt);
                    break;
                case "3":
                    continueApplyingCommands = false;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;

            }
        }
    }

    private static void createSkirtOrder(Scanner scanner, OrderService orderService, Customer customer) {
        System.out.println("Enter size:");
        String size = scanner.nextLine();

        System.out.println("Enter material:");
        String material = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter pattern:");
        String pattern = scanner.nextLine();

        System.out.println("Enter waistline:");
        String waistline = scanner.nextLine();

        Clothing skirt = new SkirtBuilder()
                .setSize(size)
                .setMaterial(material)
                .setColor(color)
                .setPattern(pattern)
                .setWaistline(waistline)
                .build();

        applySkirtCommands(scanner, skirt);

        orderService.addOrder(skirt, customer);
    }

    private static void applySkirtCommands(Scanner scanner, Clothing skirt) {
        boolean continueApplyingCommands = true;
        Command command;

        while (continueApplyingCommands) {
            System.out.println("Select command to apply:");
            System.out.println("1. Adjust Pattern");
            System.out.println("2. Adjust Waistline");
            System.out.println("3. Finish");
            System.out.println("Enter the number:");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Enter new Pattern:");
                    String newPattern = scanner.nextLine();
                    command = new PatternCommand(newPattern);
                    command.execute(skirt);
                    break;
                case "2":
                    System.out.println("Enter new Waistline:");
                    String newWaistline = scanner.nextLine();
                    command = new WaistlineCommand(newWaistline);
                    command.execute(skirt);
                    break;
                case "3":
                    continueApplyingCommands = false;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}