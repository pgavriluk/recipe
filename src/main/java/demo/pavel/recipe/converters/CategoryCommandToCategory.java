package demo.pavel.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import demo.pavel.recipe.commands.CategoryCommand;
import demo.pavel.recipe.model.Category;
import lombok.Synchronized;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand,Category> {

	@Synchronized
	@Nullable
	@Override
	public Category convert(CategoryCommand categoryCommand) {
		if (categoryCommand == null) {
			return null;
		}

		final Category category = new Category();
		category.setId(categoryCommand.getId());
		category.setDescription(categoryCommand.getDescription());
		return category;
	}
}
