package ATM;
import java.util.Scanner;

public class PIN {
    static Scanner scanner = new Scanner(System.in);

    private static double balance = 10000.0;

    static int attempts;
    static String pin;
    static String correctPin;
    static int option;
    static double depositAmount;
    static double add;
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
        System.out.println("[4] Exit");
        System.out.print("\nEnter an option: ");
        option = scanner.nextInt();
    }
    public static void CheckBalance(){
        System.out.println("\n========== CHECK BALANCE ===========");
        System.out.println("Current Balance: " + balance);
    }
    public static void Deposit(){
        System.out.println("\n============ DEPOSIT ============");
        System.out.print("Enter deposit amount: ");
        depositAmount = scanner.nextDouble();

        if (depositAmount > 0){
            balance = depositAmount + balance;
            System.out.println("\nDeposit Successful");
            System.out.println("Updated balance: " + balance);
        }
        else {
            System.out.println("\nInvalid deposit amount");
        }
    }
    public static void Withdraw(){
        System.out.println("\n============== WITHDRAW ===============");
        System.out.print("Enter withdrawal amount: ");
        withdraw = scanner.nextDouble();

        if (withdraw > balance){
            System.out.println("\nInvalid Withdrawal amount");
        }
        else {
            balance = balance - withdraw;
            System.out.println("\nWithdrawal Successful");
            System.out.println("Updated Balance: " + balance);
        }
    }
    public static void main(String[] args) {
        correctPin = "1234";

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
                else if (option == 4){
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
            }
        }  
    }
}
