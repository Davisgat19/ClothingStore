package main;

import business.Clothing;
import business.Customer;
import observer.VD;
import service.OrderService;
import builder.PantsBuilder;
import builder.TShirtBuilder;
import builder.SkirtBuilder;
import command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static int customerIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VD ceo = new VD("Boss Lady");
        OrderService orderService = OrderService.getInstance();
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

            Pipeline pipeline = new Pipeline();

            System.out.println("Enter size:");
            String size = scanner.nextLine();
            pipeline.addCommand(new SetSizeCommand(size));

            System.out.println("Enter material:");
            String material = scanner.nextLine();
            pipeline.addCommand(new SetMaterialCommand(material));

            System.out.println("Enter color:");
            String color = scanner.nextLine();
            pipeline.addCommand(new SetColorCommand(color));

            Clothing clothing;
            switch (clothingType) {
                case 1:
                    System.out.println("Enter fit:");
                    String fit = scanner.nextLine();
                    pipeline.addCommand(new SetFitCommand(fit));

                    System.out.println("Enter length:");
                    String length = scanner.nextLine();
                    pipeline.addCommand(new SetLengthCommand(length));

                    clothing = new PantsBuilder().setSize(size).setMaterial(material).setColor(color).setFit(fit).setLength(length).build();
                    break;
                case 2:
                    System.out.println("Enter sleeves:");
                    String sleeves = scanner.nextLine();
                    pipeline.addCommand(new SetSleevesCommand(sleeves));

                    System.out.println("Enter neck:");
                    String neck = scanner.nextLine();
                    pipeline.addCommand(new SetNeckCommand(neck));

                    clothing = new TShirtBuilder().setSize(size).setMaterial(material).setColor(color).setSleeves(sleeves).setNeck(neck).build();
                    break;
                case 3:
                    System.out.println("Enter waistline:");
                    String waistline = scanner.nextLine();
                    pipeline.addCommand(new SetWaistlineCommand(waistline));

                    System.out.println("Enter pattern:");
                    String pattern = scanner.nextLine();
                    pipeline.addCommand(new SetPatternCommand(pattern));

                    clothing = new SkirtBuilder().setSize(size).setMaterial(material).setColor(color).setWaistline(waistline).setPattern(pattern).build();
                    break;
                default:
                    continue;
            }

            pipeline.execute(clothing);
            orderService.addOrder(clothing, customer);

            System.out.println("Do you want to add another order? (yes/no)");
            String addAnother = scanner.nextLine().toLowerCase();

            if (!addAnother.equals("yes")) {
                continueAddingOrders = false;
            }
        }

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
}
