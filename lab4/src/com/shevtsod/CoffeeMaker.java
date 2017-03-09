package com.shevtsod;

import com.shevtsod.Reservoir.Reservoir;

import java.text.DecimalFormat;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class CoffeeMaker {
    private Inventory inventory;

    /**
     * Constructor, creates a new CoffeeMaker object
     */
    public CoffeeMaker() {
        inventory = new Inventory();
    }

    /**
     * Get the Inventory of this CoffeeMaker
     * @return Inventory of this CoffeeMaker object
     */
    public Inventory getInventory() {
        return inventory;
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
                    " (Price/Unit: " + df.format(res.getPrice()) +
                    " Quantity: " + res.getRemaining() + "/" + res.getCapacity() + ")");
        }
    }

    /**
     * Print a formatted list of all recipes stored in this CoffeeMaker
     */
    public void printCurrentRecipes() {
        System.out.println("CURRENT RECIPES:");
        //TODO: Add printCurrentRecipes() for next phase
        System.out.println("WARN: WIP - Not Completed Yet");
    }
}
