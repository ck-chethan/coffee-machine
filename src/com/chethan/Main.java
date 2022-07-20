package com.chethan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.println("Write how many cups of coffee you will need: ");
//        int noOfCups = sc.nextInt();
//        requirements(noOfCups);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterSupply = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkSupply = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansSupply = sc.nextInt();

        int coffeesCanMake = noCoffeeCanMake(waterSupply, milkSupply, coffeeBeansSupply);

        System.out.println("Write how many cups of coffee you will need: ");
        int coffeeRequired = sc.nextInt();

        if (coffeeRequired == coffeesCanMake) {
            System.out.println("Yes, I can make that amount of coffee ");

        } else if (coffeeRequired < coffeesCanMake) {
            int noOfMoreCoffee = coffeesCanMake - coffeeRequired;
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that) %n", noOfMoreCoffee);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", coffeesCanMake);
        }

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
