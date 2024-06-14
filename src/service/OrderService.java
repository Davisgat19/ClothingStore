package service;

import business.Clothing;
import business.Customer;
import observer.Observer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    private static OrderService instance;
    private final List<Clothing> orders;
    private final List<Observer> observers;
    private int orderIdCounter;

    private OrderService() {
        orders = new ArrayList<>();
        observers = new ArrayList<>();
        orderIdCounter = 1; // start from 1
    }

    public static synchronized OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void addOrder(Clothing clothing, Customer customer) {
        clothing.setId(orderIdCounter++);
        clothing.setCustomer(customer); // Set custnmer for order
        orders.add(clothing);
        notifyObservers(clothing.getName() + " is being made.");
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void printReceipt() {
        Date date = new Date();
        ReceiptGenerator.generateReceipt(orders, date);
    }
}
//Fix single reciept for multiple orders