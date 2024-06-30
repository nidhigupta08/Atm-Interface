package main.java.atm;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, User> users;

    public Bank() {
        users = new HashMap<>();
        // Adding some dummy users
        users.put("user1", new User("user1", "1234", 1000.0));
        users.put("user2", new User("user2", "2345", 1500.0));
    }

    public User authenticateUser(String userId, String pin) {
        User user = users.get(userId);
        if (user != null && user.validatePin(pin)) {
            return user;
        }
        return null;
    }

    public void transfer(User sender, String recipientId, double amount) {
        User recipient = users.get(recipientId);
        if (recipient == null) {
            System.out.println("Recipient user ID not found.");
        } else {
            sender.transfer(recipient, amount);
        }
    }
}
 