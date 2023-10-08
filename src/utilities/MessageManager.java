package utilities;
import interfaces.IMessageManager;

public class MessageManager implements IMessageManager {
    private static MessageManager instance;
    private MessageManager() {}

    public static MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
        }
        return instance;
    }

    public void sendMessage(String message) {
        System.out.println(message);
    }
}
