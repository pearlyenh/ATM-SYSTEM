package ATM;
import java.util.Scanner;

public class Practice {
    static Scanner scanner = new Scanner(System.in);

    static int attempts;
    static String pin;
    static String correctPin;

    public static void Login(){
        attempts = 3;

        while (attempts > 0){
            System.out.println("========== LOGIN ==========");
            System.out.println("Enter PIN: ");
            pin = scanner.nextLine();

            if (pin.equals(correctPin)){
                System.out.println("Login Successful");
            }
        }
    }
    public static void main(String[] args) {
        correctPin = "1234";
    }
}
