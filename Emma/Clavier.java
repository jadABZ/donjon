
import java.util.Scanner;
import java.util.InputMismatchException;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int entrerClavierInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Vous devez entrer une entier.");
            return entrerClavierInt();
        }
    }

    public static String entrerClavierString() {
        return scanner.next();
    }

}