import java.util.Scanner;


public class MachineEngine {

    private static int waterAmount = 400;
    private static int milkAmount = 540;
    private static int coffeeBeansAmount = 120;
    private static int disposableCupsAmount = 9;
    private static int moneyAmount = 550;
    final Scanner scanner = new Scanner(System.in);
    CoffeeTypes espresso = CoffeeTypes.ESPRESSO;
    CoffeeTypes latte = CoffeeTypes.LATTE;
    CoffeeTypes cappuccino = CoffeeTypes.CAPPUCCINO;

    public void processInput(String input) {

        switch (input) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                System.out.printf("I gave you $%d %n", moneyAmount);
                moneyAmount = 0;
                break;
            case "remaining":
                coffeeMachineStatus();
                break;
            case "exit":
                System.exit(0);
        }
    }

    private void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        final String choiceNumber = scanner.next();

        switch (choiceNumber) {
            case "1":
                checkResourcesAndPrepare(espresso);
                break;
            case "2":
                checkResourcesAndPrepare(latte);
                break;
            case "3":
                checkResourcesAndPrepare(cappuccino);
                break;
            case "break":
                break;
        }
    }

    private void checkResourcesAndPrepare(CoffeeTypes coffeeType) {
        if (waterAmount >= coffeeType.getWater() && milkAmount >= coffeeType.getMilk()
                && coffeeBeansAmount >= coffeeType.getCoffeeBeans() && disposableCupsAmount >= 1) {
            moneyAmount += coffeeType.getPrice();
            waterAmount -= coffeeType.getWater();
            milkAmount -= coffeeType.getMilk();
            coffeeBeansAmount -= coffeeType.getCoffeeBeans();
            disposableCupsAmount -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.print("Sorry, not enough ");
            if (waterAmount <= coffeeType.getWater()) {
                System.out.println("water!");
            } else if (milkAmount <= coffeeType.getMilk()) {
                System.out.println("milk!");
            } else if (coffeeBeansAmount <= coffeeType.getCoffeeBeans()) {
                System.out.println("beans!");
            } else if (disposableCupsAmount <= 1) {
                System.out.println("cups!");
            }
        }
    }

    private void fillMachine(){
        System.out.println("Write how many ml of water do you want to add:");
        waterAmount += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkAmount += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeansAmount += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCupsAmount += scanner.nextInt();
    }

    private void coffeeMachineStatus(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water %n", waterAmount);
        System.out.printf("%d of milk %n", milkAmount);
        System.out.printf("%d of coffee beans %n", coffeeBeansAmount);
        System.out.printf("%d of disposable cups %n", disposableCupsAmount);
        System.out.printf("%d of money %n", moneyAmount);
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
    }

}
