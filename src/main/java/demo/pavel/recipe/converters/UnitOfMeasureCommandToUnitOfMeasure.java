package demo.pavel.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import demo.pavel.recipe.commands.UnitOfMeasureCommand;
import demo.pavel.recipe.model.UnitOfMeasure;
import lombok.Synchronized;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand,UnitOfMeasure> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
		if (unitOfMeasureCommand == null) {
			return null;
		}

		final UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(unitOfMeasureCommand.getId());
		uom.setDescription(unitOfMeasureCommand.getDescription());
		return uom;
	}
}
