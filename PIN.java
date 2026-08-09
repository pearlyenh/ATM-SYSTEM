package ATM;
import java.util.Scanner;

class PIN{

    static Scanner scanner = new Scanner(System.in);
    static String correctPin = "1234";
    static String pin;
    static int attempt;
    static int option;

    private double balance = 50000;

    public static Boolean login(){

        attempt = 3;
        
        while(attempt > 0){
            System.out.println("=======================");
            System.out.println("       ATM SYSTEM      ");
            System.out.println("=======================");
            System.out.println("Enter PIN: ");
            pin = scanner.nextLine();

            if (pin.equals(correctPin)){
                System.out.println("Login Successful!");
                return true;
            }
            else {
                attempt--;
                
                if (attempt > 0){
                    System.out.println("Unsuccessful login. Please try again. ");
                    System.out.println("Remaining attempt: " + attempt);
                }
                else {
                    System.out.println("Account locked.");
                }
            }
        }
        return false;
    }
    public static void MainMenu(){
        System.out.println("========== ATM MENU ==========");
        System.out.println("[1] Check Balance");
        System.out.println("[2] Deposit");
        System.out.println("[3] Withdraw");
        System.out.println("[4] Change PIN");
        System.out.println("[5] Logout");
        System.out.println("==============================");
        System.out.print("Choose an option:");
        option = scanner.nextInt();
    }
    public static void checkBalance(){
        System.out.println("========== Checking of Balance ==========");
        System.out.println("Current Balance: ");
    }
    public static void deposit(){
        System.out.println();
    }
    public static void withdraw(){
        System.out.println();
    }
    public static void changePin(){
        System.out.println();
    }
    public static void main(String[] args) {
        
    }
}