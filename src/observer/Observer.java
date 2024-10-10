package observer;

import business.Clothing;

public interface Observer {
    void update(String message, Clothing clothing);
}
