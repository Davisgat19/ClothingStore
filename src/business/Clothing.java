package business;

public abstract class Clothing {
    private String id;
    private String name;
    private String size;
    private double price;
    private String material;
    private String color;
    private Customer customer;

    public Clothing(String id, String name, String size, double price, String material, String color) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
    }

    public void printDetails() {
        System.out.println("Clothing ID: " + id +
                ", Name: " + name +
                ", Size: " + size +
                ", Price: " + price +
                ", Material: " + material +
                ", Color: " + color +
                ", Customer: " + (customer != null ? customer.getName() : "No customer assigned"));
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
        }
    }
