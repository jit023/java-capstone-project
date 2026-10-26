import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ATM {
    static double balance = 5000.0;
    static int correctPIN = 1234;
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== WELCOME TO ATM =====");
        System.out.print("Enter PIN: ");
        int pin = Integer.parseInt(sc.nextLine());

        if (pin != correctPIN) {
            System.out.println("Incorrect PIN!");
            sc.close();
            return;
        }

        System.out.println("Login Successful!");

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Balance: Rs. " + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = Double.parseDouble(sc.nextLine());

                    if (deposit > 0) {
                        balance += deposit;
                        history.add("Deposited: Rs. " + deposit);
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = Double.parseDouble(sc.nextLine());

                    if (withdraw <= 0) {
                        System.out.println("Invalid amount!");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        balance -= withdraw;
                        history.add("Withdrawn: Rs. " + withdraw);
                        System.out.println("Please collect your money.");
                    }
                    break;

                case 4:
                    System.out.println("Transaction History:");
                    if (history.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String item : history) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 5:
                    try (FileWriter fw = new FileWriter("transactions.txt")) {
                        fw.write("Final Balance: Rs. " + balance + "\n");
                        for (String item : history) {
                            fw.write(item + "\n");
                        }
                        System.out.println("Transaction history saved!");
                    } catch (IOException e) {
                        System.out.println("Could not save transaction history.");
                    }

                    System.out.println("Thank you for using ATM!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}