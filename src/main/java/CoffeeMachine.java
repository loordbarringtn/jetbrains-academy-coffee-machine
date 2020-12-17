
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MachineEngine machineEngine = new MachineEngine();

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            machineEngine.processInput(scanner.nextLine());
        }


    }
}
