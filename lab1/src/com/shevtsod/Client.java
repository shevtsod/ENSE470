/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

    /**
     * Main program entry point
     *
     * @param args Console arguments to program (unused)
     */
    public static void main(String[] args) {

        Client2 program = new Client2();

        Scanner input = new Scanner(System.in, "UTF-8");
        int userInput = -1;
        char userInputChar = 'F';

        System.out.println("PRODUCT ORDERING SYSTEM");
        System.out.println("Add products A and B to your cart, and check-out when finished." +
                "\nThe price of your orders will be displayed at check-out." +
                "\n\nProduct A - $4.99\t\t\tProduct B - $9.99\n");

        System.out.println("Enter your credit rating between A and F: ");

        boolean correctInput = false;
        do {
            System.out.print("\tINPUT: ");
            try {
                userInputChar = input.next().charAt(0);
                if (
                        Character.toUpperCase(userInputChar) >= 'A' &&
                        Character.toUpperCase(userInputChar) <= 'F')
                    correctInput = true;
                else
                    System.out.println("ERROR: Input must be in range A to F");
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                input.nextLine();
            }
        } while (!correctInput);

        //Could add I/O to initialize other data in customer of customer, only rating really matters
        Customer c = new PersonalCustomer(
                "Test Customer",
                "123 Fake St.",
                userInputChar,
                "111111111"
        );

        Order myOrder = new Order(c);

        while(userInput != 2) {

            System.out.println("Press 0 to add product A, 1 to add product B, 2 to check-out");

            correctInput = false;
            do {
                System.out.print("\tINPUT: ");
                try {
                    userInput = input.nextInt();
                    if (userInput == 0 || userInput == 1 || userInput == 2)
                        correctInput = true;
                    else
                        System.out.println("ERROR: Input must be in range 0 to 2");
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Invalid input");
                    input.nextLine();
                }
            } while (!correctInput);

            //Input = 0 -> Add product A
            //      = 1 -> Add product B
            //      = 2 -> Checkout
            switch(userInput) {
                case 0:
                    myOrder.addProduct(new Product(new BigDecimal(4.99)));
                    System.out.println("Added Product A to cart");
                    break;
                case 1:
                    myOrder.addProduct(new Product(new BigDecimal(9.99)));
                    System.out.println("Added product B to cart");
                    break;
            }

        }

        DecimalFormat currency = new DecimalFormat("#,###.##");
        DecimalFormat percent = new DecimalFormat("###");

        System.out.println("Checked-out successfully");
        System.out.println("\tTotal price:\t\t$" + currency.format(myOrder.calculatePrice()));
        System.out.println("Billing Information:" +
                        "\n\tName:\t\t\t\t" + c.getName() +
                        "\n\tAddress:\t\t\t" + c.getAddress() +
                        "\n\tCredit Rating:\t\t" + c.getCreditRating() +
                " (" + percent.format(c.getDiscountInfo().multiply(new BigDecimal(100))) + "% discount)");

        input.close();

    }

}
