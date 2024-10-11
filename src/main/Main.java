package main;

import builder.PantsBuilder;
import builder.SkirtBuilder;
import builder.TShirtBuilder;
import business.*;
import command.*;
import observer.CEO;
import service.OrderService;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OrderService orderService = OrderService.getInstance();

        CEO ceo = new CEO("Boss Lady");
        orderService.addObserver(ceo);

        CommandPipeline pipeline = new CommandPipeline();


        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        Customer customer = new Customer(customerName, customerAddress, customerEmail);

        boolean keepOrdering = true;

        while (keepOrdering) {
            System.out.println("\nChoose a clothing type to order:");
            System.out.println("1. Pants");
            System.out.println("2. Skirt");
            System.out.println("3. T-Shirt");
            System.out.println("4. Exit and print receipt");
            System.out.print("Enter your choice (1, 2, 3, or 4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            Clothing clothing = null;

            if (choice == 1) {
                String size = chooseOption(scanner, "Pick size:", "S", "M");
                String material = chooseOption(scanner, "Pick material:", "Denim", "Linen");
                String color = chooseOption(scanner, "Pick color:", "Blue", "Black");
                String fit = chooseOption(scanner, "Pick fit:", "Slim", "Loose", "Regular");
                String length = chooseOption(scanner, "Pick length:", "32", "34");

                Pants pants = new PantsBuilder()
                        .setName("Pants")
                        .setSize(size)
                        .setMaterial(material)
                        .setColor(color)
                        .setPrice(49.99)
                        .build();
                pants.setCustomer(customer);
                clothing = pants;

                pipeline.addCommand(new AdjustFitCommand(fit));
                pipeline.addCommand(new AdjustLengthCommand(length));

                orderService.addOrder(pants, customer);
                System.out.println("Pants added to order with ID: " + pants.getId());
            } else if (choice == 2) {
                String size = chooseOption(scanner, "Pick size:", "S", "M");
                String material = chooseOption(scanner, "Pick material:", "Cotton", "Silk");
                String color = chooseOption(scanner, "Pick color:", "Red", "Black");
                String waistline = chooseOption(scanner, "Pick waistline:", "High", "Medium", "Low");
                String pattern = chooseOption(scanner, "Pick pattern:", "Floral", "Solid");

                Skirt skirt = new SkirtBuilder()
                        .setName("Skirt")
                        .setSize(size)
                        .setMaterial(material)
                        .setColor(color)
                        .setPrice(39.99)
                        .build();
                skirt.setCustomer(customer);
                clothing = skirt;

                pipeline.addCommand(new AddWaistLineCommand(waistline));
                pipeline.addCommand(new AddPatternCommand(pattern));

                orderService.addOrder(skirt, customer);
                System.out.println("Skirt added to order with ID: " + skirt.getId());
            } else if (choice == 3) {
                String size = chooseOption(scanner, "Pick size:", "S", "M");
                String material = chooseOption(scanner, "Pick material:", "Cotton", "Polyester");
                String color = chooseOption(scanner, "Pick color:", "White", "Black");
                String sleeves = chooseOption(scanner, "Pick sleeves:", "Short", "Long", "Sleeveless");
                String neck = chooseOption(scanner, "Pick neck type:", "Round", "V-neck", "Polo");

                TShirt tShirt = new TShirtBuilder()
                        .setName("T-Shirt")
                        .setSize(size)
                        .setMaterial(material)
                        .setColor(color)
                        .setPrice(29.99)
                        .build();
                tShirt.setCustomer(customer);
                clothing = tShirt;

                pipeline.addCommand(new AdjustSleeveCommand(sleeves));
                pipeline.addCommand(new SewNeckCommand(neck));

                orderService.addOrder(tShirt, customer);
                System.out.println("T-Shirt added to order with ID: " + tShirt.getId());
            } else if (choice == 4) {
                keepOrdering = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            if (clothing != null) {
                pipeline.execute(clothing);
            }
        }

        Date currentDate = new Date();
        orderService.printReceipt(orderService.getOrders(), currentDate, ceo);

        scanner.close();
    }

    private static String chooseOption(Scanner scanner, String prompt, String... options) {
        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Enter choice (1-" + options.length + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice >= 1 && choice <= options.length) {
            return options[choice - 1];
        } else {
            System.out.println("Invalid choice. Default option selected.");
            return options[0];
        }
    }
}
