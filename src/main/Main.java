package main;

import business.Pants;
import business.Skirt;
import business.TShirt;
import business.Customer;
import builder.PantsBuilder;
import builder.SkirtBuilder;
import builder.TShirtBuilder;
import command.ClothingCommand;
import command.CommandPipeline;
import command.GenericClothingCommand;
import observer.VD;
import service.OrderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        Customer customer = new Customer(customerName, customerAddress, customerEmail);

        VD ceo = new VD("Boss Lady");

        OrderService orderService = OrderService.getInstance();

        orderService.addObserver(ceo);

        boolean keepOrdering = true;

        while (keepOrdering) {
            System.out.println("\nChoose a clothing type to order:");
            System.out.println("1. Pants");
            System.out.println("2. Skirt");
            System.out.println("3. T-Shirt");
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter pants size: ");
                String pantsSize = scanner.nextLine();

                System.out.print("Enter pants material: ");
                String pantsMaterial = scanner.nextLine();

                System.out.print("Enter pants color: ");
                String pantsColor = scanner.nextLine();

                System.out.print("Enter pants fit: ");
                String pantsFit = scanner.nextLine();

                System.out.print("Enter pants length: ");
                String pantsLength = scanner.nextLine();

                PantsBuilder pantsBuilder = new PantsBuilder();
                Pants myPants = pantsBuilder.setSize(pantsSize)
                        .setMaterial(pantsMaterial)
                        .setColor(pantsColor)
                        .setFit(pantsFit)
                        .setLength(pantsLength)
                        .build();

                CommandPipeline pantsPipeline = new CommandPipeline();

                ClothingCommand sewFitCommand = new GenericClothingCommand("sew", "fit", pantsFit);
                ClothingCommand cutLengthCommand = new GenericClothingCommand("cut", "length", pantsLength);

                pantsPipeline.addCommand(sewFitCommand);
                pantsPipeline.addCommand(cutLengthCommand);

                System.out.println("Processing Pants:");
                pantsPipeline.execute(myPants);

                orderService.addOrder(myPants, customer);

            } else if (choice == 2) {
                System.out.print("Enter skirt size: ");
                String skirtSize = scanner.nextLine();

                System.out.print("Enter skirt material: ");
                String skirtMaterial = scanner.nextLine();

                System.out.print("Enter skirt color: ");
                String skirtColor = scanner.nextLine();

                System.out.print("Enter skirt waistline: ");
                String skirtWaistline = scanner.nextLine();

                System.out.print("Enter skirt pattern: ");
                String skirtPattern = scanner.nextLine();

                SkirtBuilder skirtBuilder = new SkirtBuilder();
                Skirt mySkirt = skirtBuilder.setSize(skirtSize)
                        .setMaterial(skirtMaterial)
                        .setColor(skirtColor)
                        .setWaistline(skirtWaistline)
                        .setPattern(skirtPattern)
                        .build();

                CommandPipeline skirtPipeline = new CommandPipeline();

                ClothingCommand sewWaistlineCommand = new GenericClothingCommand("sew", "waistline", skirtWaistline);
                ClothingCommand cutPatternCommand = new GenericClothingCommand("cut", "pattern", skirtPattern);

                skirtPipeline.addCommand(sewWaistlineCommand);
                skirtPipeline.addCommand(cutPatternCommand);

                System.out.println("Processing Skirt:");
                skirtPipeline.execute(mySkirt);

                orderService.addOrder(mySkirt, customer);

            } else if (choice == 3) {
                System.out.print("Enter T-Shirt size: ");
                String tShirtSize = scanner.nextLine();

                System.out.print("Enter T-Shirt material: ");
                String tShirtMaterial = scanner.nextLine();

                System.out.print("Enter T-Shirt color: ");
                String tShirtColor = scanner.nextLine();

                System.out.print("Enter T-Shirt sleeves: ");
                String tShirtSleeves = scanner.nextLine();

                System.out.print("Enter T-Shirt neck: ");
                String tShirtNeck = scanner.nextLine();

                TShirtBuilder tShirtBuilder = new TShirtBuilder();
                TShirt myTShirt = tShirtBuilder.setSize(tShirtSize)
                        .setMaterial(tShirtMaterial)
                        .setColor(tShirtColor)
                        .setSleeves(tShirtSleeves)
                        .setNeck(tShirtNeck)
                        .build();

                CommandPipeline tShirtPipeline = new CommandPipeline();

                ClothingCommand sewNeckCommand = new GenericClothingCommand("sew", "neck", tShirtNeck);
                ClothingCommand cutSleevesCommand = new GenericClothingCommand("cut", "sleeves", tShirtSleeves);

                tShirtPipeline.addCommand(sewNeckCommand);
                tShirtPipeline.addCommand(cutSleevesCommand);

                System.out.println("Processing T-Shirt:");
                tShirtPipeline.execute(myTShirt);

                orderService.addOrder(myTShirt, customer);
            }

            System.out.print("\nDo you want to make another order? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                keepOrdering = false;
            }
        }

        orderService.printReceipt();
    }
}
