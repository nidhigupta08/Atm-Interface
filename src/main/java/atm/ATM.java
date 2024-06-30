package main.java.atm;

import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner scanner;

    public ATM() {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM");
        while (true) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            User currentUser = bank.authenticateUser(userId, pin);
            if (currentUser != null) {
                showMenu(currentUser);
            } else {
                System.out.println("Invalid user ID or PIN. Please try again.");
            }
        }
    }

    private void showMenu(User user) {
        while (true) {
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    user.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient User ID: ");
                    String recipientId = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transfer(user, recipientId, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
