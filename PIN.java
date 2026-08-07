package ATM;
import java.util.Scanner;

class PIN{

    static Scanner scanner = new Scanner(System.in);
    static String correctPin = "1234";
    static String pin;
    static int attempt;

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
    public static void checkBalance(){
        System.out.println();
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