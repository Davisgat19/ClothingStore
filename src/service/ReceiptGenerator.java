package service;

import business.Clothing;
import business.Customer;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptGenerator {
    public static void generateReceipt(List<Clothing> orders, Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Receipt - " + dateFormat.format(date));
        System.out.println("-----------------------------------------------");
        for (Clothing clothing : orders) {
            Customer customer = clothing.getCustomer();
            System.out.println("Order ID: " + clothing.getId());
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Clothing order: " + clothing.getName());

            System.out.println("-----------------------------------------------");


        }
    }
}
