package com.chethan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need: ");
        int noOfCups = sc.nextInt();
        requirements(noOfCups);
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
}
