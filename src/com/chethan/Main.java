package com.chethan;

import java.util.Scanner;

public class Main {
    static int waterSupply = 400;
    static int milkSupply = 540;
    static int coffeeBeanSupply = 120;
    static int cupsSupply = 9;
    static int moneyPresent = 550;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        makeAction();
    }

    public static void makeAction() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String actionType = sc.next();
            switch (actionType) {
                case "buy" -> buyAction();
                case "fill" -> fillAction();
                case "take" -> takeAction();
                case "remaining" -> coffeeMachineStatus();
                case "exit" -> {
                    return;
                }
            }
        }
    }

    public static void buyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String coffeeType = sc.next();
        if(coffeeType.equals("back")) {
            return;
        }
        if (!canMakeRequiredCoffee(coffeeType)){
            return;
        }
        switch (coffeeType) {
            case "1" -> {
                waterSupply -= 250;
                coffeeBeanSupply -= 16;
                moneyPresent += 4;
            }
            case "2" -> {
                waterSupply -= 350;
                milkSupply -= 75;
                coffeeBeanSupply -= 20;
                moneyPresent += 7;
            }
            case "3" -> {
                waterSupply -= 200;
                milkSupply -= 100;
                coffeeBeanSupply -= 12;
                moneyPresent += 6;
            }
        }
        cupsSupply -= 1;
        System.out.println("I have enough resources, making you a coffee! ");
    }

    public static boolean canMakeRequiredCoffee(String coffeeType) {
        switch (coffeeType) {
            case "1":
                if (waterSupply < 250) {
                    System.out.println("Sorry, not enough water! ");
                    return false;
                } else if (coffeeBeanSupply < 16) {
                    System.out.println("Sorry, not enough coffee beans! ");
                    return false;
                }
                break;
            case "2":
                if (waterSupply < 350) {
                    System.out.println("Sorry, not enough water! ");
                    return false;
                } else if (milkSupply < 20) {
                    System.out.println("Sorry, not enough coffee beans! ");
                    return false;
                } else if (coffeeBeanSupply < 20) {
                    System.out.println("Sorry, not enough coffee beans! ");
                    return false;
                }
                break;
            case "3":
                if (waterSupply < 200) {
                    System.out.println("Sorry, not enough water! ");
                    return false;
                } else if (milkSupply < 100) {
                    System.out.println("Sorry, not enough coffee beans! ");
                    return false;
                } else if (coffeeBeanSupply < 12) {
                    System.out.println("Sorry, not enough coffee beans! ");
                    return false;
                }
                break;
        }
        return true;
    }

    public static void fillAction() {
        System.out.println("Write how many ml of water you want to add: ");
        waterSupply += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkSupply += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeanSupply += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cupsSupply += sc.nextInt();
    }

    public static void takeAction() {
        System.out.printf("I gave you $%d %n", moneyPresent);
        moneyPresent = 0;
    }

    public static void coffeeMachineStatus() {
        System.out.printf("The coffee machine has: %n");
        System.out.printf("%d ml of water %n", waterSupply);
        System.out.printf("%d ml of milk %n", milkSupply);
        System.out.printf("%d g of coffee beans %n", coffeeBeanSupply);
        System.out.printf("%d disposable cups %n", cupsSupply);
        System.out.printf("$%d of money %n", moneyPresent);
    }

    public static void requirements(int noOfCups) {
        System.out.printf("For %d cups of coffee you will need:%n", noOfCups);
        int waterRequired = noOfCups * 200;
        System.out.printf("%d ml of water %n", waterRequired);
        int milkRequired = noOfCups * 50;
        System.out.printf("%d ml of milk %n", milkRequired);
        int coffeeBeenRequired = noOfCups * 15;
        System.out.printf("%d g of coffee beans %n", coffeeBeenRequired);
    }

    public static int noCoffeeCanMake(int water, int milk, int coffeeBean) {
        int waterUsed = water / 200;
        int milkUsed = milk / 50;
        int coffeeBeanUsed = coffeeBean / 15;
        return Math.min(waterUsed , Math.min(milkUsed, coffeeBeanUsed));
    }
}
