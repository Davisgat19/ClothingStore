package business;

public abstract class Clothing {
    private int id; // Unik identifierare för varje klädesplagg
    private String name;
    private String size;
    private String material;
    private String color;
    private Customer customer; // Referens till kund

    public Clothing(String name) {
        this.name = name;
    }

    // Getter och Setter för id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter och Setter för customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Övriga getters och setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Metod för att visa detaljer för specifikt klädesplagg
    public abstract void displayDetails();
}
