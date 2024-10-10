package observer;

import business.Clothing;

import java.util.ArrayList;
import java.util.List;

public class CEO implements Observer {
    private final String name;
    private final List<String> messages;

    public CEO(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    @Override
    public void update(String eventType, Clothing clothing) {
        String message = name + " received a notification: " + eventType + " for clothing item: " + clothing.getName();
        messages.add(message);
        System.out.println(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
