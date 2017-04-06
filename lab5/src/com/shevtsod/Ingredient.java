package com.shevtsod;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Ingredient {
    private String name;
    private int quantity;

    /**
     * Constructor to initialize a new Ingredient with given values
     * @param name String name of this Ingredient
     * @param quantity int quantity of this Ingredient
     */
    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Get the name of this Ingredient
     * @return String name of this Ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Set the new name of this Ingredient
     * @param name New String name of this Ingredient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the int quantity of this Ingredient
     * @return int quantity of this Ingredient
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the new quantity of this Ingredient
     * @param quantity New int quantity of this Ingredient
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
