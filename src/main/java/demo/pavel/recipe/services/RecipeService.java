package demo.pavel.recipe.services;

import java.util.Set;

import demo.pavel.recipe.commands.RecipeCommand;
import demo.pavel.recipe.model.Recipe;

public interface RecipeService {

	Set<Recipe> findRecipes();

	Recipe findRecipeById(Long id);

	RecipeCommand findCommandById(Long id);

	RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

	void deleteById(Long id);
}
