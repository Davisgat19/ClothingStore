package service;

import business.Clothing;
import business.Customer;
import observer.CEO;
import observer.Observer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    private static OrderService instance;
    private static int orderIdCounter = 1;
    private final List<Clothing> orders;
    private final List<Observer> observers;

    private OrderService() {
        orders = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String eventType, Clothing clothing) {
        for (Observer observer : observers) {
            observer.update(eventType, clothing);
        }
    }

    public void addOrder(Clothing clothing, Customer customer) {
        clothing.setCustomer(customer);
        clothing.setId("CLOTH-" + orderIdCounter++);
        orders.add(clothing);
        notifyObservers("Clothing item is being made", clothing);
    }

    public List<Clothing> getOrders() {
        return orders;
    }

    public void printReceipt(List<Clothing> orders, Date date, CEO ceo) {
        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders to print.");
            return;
        }

        System.out.println("\n--- Order Receipt ---");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Receipt Date: " + dateFormat.format(date));
        System.out.println("-----------------------------------------------");

        double totalPrice = 0;

        for (Clothing order : orders) {
            Customer customer = order.getCustomer();
            if (customer != null) {
                System.out.println("\nCustomer: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Email: " + customer.getEmail());
            } else {
                System.out.println("\nCustomer details not available.");
            }

            System.out.println("Order Details:");
            order.printDetails();
            System.out.println("-----------------------------------------------");
        }

        System.out.println("\nTotal orders: " + orders.size());
        System.out.println("\n--- CEO Notifications ---");
        for (String message : ceo.getMessages()) {
            System.out.println(message);
        }

        System.out.println("\n--- End of Receipt ---");
    }
}
