package demo.pavel.recipe.services;

import demo.pavel.recipe.commands.IngredientCommand;

public interface IngredientService {

	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

	IngredientCommand saveIngredientCommand(IngredientCommand command);

	void deleteIngredientById(Long recipeId, Long id);
}
