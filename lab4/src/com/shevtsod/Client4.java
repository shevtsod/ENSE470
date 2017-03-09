package com.shevtsod;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Client4 {
    private CoffeeMaker myCoffeeMaker;
    private Scanner input;

    /**
     * Constructor for class Client4, initializes a new Client4 object
     */
    public Client4() {
        myCoffeeMaker = new CoffeeMaker();
        input = new Scanner(System.in, "UTF-8");
    }

    /**
     * Main program entry point
     * @param args String arguments from console (unused)
     */
    public static void main(String[] args) {
        System.out.println("COFFEE MAKER SIMULATION");
        System.out.println("This coffee maker allows you to add and edit recipes and inventory, "
                + "and make coffee.");

        Client4 client = new Client4();

        client.programLoop();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                         HELPER METHODS                                               //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The program loop in which the user interacts with the coffee maker until deciding to exit the program
     */
    private void programLoop() {
        int userInput = 0;

        // Loop until inventory is empty
        while(userInput != -1) {

            // Print current coffee maker status
            myCoffeeMaker.printCurrentInventory();
            myCoffeeMaker.printCurrentRecipes();

            // Print list of currently available options
            System.out.println("COMMANDS:" +
                    "\n\t0\t- Add a recipe" +
                    "\n\t1\t- Edit a recipe" +
                    "\n\t2\t- Delete a recipe" +
                    "\n\t3\t- Add Inventory" +
                    "\n\t4\t- Edit Inventory" +
                    "\n\t5\t- Delete Inventory" +
                    "\n\t6\t- Make Coffee" +
                    "\n\t-1\t- Exit Program");

            // Get a new integer from user input
            userInput = this.getIntFromScanner(-1, 6);

            // Process user input and send program to the appropriate handler
            switch(userInput) {
                // Add a recipe
                case 0: System.out.println("ERROR: WIP - Not Completed Yet");
                    break;
                // Edit a recipe
                case 1: System.out.println("ERROR: WIP - Not Completed Yet");
                    break;
                // Delete a recipe
                case 2: System.out.println("ERROR: WIP - Not Completed Yet");
                    break;
                // Add Inventory
                case 3: optionAddInventory();
                    break;
                // Edit Inventory
                case 4: optionEditInventory();
                    break;
                // Delete Inventory
                case 5: optionDeleteInventory();
                    break;
                // Make Coffee
                case 6: System.out.println("ERROR: WIP - Not Completed Yet");
                    break;
                default:
                    break;
            } // switch
        } // while

        input.close();

        System.out.println("INFO: -1 entered, program terminated");

    }

    /**
     * Helper method to handle adding inventory from user input
     */
    private void optionAddInventory() {
        //Populate a new Reservoir from user input and add it to inventory
        System.out.println("Enter name of new Reservoir: ");
        String name = getStringFromScanner();
        System.out.println("Enter price per unit: (price > 0)");
        double price = getDoubleFromScanner(0.01, Double.MAX_VALUE);
        System.out.println("Enter capacity of Reservoir: (capacity > 0)");
        int capacity = getIntFromScanner(1, Integer.MAX_VALUE);

        myCoffeeMaker.getInventory().addReservoir(name, price, capacity);
    }

    /**
     * Helper method to handle editing inventory from user input
     */
    private void optionEditInventory() {
        //Populate the new information for the Reservoir from user input
        System.out.println("Enter name of existing Reservoir: ");
        String name = getStringFromScanner();
        System.out.println("Enter new name for this Reservoir: (to keep existing name, enter \"" + name + "\")");
        String newName = getStringFromScanner();
        System.out.println("Enter new price per unit: (price > 0)");
        double newPrice = getDoubleFromScanner(0.01, Double.MAX_VALUE);
        System.out.println("Enter new capacity of Reservoir: (capacity > 0)");
        int newCapacity = getIntFromScanner(1, Integer.MAX_VALUE);

        myCoffeeMaker.getInventory().editReservoir(name, newName, newPrice, newCapacity);
    }

    /**
     * Helper method to handle deleting inventory from user input
     */
    private void optionDeleteInventory() {
        System.out.println("Enter name of existing Reservoir: ");
        String name = getStringFromScanner();

        myCoffeeMaker.getInventory().removeReservoir(name);
    }

    //TODO: Add other options for next phase


    /**
     * Get an int of input from a Scanner object
     * @param lLimit int Lower limit (user input >= lower limit)
     * @param uLimit int Upper limit (user input <= upper limit)
     * @return int input from Scanner
     */
    private int getIntFromScanner(int lLimit, int uLimit) {
        int userInput = 0;
        boolean correctInput = false;

        do {
            System.out.print("INPUT: ");
            try {
                userInput = input.nextInt();
                if(userInput >= lLimit && userInput <= uLimit)
                    correctInput = true;
                else
                    System.out.println("ERROR: Invalid input");
                input.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                input.nextLine();
            }
        } while(!correctInput);

        return userInput;
    }

    /**
     * Get a double of input from a Scanner object
     * @param lLimit double Lower limit (user input >= lower limit)
     * @param uLimit double Upper limit (user input >= upper limit)
     * @return double input from Scanner
     */
    private double getDoubleFromScanner(double lLimit, double uLimit) {
        double userInput = 0;
        boolean correctInput = false;

        do {
            System.out.print("INPUT: ");
            try {
                userInput = input.nextDouble();
                if(userInput >= lLimit && userInput <= uLimit)
                    correctInput = true;
                else
                    System.out.println("ERROR: Invalid input");
                input.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                input.nextLine();
            }
        } while(!correctInput);

        return userInput;
    }

    /**
     * Get a String line of input from a Scanner object
     * @return String from single line of user input from Scanner
     */
    private String getStringFromScanner() {
        String userInputString = "";
        boolean correctInput = false;

        do {
            System.out.print("INPUT: ");
            try {
                userInputString = input.nextLine();
                correctInput = true;
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Invalid input");
                input.nextLine();
            }
        } while(!correctInput);

        return userInputString;
    }
}
