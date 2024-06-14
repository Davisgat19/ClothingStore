package observer;

public class VD implements Observer {
    private final String name;

    public VD(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("CEO " + name + ": " + message);
    }
}