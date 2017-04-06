package com.shevtsod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class RecipeBook {
    private List<Recipe> recipes = new ArrayList<>();

    /**
     * Add an ingredient to this Recipe
     * @param name String name of Recipe
     * @param ingredients List of ingredients in this Recipe
     * @return true as specified by {@link java.util.Collection#add}
     */
    public boolean addRecipe(String name, List<Ingredient> ingredients) {
        if(name.isEmpty() || ingredients.isEmpty())
            return false;

        //Convert name and ingredients to lower case
        name = name.toLowerCase();
        for(Ingredient i: ingredients) {
            i.setName(i.getName().toLowerCase());
        }

        //Check if this recipe already exists. If so, return false
        for(Recipe r : recipes) {
            if(r.getName().equals(name))
                return false;
        }

        //Create a new Recipe object and populate it with the given data
        Recipe recipe = new Recipe();
        recipe.setName(name);

        for(Ingredient ingredient : ingredients)
            recipe.addIngredient(ingredient.getName(), ingredient.getQuantity());

        return recipes.add(recipe);
    }

    /**
     * Edit an existing Recipe in this RecipeBook (change its ingredients)
     * @param name String name of Recipe
     * @param ingredients New List of ingredients in this Recipe
     * @return true if edit was successful
     */
    public boolean editRecipe(String name, List<Ingredient> ingredients) {
        if(name.isEmpty() || ingredients.isEmpty())
            return false;

        //Convert name and ingredients to lower case
        name = name.toLowerCase();
        for(Ingredient i: ingredients) {
            i.setName(i.getName().toLowerCase());
        }

        //Find this Recipe in the list of recipes
        Recipe recipeToEdit = null;

        for(Recipe r : recipes) {
            if(r.getName().equals(name))
                recipeToEdit = r;
        }

        //If the Recipe wasn't found, return false
        if(recipeToEdit == null)
            return false;

        //If the recipe was found, clear its ingredients and replace with the new ingredients
        recipeToEdit.removeAllIngredients();
        for(Ingredient ingredient : ingredients) {
            recipeToEdit.addIngredient(ingredient.getName(), ingredient.getQuantity());
        }

        return true;
    }

    /**
     * Remove a Recipe from this RecipeBook
     * @param name String name of Recipe
     * @return true if the element was removed
     */
    public boolean removeRecipe(String name) {
        if(name.isEmpty() || recipes.isEmpty())
            return false;

        //Convert name to lower case
        name = name.toLowerCase();

        //Find the recipe to delete and return true if it was deleted
        for(Recipe r : recipes) {
            if(r.getName().equals(name))
                return recipes.remove(r);
        }

        //Return false if recipe was not found
        return false;
    }

    /**
     * Get aa List of all recipes in this RecipeBook to iterate through
     * @return List of Recipes
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
