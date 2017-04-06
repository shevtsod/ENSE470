package com.shevtsod;

import java.text.DecimalFormat;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class CoffeeMaker {
    private static final CoffeeMaker INSTANCE = new CoffeeMaker();
    private Inventory inventory;
    private RecipeBook recipeBook;

    /**
     * Constructor, creates a new CoffeeMaker object
     * Private, so it cannot be accessed by user. Call getInstance() instead
     */
    private CoffeeMaker() {
        inventory = new Inventory();
        recipeBook = new RecipeBook();
    }

    /**
     * Return the singleton instance of CoffeeMaker to the caller
     * @return CoffeeMaker singleton object
     */
    public static CoffeeMaker getInstance() {
        return INSTANCE;
    }

    /**
     * Get the Inventory of this CoffeeMaker
     * @return Inventory of this CoffeeMaker object
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Get the RecipeBook of this CoffeeMaker
     * @return RecipeBook of this CoffeeMaker object
     */
    public RecipeBook getRecipeBook() {
        return recipeBook;
    }

    /**
     * Print a formatted list of all reservoirs in the Inventory and their details
     */
    public void printCurrentInventory() {
        System.out.println("CURRENT INVENTORY:");
        //Check if inventory is empty
        if(inventory.getReservoirs().isEmpty()) {
            System.out.println(" - None");
            return;
        }

        //If reach here, iterate through the inventory
        DecimalFormat df = new DecimalFormat("$#,###.00");
        for(Reservoir res : inventory.getReservoirs()) {
            System.out.println(" - " + res.getName() +
                    " (Price/Unit: " + df.format(res.getPrice()) + "  " +
                    " Quantity: " + res.getRemaining() + "/" + res.getCapacity() + ")");
        }
    }

    /**
     * Print a formatted list of all recipes stored in this CoffeeMaker
     */
    public void printCurrentRecipes() {
        System.out.println("CURRENT RECIPES:");
        //Check if RecipeBook is empty
        if(recipeBook.getRecipes().isEmpty()) {
            System.out.println(" - None");
            return;
        }

        //If reach here, iterate through the RecipeBook
        for(Recipe r : recipeBook.getRecipes()) {
            System.out.print(" - " + r.getName() + " (Ingredients: ");
            //Iterate through list of ingredients of this recipe
            for(Ingredient i : r.getIngredients())
                System.out.print(i.getName() + " (Q:" + i.getQuantity() + ")   ");
            System.out.print(")\n");
        }
    }
}
