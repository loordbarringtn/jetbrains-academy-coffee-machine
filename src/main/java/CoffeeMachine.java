import java.util.Scanner;

public class CoffeeMachine {
    static final Scanner scanner = new Scanner(System.in);
    static final int ESPRESSO_PRICE = 4;
    static final int CAPPUCCINO_PRICE = 6;
    static final int LATTE_PRICE = 7;

    private static int waterAmount = 400;
    private static int milkAmount = 540;
    private static int coffeeBeansAmount = 120;
    private static int disposableCupsAmount = 9;
    private static int moneyAmount = 550;
    private static String action;
    private static String choiceNumber;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");

            action = scanner.nextLine();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

                    choiceNumber = scanner.next();

                    switch (choiceNumber){
                        case "1":
                            checkResourcesAndPrepare (250, 0, 16, ESPRESSO_PRICE);
                            break;
                        case "2":
                            checkResourcesAndPrepare (350, 75, 20, LATTE_PRICE);
                            break;
                        case "3":
                            checkResourcesAndPrepare (200, 100, 12, CAPPUCCINO_PRICE);
                            break;
                        case "break":
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    waterAmount += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milkAmount += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    coffeeBeansAmount += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    disposableCupsAmount += scanner.nextInt();
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
    }


    public static void coffeeMachineStatus(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water %n", waterAmount);
        System.out.printf("%d of milk %n", milkAmount);
        System.out.printf("%d of coffee beans %n", coffeeBeansAmount);
        System.out.printf("%d of disposable cups %n", disposableCupsAmount);
        System.out.printf("%d of money %n", moneyAmount);
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
    }


    static void checkResourcesAndPrepare (int requiredWater, int requiredMilk, int requiredBeans, int price) {
        if (waterAmount >= requiredWater && milkAmount >= requiredMilk
                && coffeeBeansAmount >= requiredBeans && disposableCupsAmount >= 1) {
            moneyAmount += price;
            waterAmount -= requiredWater;
            milkAmount -= requiredMilk;
            coffeeBeansAmount -= requiredBeans;
            disposableCupsAmount -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.print("Sorry, not enough ");
            if (waterAmount <= requiredWater) {
                System.out.println("water!");
            } else if (milkAmount <= requiredMilk) {
                System.out.println("milk!");
            } else if (coffeeBeansAmount <= requiredBeans) {
                System.out.println("beans!");
            } else if (disposableCupsAmount <= 1) {
                System.out.println("cups!");
            }
        }
    }








}


