package com.shevtsod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Recipe {
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();

    /**
     * Get the name of this Recipe
     * @return String name of this Recipe
     */
    public String getName() {
        return name;
    }

    /**
     * Set a name for this Recipe
     * @param name String name of this Recipe
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get a list of all ingredients in this recipe to iterate through and read
     * @return List of Ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Add an ingredient to this Recipe
     * @param name String name of this ingredient
     * @param quantity int quantity of this ingredient
     * @return true as specified by {@link java.util.Collection#add}
     */
    public boolean addIngredient(String name, int quantity) {
        return ingredients.add(new Ingredient(name, quantity));
    }

    /**
     * Remove an ingredient from this Recipe
     * @param ingredient String name of ingredient
     * @return true if the element was removed
     */
    public boolean removeIngredient(String ingredient) {
        return ingredients.remove(ingredient);
    }

    /**
     * Remove all ingredients in this Recipe
     */
    public void removeAllIngredients() {
        ingredients.clear();
    }
}
