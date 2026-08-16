package ATM;
import java.util.Scanner;
import java.util.ArrayList;

public class TRANSACTION {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> transactionList = new ArrayList<>();

    private static double balance = 0.0;

    static int attempts;

    static String pin;
    static String enteredPin;
    static String newPin;
    static String cPin;
    static String correctPin = "1234";

    static int option;
    static double depositAmount;

    static double withdraw;
    static int exit;


    public static Boolean Login(){
        attempts = 3;

        while (attempts > 0){
            System.out.println("\n========== LOGIN ==========");
            System.out.print("Enter PIN: ");
            pin = scanner.nextLine();

            if (pin.equals(correctPin)){
                System.out.println("\nLogin Successful");
                return true;
            }
            else {
                attempts--;

                if (attempts > 0){
                    System.out.println("\nInvalid PIN");
                    System.out.println("Remaining attempts: " + attempts);
                }
                else {
                    System.out.println("\nAccount Locked.");
                }
            }
        }
        return false;
    }
    public static void MainMenu(){
        System.out.println("\n========== ATM MENU ==========");
        System.out.println("[1] Check Balance");
        System.out.println("[2] Deposit");
        System.out.println("[3] Withdraw");
        System.out.println("[4] Transaction History");
        System.out.println("[5] Change PIN");
        System.out.println("[6] Exit");
        System.out.print("\nEnter an option: ");
        option = scanner.nextInt();
    }
    public static void CheckBalance(){
        System.out.println("\n========== CHECK BALANCE ===========");
        System.out.println("Current Balance: " + balance);
    }
    public static void Deposit(){
        System.out.println("\n========== DEPOSIT =============");
        System.out.print("Enter deposit amount: ");
        depositAmount = scanner.nextDouble();

        if (depositAmount <= 0){
            System.out.println("\nInvalid deposit amount");
        }
        else {
            balance = depositAmount + balance;
            transactionList.add("\nDeposit: " + depositAmount + "\nBalance after deposit: " + balance + "\n");

            System.out.println("\nDeposit Successful!");
            System.out.println("Updated balance: " + balance);
        }
    }
    public static void Withdraw(){
        System.out.println("\n============== WITHDRAW ===============");
        System.out.print("Enter withdrawal amount: ");
        withdraw = scanner.nextDouble();

        if (withdraw <= 0){
            System.out.println("\nInvalid withdrawal amount");
        }
        else if (withdraw > balance){
            System.out.println("\nInsuffient balance");
        }
        else {
            balance = balance - withdraw;
            transactionList.add("\nWithdrawal: " + withdraw + "\nBalance after withdrawal: " + balance + "\n");
            System.out.println("\nWithdrawal successful!");
            System.out.println("Updated balance: " + balance);
        }
    }
    public static void TransactionHistory(){
        System.out.println("\n========== TRANSACTION HISTORY ==========");
        if (transactionList.isEmpty()){
            System.out.println("\nNo Transactions yet.");
        }
        else {
            for (int i = 0; i < transactionList.size(); i++){
                System.out.println("Transaction #" + (i+1) + transactionList.get(i));
            }
        }
    }
    public static void ChangePIN(){
        System.out.println("\n========== CHANGE PIN ==========");
        System.out.print("Enter current PIN: ");
        enteredPin = scanner.next();

        if (!enteredPin.equals(correctPin)){
            System.out.println("\nIncorrect PIN");
            return;
        }
        System.out.print("\nEnter new PIN: ");
        newPin = scanner.next();

        System.out.print("Type new PIN: ");
        cPin = scanner.next();

        if (newPin.equals(cPin)){
            correctPin = newPin;
            System.out.println("\nPIN successfully changed.");
        }
        else {
            System.out.println("\nPINs do not match.");
        }
    }
    public static void main(String[] args) {
        
        if (Login() == true){
            while (true){
                MainMenu();
                if (option == 1){
                    CheckBalance();
                }
                else if (option == 2){
                    Deposit();
                }
                else if (option == 3){
                    Withdraw();
                }
                else if(option == 4){
                    TransactionHistory();
                }
                else if (option == 5){
                    ChangePIN();
                }
                else if (option == 6){
                    System.out.println("\n Are you sure do you want to exit? ");
                    System.out.println("[1] Yes");
                    System.out.println("[2] No");
                    System.out.print("Enter option: ");
                    exit = scanner.nextInt();
                    
                    if (exit == 1){
                        System.out.println("\nThank you. See you next time!");
                        break;
                    }
                    else if (exit == 2){
                        System.out.println("\nWELCOME BACK!");
                    }
                    else {
                        System.out.println("\nInvalid input. Try again.");
                    }
                }
                else {
                    System.out.println("\nInvalid input. Try again.");
                }
            }  
        }
    }
}
