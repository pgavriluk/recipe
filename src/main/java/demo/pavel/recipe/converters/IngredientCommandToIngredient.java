package demo.pavel.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import demo.pavel.recipe.commands.IngredientCommand;
import demo.pavel.recipe.model.Ingredient;
import lombok.Synchronized;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand,Ingredient> {

	private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

	public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public Ingredient convert(IngredientCommand ingredientCommand) {
		if (ingredientCommand == null) {
			return null;
		}

		final Ingredient ingredient = new Ingredient();
		ingredient.setId(ingredientCommand.getId());
		ingredient.setAmount(ingredientCommand.getAmount());
		ingredient.setDescription(ingredientCommand.getDescription());
		ingredient.setUom(uomConverter.convert(ingredientCommand.getUom()));
		return ingredient;
	}
}
