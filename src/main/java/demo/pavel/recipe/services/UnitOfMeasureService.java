package demo.pavel.recipe.services;

import java.util.Set;

import demo.pavel.recipe.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

	Set<UnitOfMeasureCommand> listAllUoms();
}
