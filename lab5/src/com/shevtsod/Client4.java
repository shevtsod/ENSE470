package com.shevtsod;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Client4 {
    //Get the singleton coffee maker object
    private CoffeeMaker myCoffeeMaker = CoffeeMaker.getInstance();
    private Scanner input;

    /**
     * Constructor for class Client4, initializes a new Client4 object
     */
    public Client4() {
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

        //Preload the coffee maker with some reservoirs and recipes
        client.preloadCoffeeMaker();

        client.programLoop();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                         HELPER METHODS                                               //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Helper method to preload the coffee maker with some initial recipes and reservoirs
     */
    private void preloadCoffeeMaker() {
        //REMOVE THESE TO CREATE AN EMPTY COFFEEMAKER
        myCoffeeMaker.getInventory().addReservoir("Coffee Beans", 5.50, 10);
        myCoffeeMaker.getInventory().addReservoir("Milk", 3, 25);

        List<Ingredient> recipe1Ingredients = new ArrayList<>();
        recipe1Ingredients.add(new Ingredient("Coffee Beans", 2));
        recipe1Ingredients.add(new Ingredient("Milk", 2));
        myCoffeeMaker.getRecipeBook().addRecipe("Espresso", recipe1Ingredients);

        List<Ingredient> recipe2Ingredients = new ArrayList<>();
        recipe2Ingredients.add(new Ingredient("Coffee Beans", 30));
        recipe2Ingredients.add(new Ingredient("Milk", 30));
        myCoffeeMaker.getRecipeBook().addRecipe("Cappuccino", recipe2Ingredients);

        List<Ingredient> recipe3Ingredients = new ArrayList<>();
        recipe3Ingredients.add(new Ingredient("Coffee Beans", 5));
        recipe3Ingredients.add(new Ingredient("Milk", 5));
        recipe3Ingredients.add(new Ingredient("Chocolate", 7));
        myCoffeeMaker.getRecipeBook().addRecipe("Latte", recipe3Ingredients);
    }

    /**
     * The program loop in which the user interacts with the coffee maker until deciding to exit the program
     */
    private void programLoop() {
        int userInput = 0;

        // Loop until inventory is empty
        while(userInput != -1) {

            // Print current coffee maker status
            System.out.println();
            myCoffeeMaker.printCurrentInventory();
            myCoffeeMaker.printCurrentRecipes();

            // Print list of currently available options
            System.out.println("\nCOMMANDS:" +
                    "\n\t0\t- Add a Recipe" +
                    "\n\t1\t- Edit a Recipe" +
                    "\n\t2\t- Delete a Recipe" +
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
                case 0: optionAddRecipe();
                    break;
                // Edit a recipe
                case 1: optionEditRecipe();
                    break;
                // Delete a recipe
                case 2: optionDeleteRecipe();
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
                case 6: optionMakeCoffee();
                    break;
                default:
                    break;
            } // switch
        } // while

        input.close();

        System.out.println("INFO: -1 entered, program terminated");

    }

    /**
     * Helper method to handle adding a recipe from user input
     */
    private void optionAddRecipe() {
        //Populate a new Recipe from user input and add it to RecipeBook
        System.out.println("Enter name of new recipe:");
        String name = getStringFromScanner();

        //Until user enters "done", keep asking for recipe ingredients
        String ingredientName = "";
        int ingredientQuantity;
        List<Ingredient> ingredients = new ArrayList<>();
        while(!ingredientName.toLowerCase().equals("done")) {
            System.out.println("Enter an ingredient for this recipe: (Enter 'done' to finish)");
            ingredientName = getStringFromScanner();

            //Check that the list doesn't already contain an ingredient with this name
            boolean skipIteration = false;
            for(Ingredient i : ingredients) {
                if(i.getName().equals(ingredientName.toLowerCase()))
                    skipIteration = true;
            }

            if(skipIteration || ingredientName.toLowerCase().equals("done"))
                continue;

            System.out.println("Enter the quantity for this ingredient:");
            ingredientQuantity = getIntFromScanner(1, Integer.MAX_VALUE);

            ingredients.add(new Ingredient(ingredientName.toLowerCase(), ingredientQuantity));
        }

        //Add a new Recipe with this name and list of ingredients
        boolean result = myCoffeeMaker.getRecipeBook().addRecipe(name, ingredients);

        //Output to the user the result of this operation
        if(result)
            System.out.println("INFO: Recipe " + name.toLowerCase() + " was added successfully");
        else
            System.out.println("ERROR: Could not add recipe " + name.toLowerCase());
    }

    /**
     * Helper method to handle editing a recipe from user input
     */
    private void optionEditRecipe() {
        //Get name of existing recipe
        System.out.println("Enter name of existing recipe:");
        String name = getStringFromScanner();

        System.out.println("Enter new ingredients for this recipe:");

        //Until user enters "done", keep asking for recipe ingredients
        String ingredientName = "";
        int ingredientQuantity;
        List<Ingredient> ingredients = new ArrayList<>();
        while(!ingredientName.toLowerCase().equals("done")) {
            System.out.println("Enter an ingredient for this recipe: (Enter 'done' to finish)");
            ingredientName = getStringFromScanner();

            //Check that the list doesn't already contain an ingredient with this name
            boolean skipIteration = false;
            for(Ingredient i : ingredients) {
                if(i.getName().equals(ingredientName.toLowerCase()))
                    skipIteration = true;
            }

            if(skipIteration || ingredientName.toLowerCase().equals("done"))
                continue;

            System.out.println("Enter the quantity for this ingredient:");
            ingredientQuantity = getIntFromScanner(1, Integer.MAX_VALUE);

            ingredients.add(new Ingredient(ingredientName.toLowerCase(), ingredientQuantity));
        }

        //Edit the existing Recipe with this name and the new list of ingredients
        boolean result = myCoffeeMaker.getRecipeBook().editRecipe(name, ingredients);

        //Output to the user the result of this operation
        if(result)
            System.out.println("INFO: Recipe " + name.toLowerCase() + " was edited successfully");
        else
            System.out.println("ERROR: Could not edit recipe " + name.toLowerCase());
    }

    /**
     * Helper method to handle deleting a recipe from user input
     */
    private void optionDeleteRecipe() {
        //Get name of existing recipe
        System.out.println("Enter name of existing recipe:");
        String name = getStringFromScanner();

        //Delete the exisitng Recipe with this name
        boolean result = myCoffeeMaker.getRecipeBook().removeRecipe(name);

        if(result)
            System.out.println("INFO: Recipe " + name.toLowerCase() + " was deleted successfully");
        else
            System.out.println("ERROR: Could not delete recipe " + name.toLowerCase());
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

    /**
     * Helper method to handle making coffee from user input
     */
    private void optionMakeCoffee() {
        //Get recipe from user input, return if it does not exist
        System.out.println("Enter name of recipe to make coffee from:");
        String name = getStringFromScanner().toLowerCase();

        Recipe recipe = null;
        for(Recipe r : myCoffeeMaker.getRecipeBook().getRecipes())
            if(r.getName().equals(name))
                recipe = r;

        if(recipe == null) {
            System.out.println("ERROR: Recipe " + name + " does not exist");
            return;
        }

        //Check the inventory to see if it has the required ingredients in its reservoirs
        List<Reservoir> ingredientReservoirs = new ArrayList<>();

        for(Reservoir r : myCoffeeMaker.getInventory().getReservoirs()) {
            //If this reservoir is also in the recipe's ingredients, add it to the list of ingredients
            //Make sure that the reservoir has enough quantity remaining with respect to the recipe's requirements
            for(Ingredient i : recipe.getIngredients()) {

                if(i.getName().equals(r.getName())) {

                    if(r.getRemaining() < i.getQuantity()) {
                        System.out.println("ERROR: Not enough quantity of " + r.getName() + " remaining for this recipe");
                        return;
                    }

                    ingredientReservoirs.add(r);
                }
            }
        }

        if(ingredientReservoirs.size() != recipe.getIngredients().size()) {
            System.out.println("ERROR: Coffee Maker does not have all the required ingredients!");
            return;
        }

        double price = 0;

        //Make the coffee by subtracting quantity remaining in reservoirs from recipe's requirements
        for(Reservoir r : ingredientReservoirs)
            for(Ingredient i: recipe.getIngredients())
                if(r.getName().equals(i.getName())) {
                    r.setRemaining(r.getRemaining() - i.getQuantity());
                    price += r.getPrice() * i.getQuantity();
                }

        //Output receipt
        DecimalFormat df = new DecimalFormat("$#,###.00");

        System.out.println("INFO: Made coffee from recipe \"" + recipe.getName() + "\"");
        System.out.println("INFO: Total cost: " + df.format(price));

    }




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
