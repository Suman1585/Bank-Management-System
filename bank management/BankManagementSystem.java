import java.sql.*;
import java.util.Scanner;

public class BankManagementSystem {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bankdb";
    static final String USER = "root";
    static final String PASS = "yourpassword";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            while (true) {
                System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Delete Account\n6. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();  // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter initial balance: ");
                        double balance = sc.nextDouble();
                        stmt.executeUpdate("INSERT INTO accounts (name, balance) VALUES ('" + name + "', " + balance + ")");
                        System.out.println("Account created successfully.");
                        break;
                    case 2:
                        System.out.print("Enter account ID: ");
                        int depId = sc.nextInt();
                        System.out.print("Enter amount to deposit: ");
                        double depAmt = sc.nextDouble();
                        stmt.executeUpdate("UPDATE accounts SET balance = balance + " + depAmt + " WHERE id = " + depId);
                        System.out.println("Amount deposited.");
                        break;
                    case 3:
                        System.out.print("Enter account ID: ");
                        int witId = sc.nextInt();
                        System.out.print("Enter amount to withdraw: ");
                        double witAmt = sc.nextDouble();
                        stmt.executeUpdate("UPDATE accounts SET balance = balance - " + witAmt + " WHERE id = " + witId);
                        System.out.println("Amount withdrawn.");
                        break;
                    case 4:
                        System.out.print("Enter account ID: ");
                        int balId = sc.nextInt();
                        ResultSet rs = stmt.executeQuery("SELECT balance FROM accounts WHERE id = " + balId);
                        if (rs.next()) {
                            System.out.println("Balance: " + rs.getDouble("balance"));
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter account ID to delete: ");
                        int delId = sc.nextInt();
                        stmt.executeUpdate("DELETE FROM accounts WHERE id = " + delId);
                        System.out.println("Account deleted.");
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}